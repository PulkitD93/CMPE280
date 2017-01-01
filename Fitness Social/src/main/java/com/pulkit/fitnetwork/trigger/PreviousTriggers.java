package com.pulkit.fitnetwork.trigger;

import com.pulkit.fitnetwork.model.Trigger.*;
import com.pulkit.fitnetwork.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by shikh on 01-Dec-16.
 */
public class PreviousTriggers {


    public static String DAILY_ACTVITY_SUMMARY_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/activities/date/[date].json";
    public static String FOOD_LOGS_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/foods/log/date/[date].json";
    public static String WATER_GOALS_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/foods/log/water/goal.json";
    public static String USER_PROFILE_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/profile.json";
    public String url = "https://api.fitbit.com/1/user/4YF44L/foods/log/water/goal.json";

    private String getUsersQuery = "select * from user";
    private String checkDashboardQuery = "select count(*) as count from dashboard where userId = ? and recdate = ?;";
    private String insertIntoDashboard = "insert into dashboard(recdate,stepCount,caloriesBurnt,caloriesGoal,waterConsumed,waterGoal,userId) " +
            "values(?,?,?,?,?,?,?);";
    private String updateIntoDashboard = "update dashboard set stepCount = ?,caloriesBurnt = ?,caloriesGoal = ?,waterConsumed = ?,waterGoal = ? where userId = ? and recdate = ?;";
    private String description = "";

    @Autowired
    private JdbcOperations jdbcOperations;

    public PreviousTriggers() {
    }

