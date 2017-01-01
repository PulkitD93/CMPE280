package com.pulkit.fitnetwork.controllers;

import com.pulkit.fitnetwork.model.Newsfeed.CommentBody;
import com.pulkit.fitnetwork.model.Newsfeed.CommentsList;
import com.pulkit.fitnetwork.model.Newsfeed.Like;
import com.pulkit.fitnetwork.model.Newsfeed.NewsfeedList;
import com.pulkit.fitnetwork.model.Result;
import com.pulkit.fitnetwork.model.User;
import com.pulkit.fitnetwork.model.dashboard.Dashboard;
import com.pulkit.fitnetwork.model.friend;
import com.pulkit.fitnetwork.model.search.SearchResponse;
import com.pulkit.fitnetwork.services.*;
import com.pulkit.fitnetwork.model.dashboard.WeeklyDashboard;
import com.pulkit.fitnetwork.model.rank.RankList;
import com.pulkit.fitnetwork.model.request.LoginRequest;
import com.pulkit.fitnetwork.model.request.SignupRequest;
import com.pulkit.fitnetwork.model.suggestion.FriendSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Shikher on 09-Sep-16.
 */


@Controller
public class UserController {

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

    @Autowired
    private PasswordEncoder passwordEncoder;


//    @RequestMapping(value = {"/web"}, method = RequestMethod.GET)
//    public String getHome() {
//        return "redirect:/web/app/index.html";
//    }


    @RequestMapping(value = {"/signUp"}, method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    Result signUp(@RequestBody SignupRequest signupRequest) {

        //check if email exists
        boolean result = userService.checkIfEmailExists(signupRequest.getEmail());

        if (result) {
            System.out.println("Email exists with : - " + signupRequest.getEmail());
            return new Result("emailexists");
        }

        User user = new User();

        user.setUsertype(signupRequest.getUsertype());
        user.setLatitude(signupRequest.getLatitude());
        user.setLongitude(signupRequest.getLongitude());
        user.setGender(signupRequest.getGender());
        user.setEmail(signupRequest.getEmail());
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());

        //encrypting the password
        String encryptedPassword = passwordEncoder.encode(signupRequest.getUserpassword());
        System.out.println("Encrypted Password : " + encryptedPassword + " Password length : " + encryptedPassword.length());

        user.setUserpassword(encryptedPassword);
        user.setFitbitUserID(signupRequest.getFitbitUserID());
        user.setFitbitToken(signupRequest.getFitbitToken());
        user.setFitbitTokenDuration(signupRequest.getFitbitTokenDuration());

        return new Result(userService.signUp(user));
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    Result login(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest.getEmail() + " Logging in");

        String storedPassword = userService.getPasswordForEmail(loginRequest.getEmail());

        if (storedPassword.equals("none")) {
            return new Result("wrongcredentials");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), storedPassword)) {
            return new Result("wrongcredentials");
        }

