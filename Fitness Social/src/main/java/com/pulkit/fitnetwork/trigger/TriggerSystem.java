package com.pulkit.fitnetwork.trigger;

import com.pulkit.fitnetwork.model.Trigger.*;
import com.pulkit.fitnetwork.model.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Shibu on 11/26/16.
 **/
public class TriggerSystem implements Runnable {


    public static String DAILY_ACTVITY_SUMMARY_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/activities/date/[date].json";
    public static String FOOD_LOGS_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/foods/log/date/[date].json";
    public static String WATER_GOALS_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/foods/log/water/goal.json";
    public static String USER_PROFILE_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/profile.json";
    public String url = "https://api.fitbit.com/1/user/4YF44L/foods/log/water/goal.json";

    private String searchProductByNameQuery = "select * from user";
    private String description = "";
    private JdbcOperations jdbcOperations;


    public BasicDataSource dataSources() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/sampledb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(10);
        return basicDataSource;
    }

    public JdbcOperations jdbcTemplates(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    public TriggerSystem() {
        jdbcOperations = jdbcTemplates(dataSources());
    }


    public List<User> getAllUsers() {
        List<User> users = null;

        if (jdbcOperations == null) {
            System.out.println("Youre null sir");
        } else

        {

            System.out.println("Not null..yaay");
            users = jdbcOperations.query(searchProductByNameQuery, new BeanPropertyRowMapper<>(User.class));

            if (users.isEmpty()) {
                System.out.println("Null is ");

            } else {
                System.out.println("not nUll");
            }
        }

        return users;
    }

    public void run() {

        while (true) {
            List<User> users = getAllUsers();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();

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
                    caloriesBurnt = FL.getSummary().getCalories();
                    waterConsumed = FL.getSummary().getWater();
                }

                if (DA.getGoals() != null) {
                    caloriesGoal = DA.getGoals().getCaloriesOut();

                    dailyStepsGoal = DA.getGoals().getSteps();

                }

                if (WA.getGoal() != null)
                    waterGoal = WA.getGoal().getGoal();


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


                if ((stepsCount > 5) && (stepsCount < 10)) {

                    description = "I just completed my first 1000 steps today.";
                    jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
                }

                if ((stepsCount > 10) && (stepsCount < 15)) {

                    description = "I just completed my first 2000 steps today.";
                    jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
                }

                if (stepsCount > 15) {

                    description = "I just completed my first 5000 steps today.";
                    jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
                }

                for (int k = 0; k < topBadges.size(); k++) {
                    TopBadge TB = topBadges.get(i);
                    String badgeDescription = "I just earned a new badge of " + TB.getDescription();


                    jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", badgeDescription, obj.getUserId(), dateFormat.format(date));
                }

                if (sendentaryMinutes > 1000) {

                    description = "I have been sitting idle for " + sendentaryMinutes + " minutes. I must exercise.";
                    jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
                }


            }

            try {
                Thread.sleep(2 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
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


}




/*
package com.shikher.fitnetwork.trigger;

import DailyActivity;
import FoodLogs;
import UserProfile;
import WaterGoal;

import com.shikher.fitnetwork.model.FitbitUser;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

import java.lang.*;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;


import TopBadge;
import WaterGoal;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;

import java.text.DateFormat;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.web.client.RestTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.text.SimpleDateFormat;
import java.lang.*;
import java.util.Calendar;


/**
 * Created by Shibu on 11/26/16.
**/

/*
public class TriggerSystem implements Runnable {

    public static String DAILY_ACTVITY_SUMMARY_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/activities/date/[date].json";
    public static String FOOD_LOGS_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/foods/log/date/[date].json";
    public static String WATER_GOALS_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/foods/log/water/goal.json";
    public static String USER_PROFILE_FITBIT_API = "https://api.fitbit.com/1/user/[user-id]/profile.json";
    public String url = "https://api.fitbit.com/1/user/4YF44L/foods/log/water/goal.json";
    public String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI0WUY0NEwiLCJhdWQiOiIyMjdYWkwiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJyc29jIHJzZXQgcmFjdCBybG9jIHJ3ZWkgcmhyIHJudXQgcnBybyByc2xlIiwiZXhwIjoxNDgwNjIxMTcwLCJpYXQiOjE0ODAwMTYzNzB9.LjTEnYtvZmeoGAckLEmvCcwIyogTKsZyK15gnv3MBY8";

    private String searchProductByNameQuery = "select * from user";
    private String description = "";
    private JdbcOperations jdbcOperations;


    public BasicDataSource dataSources() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3307/sampledb");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("sesame");
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(10);
        return basicDataSource;
    }

    public JdbcOperations jdbcTemplates(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    public TriggerSystem() {
        jdbcOperations = jdbcTemplates(dataSources());
    }


    public List<FitbitUser> getAllUsers() {
        List<FitbitUser> users = null;

        if (jdbcOperations == null) {
            System.out.println("Youre null sir");
        } else

        {

            System.out.println("Not null..yaay");
            users = jdbcOperations.query(searchProductByNameQuery, new BeanPropertyRowMapper<>(FitbitUser.class));

            if (users.isEmpty()) {
                System.out.println("Null is ");

            } else {
                System.out.println("not nUll");
            }
        }

        return users;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Entered trigger system");
            List<FitbitUser> users = getAllUsers();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            System.out.println(dateFormat.format(date));
            for (int i = 0; i < users.size(); i++) {
                FitbitUser obj = users.get(i);
                DailyActivity DA = getDailySummary(obj.getFitbitUserID(), dateFormat.format(date));
                WaterGoal WA = getWaterGoal(obj.getFitbitUserID());
                UserProfile UP = getUserProfile(obj.getFitbitUserID());
                //       FoodLogs FL = getFoodLogs(obj.getFitbitUserID(), "2016-11-25");

                List<TopBadge> topBadges = UP.getFitbitUser().getTopBadges();

                int sendentaryMinutes = DA.getSummary().getSedentaryMinutes();
                int caloriesGoal = DA.getGoals().getCaloriesOut();
                //      int caloriesBurnt = FL.getSummary().getCalories();

                int stepsCount = DA.getSummary().getSteps();
                int waterGoal = WA.getGoal().getGoal();
                //     Double waterConsumed = FL.getSummary().getWater();

                int dailyStepsGoal = DA.getGoals().getSteps();

                if (stepsCount > dailyStepsGoal) {

                    description = "Congrats on achieving your personal Steps Goal. Good job on the completing " + stepsCount + " steps";
                    jdbcOperations.update("insert into newsfeed (Description,userId,nfDateTime) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
                }

           /*         if(caloriesBurnt > caloriesGoal)
                    {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date = new Date();
                        description = "Congrats on achieving your personal Calories Goal. Good job on the burning "+caloriesBurnt+" calories" ;
                        jdbcOperations.update("insert into newsfeed (Description,userId,datetimeid) values (?,?,?)",description,obj.getUserId(),dateFormat.format(date));
                    }*/

                 /*   if(waterConsumed >= waterGoal)
                    {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date date = new Date();
                        description = "Congrats on achieving the Water Goal. Good job on drinking "+waterConsumed ;
                        jdbcOperations.update("insert into newsfeed (Description,userId,datetimeid) values (?,?,?)",description,obj.getUserId(),dateFormat.format(date));


                if ((stepsCount > 1000) && (stepsCount < 2000)) {

                    description = "Congrats on achieving 1000 steps";
                    jdbcOperations.update("insert into newsfeed (Description,userId,datetimeid) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
                }

                if ((stepsCount > 2000) && (stepsCount < 5000)) {

                    description = "Congrats on achieving 2000 steps";
                    jdbcOperations.update("insert into newsfeed (Description,userId,datetimeid) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
                }

                if (stepsCount > 5000) {

                    description = "Congrats on achieving 5000 steps";
                    jdbcOperations.update("insert into newsfeed (Description,userId,datetimeid) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
                }

                for (int k = 0; k < topBadges.size(); k++) {
                    TopBadge TB = topBadges.get(i);
                    String badgeDescription = "Congrats on achieving a badge. " + TB.getDescription();


                    jdbcOperations.update("insert into newsfeed (Description,userId,datetimeid) values (?,?,?)", badgeDescription, obj.getUserId(), dateFormat.format(date));
                }

                if (sendentaryMinutes > 1000) {

                    description = "FitbitUser has been sendentary for " + sendentaryMinutes + " minutes";
                    jdbcOperations.update("insert into newsfeed (Description,userId,datetimeid) values (?,?,?)", description, obj.getUserId(), dateFormat.format(date));
                }

            }

            try {
                Thread.sleep(5 * 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public DailyActivity getDailySummary(String userID, String date) {
        String DAILY_ACTVITY_SUMMARY_FITBIT_APIS = "https://api.fitbit.com/1/user/" + userID + "/activities/date/" + date + ".json";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<DailyActivity> entity = new HttpEntity<>(headers);
        ResponseEntity<DailyActivity> result = restTemplate.exchange(DAILY_ACTVITY_SUMMARY_FITBIT_APIS, HttpMethod.GET, entity, DailyActivity.class);

        return result.getBody();
    }

    public WaterGoal getWaterGoal(String userID) {
        String WATER_GOAL_FITBIT_APIS = "https://api.fitbit.com/1/user/" + userID + "/foods/log/water/goal.json";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<WaterGoal> entity = new HttpEntity<>(headers);
        ResponseEntity<WaterGoal> result = restTemplate.exchange(WATER_GOAL_FITBIT_APIS, HttpMethod.GET, entity, WaterGoal.class);

        return result.getBody();
    }

    public UserProfile getUserProfile(String userID) {
        String USER_PROFILE_FITBIT_APIS = "https://api.fitbit.com/1/user/" + userID + "/profile.json";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<UserProfile> entity = new HttpEntity<>(headers);
        ResponseEntity<UserProfile> result = restTemplate.exchange(USER_PROFILE_FITBIT_APIS, HttpMethod.GET, entity, UserProfile.class);

        return result.getBody();
    }


    public FoodLogs getFoodLogs(String userID, String date) {
        String FOOD_LOGS_FITBIT_APIS = "https://api.fitbit.com/1/user/" + userID + "/foods/log/date/" + date + ".json";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<FoodLogs> entity = new HttpEntity<>(headers);
        ResponseEntity<FoodLogs> result = restTemplate.exchange(FOOD_LOGS_FITBIT_APIS, HttpMethod.GET, entity, FoodLogs.class);

        return result.getBody();
    }

  /*  @PostConstruct
    public void generateTriggers() {
        System.out.println("Trigger System Running");
    }

    @Bean
    public TriggerSystem triggerSystem()
    {
        return new TriggerSystem();
    } */