    public List<User> getAllUsers() {
        List<User> users = null;
        users = jdbcOperations.query(getUsersQuery, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    public void runMain(Date date) {
        List<User> users = getAllUsers();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat dateFormatDashBoard = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(date));
        for (int i = 0; i < users.size(); i++) {
            User obj = users.get(i);
            System.out.println("Token: " + obj.getFitbitToken());
            DailyActivity DA = getDailySummary(obj.getFitbitUserID(), obj.getFitbitToken(), dateFormat.format(date));
            WaterGoal WA = getWaterGoal(obj.getFitbitUserID(), obj.getFitbitToken());
            UserProfile UP = getUserProfile(obj.getFitbitUserID(), obj.getFitbitToken());
            FoodLogs FL = getFoodLogs(obj.getFitbitUserID(), obj.getFitbitToken(), dateFormat.format(date));

            List<TopBadge> topBadges = UP.getUser().getTopBadges();


            int sendentaryMinutes = 0, caloriesGoal = 0, stepsCount = 0, dailyStepsGoal = 0, waterGoal = 0, caloriesBurnt = 0;
            Double waterConsumed = 0.0;

            if (DA.getSummary() != null) {
                sendentaryMinutes = DA.getSummary().getSedentaryMinutes();
                stepsCount = DA.getSummary().getSteps();
                caloriesBurnt = DA.getSummary().getCaloriesOut();
                waterConsumed = FL.getSummary().getWater();
            }

            if (DA.getGoals() != null) {
                caloriesGoal = DA.getGoals().getCaloriesOut();
                dailyStepsGoal = DA.getGoals().getSteps();

            }

            if (WA.getGoal() != null) {
                waterGoal = WA.getGoal().getGoal();
            }

            //update dashboard table
            updateDashBoardTable(dateFormatDashBoard.format(date), stepsCount, caloriesBurnt, caloriesGoal, waterConsumed, waterGoal, obj.getUserId());

            if (stepsCount > dailyStepsGoal) {

                description = "I just passed my personal step goal with " + stepsCount + " steps.";
                jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
            }

            if (caloriesBurnt > caloriesGoal && caloriesGoal > 0) {
                description = "Congrats on achieving your personal Calories Goal. Good job on the burning " + caloriesBurnt + " calories";
                jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
            }

            if (waterConsumed >= waterGoal) {
                description = "Congrats on achieving the Water Goal. Good job on drinking " + waterConsumed;
                jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
            }


            if (stepsCount > 1000) {

                description = "I just completed my first 1000 steps today.";
                jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
            }

            if (stepsCount > 2000) {

                description = "I just completed my first 2000 steps today.";
                jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
            }

            if (stepsCount > 5000) {

                description = "I just completed my first 5000 steps today.";
                jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
            }

            for (int k = 0; k < topBadges.size(); k++) {
                TopBadge TB = topBadges.get(k);
                String badgeDescription = "I just earned a new badge of " + TB.getDescription();


                jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", badgeDescription, obj.getUserId(), dateFormat.format(date));
            }

            if (sendentaryMinutes > 1000) {

                description = "I have been sitting idle for " + sendentaryMinutes + " minutes. I must exercise.";
                jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
            }


        }

    }


    public DailyActivity getDailySummary(String userID, String token, String date) {
        date = date.replace("/", "-");
        String DAILY_ACTVITY_SUMMARY_FITBIT_APIS = "https://api.fitbit.com/1/user/" + userID + "/activities/date/" + date + ".json";
        token = "Bearer " + token;
        System.out.println("Printing token and url : ");
        System.out.println(DAILY_ACTVITY_SUMMARY_FITBIT_APIS);
        System.out.println(token);


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<DailyActivity> entity = new HttpEntity<>(headers);
        ResponseEntity<DailyActivity> result = restTemplate.exchange(DAILY_ACTVITY_SUMMARY_FITBIT_APIS, HttpMethod.GET, entity, DailyActivity.class);

        return result.getBody();
    }

    public WaterGoal getWaterGoal(String userID, String token) {
        String WATER_GOAL_FITBIT_APIS = "https://api.fitbit.com/1/user/" + userID + "/foods/log/water/goal.json";
        token = "Bearer " + token;
        System.out.println("Printing token and url : ");
        System.out.println(WATER_GOAL_FITBIT_APIS);
        System.out.println(token);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<WaterGoal> entity = new HttpEntity<>(headers);
        ResponseEntity<WaterGoal> result = restTemplate.exchange(WATER_GOAL_FITBIT_APIS, HttpMethod.GET, entity, WaterGoal.class);

        return result.getBody();
    }

    public UserProfile getUserProfile(String userID, String token) {
        String USER_PROFILE_FITBIT_APIS = "https://api.fitbit.com/1/user/" + userID + "/profile.json";
        token = "Bearer " + token;
        System.out.println("Printing token and url : ");
        System.out.println(USER_PROFILE_FITBIT_APIS);
        System.out.println(token);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<UserProfile> entity = new HttpEntity<>(headers);
        ResponseEntity<UserProfile> result = restTemplate.exchange(USER_PROFILE_FITBIT_APIS, HttpMethod.GET, entity, UserProfile.class);

        return result.getBody();
    }


    public FoodLogs getFoodLogs(String userID, String token, String date) {
        date = date.replace("/", "-");
        String FOOD_LOGS_FITBIT_APIS = "https://api.fitbit.com/1/user/" + userID + "/foods/log/date/" + date + ".json";
        token = "Bearer " + token;
        System.out.println("Printing token and url : ");
        System.out.println(FOOD_LOGS_FITBIT_APIS);
        System.out.println(token);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<FoodLogs> entity = new HttpEntity<>(headers);
        ResponseEntity<FoodLogs> result = restTemplate.exchange(FOOD_LOGS_FITBIT_APIS, HttpMethod.GET, entity, FoodLogs.class);

        return result.getBody();
    }


    public void updateDashBoardTable(String recdate, int stepCount, int caloriesBurnt, int caloriesGoal, double waterConsumed, int waterGoal, long userId) {

        Integer count = jdbcOperations.queryForObject(checkDashboardQuery, Integer.class, userId, recdate);

        if (count == 0) {
            jdbcOperations.update(insertIntoDashboard, recdate, stepCount, caloriesBurnt, caloriesGoal, waterConsumed, waterGoal, userId);
        } else {
            jdbcOperations.update(updateIntoDashboard, stepCount, caloriesBurnt, caloriesGoal, waterConsumed, waterGoal, userId, recdate);
        }
    }

    public void generatePreviousTriggers() {

        for (int i = 4; i >= 0; i--) {

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -i);
            runMain(new Date(cal.getTimeInMillis()));
        }
    }


}
