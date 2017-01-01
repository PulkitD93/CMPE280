package com.pulkit.fitnetwork.controllers;

//import Newsfeed;

import com.pulkit.fitnetwork.model.userprofile.FitbitProfileResponse;
import com.pulkit.fitnetwork.model.userprofile.User;
import com.pulkit.fitnetwork.model.userprofile.WebUserProfile;
import com.pulkit.fitnetwork.services.*;
import com.pulkit.fitnetwork.model.Newsfeed.NewsfeedList;
import com.pulkit.fitnetwork.model.lifestats.LifetimeStats;
import com.pulkit.fitnetwork.model.request.FriendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserProfileController {


    @Autowired
    UserService userService;

    @Autowired
    DashboardService dashboardService;

    @Autowired
    LikeService likeService;

    @Autowired
    CommentService commentService;

    @Autowired
    NewsfeedService newsfeedService;

    @Autowired
    FriendService friendService;


    @RequestMapping(value = {"/friendProfile"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    WebUserProfile FriendProfile(@RequestParam("userToken") String userToken,
                                 @RequestParam("email") String email) {
        System.out.println("In friends profile API");

        String FitbituserId = userService.getFitbitUserIDByUserEmail(email);
        Long userId = userService.getCurrentUserIdByEmail(email);
        String FitbitToken = userService.getFitbitTokenByUserEmail(email);


        System.out.println(FitbituserId);

        List<FriendResponse> userIdList = new ArrayList<FriendResponse>();
        FriendResponse f = new FriendResponse();
        f.setUserId(userId);
        f.setEmail(email);
        userIdList.add(f);

        String urlprofile = "https://api.fitbit.com/1/user/" + FitbituserId + "/profile.json";
        System.out.println(urlprofile);

        String token = "Bearer " + FitbitToken;

        System.out.println(token);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<FitbitProfileResponse> entity = new HttpEntity<>(headers);
        ResponseEntity<FitbitProfileResponse> result = restTemplate.exchange(urlprofile, HttpMethod.GET, entity, FitbitProfileResponse.class);
        User user = result.getBody().getUser();

        System.out.println("FitbitUser Profile Json : " + result.getBody());
        WebUserProfile appUser = new WebUserProfile();

        appUser.setEmail(email);
        appUser.setDescription(user.getAboutMe());
        appUser.setUsername(userService.getCurrentUserName(email));
        appUser.setProfileImageUrl(user.getAvatar());
        appUser.setHeight((user.getHeight()));
        appUser.setWeight(user.getWeight().intValue());
        appUser.setAge(user.getAge());
        appUser.setAverageDailySteps(user.getAverageDailySteps());
        appUser.setGender(user.getGender());
        appUser.setDateOfBirth(user.getDateOfBirth());
        appUser.setTopBadges(user.getTopBadges());

        NewsfeedList newsfeedList = newsfeedService.getNewsfeedByUser(userIdList);
        appUser.setNewsfeed(newsfeedList);
        return appUser;
    }


    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    WebUserProfile filterProducts1(@RequestParam("userToken") String userToken) {

        System.out.println("Requesting profile with user token - " + userToken);
        String FitbitToken = userService.getFitbitTokenByUserToken(userToken);
        String FitbituserId = userService.getFitbitUserIDByUserToken(userToken);
        Long userId = userService.getCurrentUserId(userToken);
        System.out.println(FitbituserId);
        List<FriendResponse> userIdList = new ArrayList<FriendResponse>();
        FriendResponse f = new FriendResponse();
        f.setUserId(userId);
        f.setEmail(userService.getCurrentUserEmail(userToken));
        userIdList.add(f);
        String urlprofile = "https://api.fitbit.com/1/user/" + FitbituserId + "/profile.json";
        System.out.println(urlprofile);
        String token = "Bearer " + FitbitToken;
        System.out.println(token);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<FitbitProfileResponse> entity = new HttpEntity<>(headers);
        ResponseEntity<FitbitProfileResponse> result = restTemplate.exchange(urlprofile, HttpMethod.GET, entity, FitbitProfileResponse.class);
        User user = result.getBody().getUser();

        System.out.println("FitbitUser Profile Json : " + result.getBody());
        WebUserProfile appUser = new WebUserProfile();

        appUser.setUsername(userService.getCurrentUserName(userService.getCurrentUserEmail(userToken)));
        appUser.setEmail(userService.getCurrentUserEmail(userToken));
        appUser.setDescription(user.getAboutMe());

        appUser.setProfileImageUrl(user.getAvatar150());
        appUser.setHeight((user.getHeight()));
        appUser.setWeight(user.getWeight().intValue());
        appUser.setAge(user.getAge());
        appUser.setAverageDailySteps(user.getAverageDailySteps());
        appUser.setGender(user.getGender());
        appUser.setDateOfBirth(user.getDateOfBirth());
        appUser.setTopBadges(user.getTopBadges());
        appUser.setAddress(user.getCity() + ", " + user.getState() + "," + user.getCountry());


        System.out.println("Updating the mysql table" + (user.getHeight().intValue()) + " " + user.getAge() + " " + user.getAvatar());
        userService.updateProfile(user.getHeight(), user.getAge(), user.getAvatar(), userService.getCurrentUserEmail(userToken));


        NewsfeedList newsfeedList = newsfeedService.getNewsfeedByUser(userIdList);
        appUser.setNewsfeed(newsfeedList);
        return appUser;
    }


    @RequestMapping(value = {"/profile/lifetimeStats"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    LifetimeStats getLifeStats(@RequestParam("userToken") String userToken) {


        String FitbituserId = userService.getFitbitUserIDByUserToken(userToken);
        String FitbitToken = userService.getFitbitTokenByUserToken(userToken);
        String urllifestats = "https://api.fitbit.com/1/user/" + FitbituserId + "/activities.json";


        String token = "Bearer " + FitbitToken;
        System.out.println("token :" + token);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<LifetimeStats> entity = new HttpEntity<>(headers);
        ResponseEntity<LifetimeStats> lifetimeStatsResponseEntity = restTemplate.exchange(urllifestats, HttpMethod.GET, entity, LifetimeStats.class);
        LifetimeStats lifetimeStats = lifetimeStatsResponseEntity.getBody();

        return lifetimeStats;
    }

}