//        if (storedPassword.equals("$2a$10$hcQ1FXm82okzgCM4VOP6oOj5kudcEoK5d4SKfOfJrc.TwadZj/zcW")) {
//            System.out.println("EQUAL");
//        } else {
//            System.out.println("NOT EQUAL");
//        }

        return new Result(userService.updateToken(loginRequest.getEmail()));
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.PUT, produces = "application/json")
    public
    @ResponseBody
    void logout(@RequestParam("userToken") String userToken) {
        String currentUserEmail = userService.getCurrentUserEmail(userToken);
        System.out.println(currentUserEmail + " Logging out");
        userService.logout(userToken);
    }

    @Autowired
    SearchService searchService;

    @RequestMapping(value = {"/search/{input}"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    SearchResponse getSearchResults(@PathVariable("input") String input, @RequestParam("userToken") String userToken) {
        Long userId = userService.getCurrentUserId(userToken);
        return searchService.searchUserNewsFeed(userId, input);
    }

    @Autowired
    RankService rankService;

    @RequestMapping(value = {"/rank"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    List<RankList> getRankResults(@RequestParam("userToken") String userToken) {
        System.out.println("Pulkit says his code workds " + userToken);
        Long userId = userService.getCurrentUserId(userToken);
        return rankService.getRankList();
    }

    @Autowired
    SuggestService suggestService;


    //GET API - get daily dashboard - Vignesh
    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    Dashboard getDailyDashboard(@RequestParam("userToken") String userToken) {
        DateFormat dateFormatDashBoard = new SimpleDateFormat("yyyy-MM-dd");
        Long userId = userService.getCurrentUserId(userToken);
        return dashboardService.getDailyDashboard(userId, dateFormatDashBoard.format(new Date()));
    }

    //GET API - get weekly dashboards
    @RequestMapping(value = {"/week/dashboard"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    WeeklyDashboard getWeekDashBoard(@RequestParam("userToken") String userToken) {

        System.out.println("Getting Weekly Dashboard");
        Long userId = userService.getCurrentUserId(userToken);

        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String enddate = format1.format(cal1.getTime());
        System.out.println(enddate);
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, -7);
        String startDate = format1.format(cal2.getTime());
        return dashboardService.getWeekDashboard(userId, startDate, enddate);
    }

    //GET API - get weekly dashboards
    @RequestMapping(value = {"/week/friendDashboard"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    WeeklyDashboard getWeekDashBoardForFriend(@RequestParam("userToken") String userToken, @RequestParam("email") String email) {

        System.out.println("Getting Weekly Dashboard for Friend");
        Long userId = userService.getCurrentUserId(userToken);
        Long friendUserId = userService.getCurrentUserIdByEmail(email);
        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String enddate = format1.format(cal1.getTime());
        System.out.println(enddate);
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, -7);
        String startDate = format1.format(cal2.getTime());
        return dashboardService.getWeekDashboard(friendUserId, startDate, enddate);
    }

    // GET API - Get list of likes for a newsfeed item
    @RequestMapping(value = {"/newsfeed/{id}/getlikes"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    Like getLikeList(@PathVariable("id") int id, @RequestParam("userToken") String userToken) {
        Long userId = userService.getCurrentUserId(userToken);
        return likeService.getLikeList(id, userId);
    }

    //POST API - Like a newsfeed item
    @RequestMapping(value = {"/newsfeed/{id}/like"}, method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    Like setLikeStatus(@PathVariable("id") int id, @RequestParam("userToken") String userToken) {
        Long userId = userService.getCurrentUserId(userToken);
        return likeService.setLikeStatus(id, userId);
    }

    //PUT API - Unlike a newsfeed item
    @RequestMapping(value = {"/newsfeed/{id}/unlike"}, method = RequestMethod.PUT, produces = "application/json")
    public
    @ResponseBody
    Like setUnlikeStatus(@PathVariable("id") int id, @RequestParam("userToken") String userToken) {
        Long userId = userService.getCurrentUserId(userToken);
        return likeService.setUnlikeStatus(id, userId);
    }

    //POST API - posting a comment on a newsfeed
    @RequestMapping(value = {"/newsfeed/{id}/comment"}, method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    CommentsList setComment(@PathVariable("id") int id, @RequestParam("userToken") String userToken, @RequestBody CommentBody commentBody) {
        System.out.println(id + " " + userToken);
        Long userId = userService.getCurrentUserId(userToken);
        commentService.setComments(id, commentBody.getDescription(), commentBody.getTimestamp(), userId);
        return commentService.getComments(id);
    }

    //POST API - posting a comment on a newsfeed by a friend
    @RequestMapping(value = {"/newsfeed/{id}/commentByEmail"}, method = RequestMethod.POST, produces = "application/json")
    public
    @ResponseBody
    CommentsList setCommentByEmail(@PathVariable("id") int id, @RequestParam("email") String email, @RequestBody CommentBody commentBody) {
        Long userId = userService.getCurrentUserIdByEmail(email);
        commentService.setComments(id, commentBody.getDescription(), commentBody.getTimestamp(), userId);
        return commentService.getComments(id);
    }

    //GET API - GET all comments for  a newsfeed item
    @RequestMapping(value = {"/newsfeed/{id}/getComments"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    CommentsList setComment(@PathVariable("id") int id, @RequestParam("userToken") String userToken) {

        return commentService.getComments(id);
    }

    //GET API - Get newsfeed associated with a user
    @RequestMapping(value = {"/newsfeed/{pagenumber}"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    NewsfeedList getComments(@PathVariable("pagenumber") int pagenumber, @RequestParam("userToken") String userToken) {
        Long userId = userService.getCurrentUserId(userToken);
        FriendSuggestion friends = friendService.showAllFriends(userId);
        return newsfeedService.getNewsfeed(friends.getSuggestlist(), pagenumber);

    }


    @RequestMapping(value = {"/addFriend"}, method = RequestMethod.POST, produces = "application/json")

    @ResponseBody
    public Result sendFriendRequest(
            @RequestParam("userToken") String userToken,
            @RequestParam("friendEmail") String friendEmail) {
        String str = "requestSent";
        System.out.println("Friend request sent to : " + friendEmail);
        long currentUserId = userService.getCurrentUserId(userToken);
        long friendUserId = userService.getCurrentUserIdByEmail(friendEmail);
        friendService.insert(new friend(currentUserId, friendUserId, str));
        return new Result("Friend Request Sent Successfully");
    }


    // Controller for accepting or rejecting all  friend request from others users  (POST)
    @RequestMapping(value = {"/confirmFriend"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Result confirmFriendRequest(
            @RequestParam("friendEmail") String friendEmail,
            @RequestParam("actiontaken") boolean actiontaken,
            @RequestParam("userToken") String userToken) {

        long currentUserId = userService.getCurrentUserId(userToken);
        long friendUserId = userService.getCurrentUserIdByEmail(friendEmail);
        if (actiontaken) {
            friendService.confirmFriendRequest(friendUserId, currentUserId);
            return new Result("True");
        }
        friendService.rejectFriendRequest(friendUserId, currentUserId);
        return new Result("False");
    }


    @RequestMapping(value = {"/getFriendSuggestions"}, method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    FriendSuggestion getFriendSuggests(@RequestParam("userToken") String userToken) {
        Long userId = userService.getCurrentUserId(userToken);
        return suggestService.getFriendSuggestions(userId);
    }


    // Controller for getting all my accepted friends   (GET)

    @RequestMapping(value = {"/getFriends"}, method = RequestMethod.GET, produces = "application/json")

    @ResponseBody
    public FriendSuggestion showAllFriends(@RequestParam("userToken") String userToken) {
        long currentUserId = userService.getCurrentUserId(userToken);
        FriendSuggestion result = friendService.showAllFriends(currentUserId);
        return result;
    }

    @RequestMapping(value = {"/getFriendRequests"}, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public FriendSuggestion getFriendRequest(@RequestParam("userToken") String userToken) {
        long currentUserId = userService.getCurrentUserId(userToken);
        FriendSuggestion result = friendService.getAllFriends(currentUserId);
        return result;
    }

}
