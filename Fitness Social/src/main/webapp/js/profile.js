/**
 * Created by shikh on 28-Nov-16.
 */

// var profileJSON = {
//     "username": "Pulkit Dureja",
//     "email": "dureja.pulkit@gmail.com",
//     "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_150_square.jpg",
//     "address": "null, null,US",
//     "height": 177.8,
//     "age": 23,
//     "weight": 70,
//     "averageDailySteps": 0,
//     "dateOfBirth": "1993-04-06",
//     "gender": "MALE",
//     "topBadges": [],
//     "newsfeed": {
//         "newsfeed": [
//             {
//                 "id": 820,
//                 "nfDateTime": "2016-12-07 00:00:00",
//                 "likecount": 0,
//                 "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_100_square.jpg",
//                 "usercomments": [],
//                 "username": "Pulkit Dureja",
//                 "imagesUrls": [],
//                 "description": "I have been sitting idle for 1440 minutes. I must exercise."
//             },
//             {
//                 "id": 811,
//                 "nfDateTime": "2016-12-06 00:00:00",
//                 "likecount": 0,
//                 "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_100_square.jpg",
//                 "usercomments": [],
//                 "username": "Pulkit Dureja",
//                 "imagesUrls": [],
//                 "description": "I have been sitting idle for 1440 minutes. I must exercise."
//             },
//             {
//                 "id": 800,
//                 "nfDateTime": "2016-12-05 00:00:00",
//                 "likecount": 0,
//                 "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_100_square.jpg",
//                 "usercomments": [],
//                 "username": "Pulkit Dureja",
//                 "imagesUrls": [],
//                 "description": "I have been sitting idle for 1440 minutes. I must exercise."
//             },
//             {
//                 "id": 791,
//                 "nfDateTime": "2016-12-04 00:00:00",
//                 "likecount": 0,
//                 "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_100_square.jpg",
//                 "usercomments": [],
//                 "username": "Pulkit Dureja",
//                 "imagesUrls": [],
//                 "description": "I have been sitting idle for 1440 minutes. I must exercise."
//             },
//             {
//                 "id": 780,
//                 "nfDateTime": "2016-12-03 00:00:00",
//                 "likecount": 0,
//                 "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_100_square.jpg",
//                 "usercomments": [],
//                 "username": "Pulkit Dureja",
//                 "imagesUrls": [],
//                 "description": "I have been sitting idle for 1440 minutes. I must exercise."
//             },
//             {
//                 "id": 767,
//                 "nfDateTime": "2016-12-07 00:00:00",
//                 "likecount": 0,
//                 "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_100_square.jpg",
//                 "usercomments": [],
//                 "username": "Pulkit Dureja",
//                 "imagesUrls": [],
//                 "description": "I have been sitting idle for 1440 minutes. I must exercise."
//             },
//             {
//                 "id": 758,
//                 "nfDateTime": "2016-12-06 00:00:00",
//                 "likecount": 0,
//                 "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_100_square.jpg",
//                 "usercomments": [],
//                 "username": "Pulkit Dureja",
//                 "imagesUrls": [],
//                 "description": "I have been sitting idle for 1440 minutes. I must exercise."
//             },
//             {
//                 "id": 747,
//                 "nfDateTime": "2016-12-05 00:00:00",
//                 "likecount": 0,
//                 "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_100_square.jpg",
//                 "usercomments": [],
//                 "username": "Pulkit Dureja",
//                 "imagesUrls": [],
//                 "description": "I have been sitting idle for 1440 minutes. I must exercise."
//             },
//             {
//                 "id": 738,
//                 "nfDateTime": "2016-12-04 00:00:00",
//                 "likecount": 0,
//                 "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_100_square.jpg",
//                 "usercomments": [],
//                 "username": "Pulkit Dureja",
//                 "imagesUrls": [],
//                 "description": "I have been sitting idle for 1440 minutes. I must exercise."
//             },
//             {
//                 "id": 727,
//                 "nfDateTime": "2016-12-03 00:00:00",
//                 "likecount": 0,
//                 "profileImageUrl": "https://d6y8zfzc2qfsl.cloudfront.net/9624CB39-6C6D-2EC2-8134-4947781B0698_profile_100_square.jpg",
//                 "usercomments": [],
//                 "username": "Pulkit Dureja",
//                 "imagesUrls": [],
//                 "description": "I have been sitting idle for 1440 minutes. I must exercise."
//             }
//         ],
//         "newsFeedEntries": 10
//     }
// };
//
//
// var profileObj = JSON.parse(JSON.stringify(profileJSON));


function confirmFriendAction(email, action) {
    confirmFriend(email, action, function (result) {
        if (result) {
            showStatus("Confirmed Friend");
        } else {
            showStatus("Rejected Friend");
        }
    });
}

//get current logged user email

var currentUserEmail = "";
var currentUserToken = "";
var currentProfileEmail = "";
var currentProfileEmailIsFriend = "";
var currentProfileEmailIsConfirmFriend = "";

if (localStorage.getItem("userEmail") !== "") {
    currentUserEmail = localStorage.getItem("userEmail");
    currentUserToken = localStorage.getItem("userToken");
    currentProfileEmail = localStorage.getItem("currentProfileEmail");
    currentProfileEmailIsFriend = localStorage.getItem("currentProfileEmailIsFriend");
    currentProfileEmailIsConfirmFriend = localStorage.getItem("currentProfileEmailIsConfirmFriend");
    console.log("currentUserEmail : " + currentUserEmail);
    console.log("currentProfileEmail : " + currentProfileEmail);
    console.log("currentProfileEmailIsFriend : " + currentProfileEmailIsFriend);
    console.log("currentProfileEmailIsConfirmFriend : " + currentProfileEmailIsConfirmFriend);
    var confirmFriendButton = document.getElementById("confirmFriendButton");
    var rejectFriendButton = document.getElementById("rejectFriendButton");
    var confirmFriendDiv = document.getElementById("confirmFriendDiv");
    var addFriendButton = document.getElementById("addFriendButton");


    if (currentProfileEmailIsConfirmFriend !== null && currentProfileEmailIsConfirmFriend === "true") {
        confirmFriendDiv.style.display = "block";
    } else {
        confirmFriendDiv.style.display = "none";
    }


    if (currentProfileEmail !== null && currentProfileEmail !== currentUserEmail) {
        if (currentProfileEmailIsFriend !== null && currentProfileEmailIsFriend === "true") {
            addFriendButton.style.display = "none";
        } else {
            if (currentProfileEmailIsConfirmFriend !== null && currentProfileEmailIsConfirmFriend === "true") {
                addFriendButton.style.display = "none";
            } else {
                addFriendButton.style.display = "block";
            }
        }
    } else {
        addFriendButton.style.display = "none";
    }


    confirmFriendButton.addEventListener('click', function () {
        confirmFriendAction(currentProfileEmail, "true");
        localStorage.removeItem("currentProfileEmailIsConfirmFriend");
        confirmFriendDiv.style.display = "none";
    });

    rejectFriendButton.addEventListener('click', function () {
        confirmFriendAction(currentProfileEmail, "false");
        localStorage.removeItem("currentProfileEmailIsConfirmFriend");
        confirmFriendDiv.style.display = "none";
    });

    addFriendButton.addEventListener('click', function () {
        addFriend(currentProfileEmail, function (result) {
            if (result) {
                showStatus("Friend Request Sent");
                addFriendButton.style.display = "none";
            } else {
                showStatus("Unable to send friend request");
            }
        });
    });
}


function initProfile() {

    if (currentProfileEmail !== null && currentProfileEmail !== currentUserEmail) {
        getFriendProfile(currentProfileEmail);
        console.log("getFriendProfile");
    } else {
        getProfile();
        console.log("getProfile");
    }

}

function writeComment(e, newsFeedItemId) {
    if (e.keyCode == 13) {
        var commentDescription = e.target.value;
        var url = "/app/newsfeed/" + newsFeedItemId + "/comment?userToken=" + localStorage.getItem("userToken");
        var reqObj = {
            description: commentDescription,
            timestamp: Date.now()
        };

        e.target.value = "";
        ajaxCall("POST", url, reqObj, function (status, resData) {
            if (status === 200) {
                var data = JSON.parse(resData);
                populateComments(data, newsFeedItemId);
            } else {
                console.error("Error while calling comment api - " + url + " status : " + status);
            }
        });
    }
}


function getProfile() {

    document.getElementById("newsFeedBlock").innerHTML = "";
    document.getElementById("badges").innerHTML = "";
    $("<h2><b>Badges</b></h2>").appendTo("#badges");

    console.log("Populating profile");

    var reqObj = {};
    var url = "/app/profile?userToken=" + currentUserToken;
    ajaxCall("GET", url, reqObj, function (status, resData) {

        console.log("Got profile response with status - " + status);


        if (status == 200) {
            //set top block info
            var data = JSON.parse(resData);
            document.getElementById("profilePic").src = data.profileImageUrl;
            document.getElementById("username").innerHTML = data.username;
            if (data.description !== undefined)
                document.getElementById("userdescription").innerHTML = data.description;
            if (data.address !== undefined)
                document.getElementById("useraddress").innerHTML = data.address;
            document.getElementById("userheight").innerHTML = "Height " + data.height + " cms";
            document.getElementById("userage").innerHTML = "Age " + data.age;
            document.getElementById("userweight").innerHTML = "Weight " + data.weight + " Kgs";
            document.getElementById("userdob").innerHTML = data.dateOfBirth;
            document.getElementById("usergender").innerHTML = data.gender;

            //set average daily steps
            document.getElementById("averageDailySteps").innerHTML = data.averageDailySteps.toString();

            //get badges
            getBadges("#badges", data.topBadges);

            //get newsfeed items
            getNewsFeedItems("#newsFeedBlock", data.newsfeed.newsfeed, data.profileImageUrl);
        } else {
            console.error("Unable to get data from profile api - status code  - " + status);
        }
    });
}

function getFriendProfile(email) {

    document.getElementById("newsFeedBlock").innerHTML = "";
    document.getElementById("badges").innerHTML = "";
    $("<h2><b>Badges</b></h2>").appendTo("#badges");

    console.log("Populating profile");

    var reqObj = {};
    var url = "/app/friendProfile?userToken=" + currentUserToken + "&email=" + email;
    ajaxCall("GET", url, reqObj, function (status, resData) {

        console.log("Got profile response with status - " + status);


        if (status == 200) {
            //set top block info
            var data = JSON.parse(resData);
            console.log(data);
            document.getElementById("profilePic").src = data.profileImageUrl;
            document.getElementById("username").innerHTML = data.username;
            if (data.description !== undefined)
                document.getElementById("userdescription").innerHTML = data.description;
            if (data.address !== undefined)
                document.getElementById("useraddress").innerHTML = data.address;
            document.getElementById("userheight").innerHTML = "Height " + data.height + " cms";
            document.getElementById("userheight").innerHTML = "Height " + data.height + " cms";
            document.getElementById("userage").innerHTML = "Age " + data.age;
            document.getElementById("userweight").innerHTML = "Weight " + data.weight + " Kgs";
            document.getElementById("userdob").innerHTML = data.dateOfBirth;
            document.getElementById("usergender").innerHTML = data.gender;

            //set average daily steps
            document.getElementById("averageDailySteps").innerHTML = data.averageDailySteps.toString();

            //get badges
            getBadges("#badges", data.topBadges);

            //get newsfeed items
            getNewsFeedItems("#newsFeedBlock", data.newsfeed.newsfeed, data.profileImageUrl);
        } else {
            console.error("Unable to get data from profile api - status code  - " + status);
        }
    });
}

function getBadges(parentId, badgesArray) {


    var badgeImageUrl;
    var badgeCategory;
    var badgeDescription;

    for (var i = 0; i < badgesArray.length; i++) {
        var badgeItem = badgesArray[i];
        badgeCategory = badgeItem.category;
        badgeImageUrl = badgeItem.image125px;
        console.log("Badge Image Url - " + badgeImageUrl);
        badgeDescription = badgeItem.description;

        var badgeElement = '<div style="display: flex;padding: 20px">' +
            '<img src="' + badgeImageUrl + '" width="100" height="100" style="padding: 5px;vertical-align: middle;">' +
            '<div>' +
            '<h3 style="margin: 15px;">' + badgeCategory + '</h3>' +
            '<h5 style="margin: 15px;">' + badgeDescription + '</h5>' +
            '</div>' +
            '</div>';

        $(badgeElement).appendTo(parentId);
    }


}

function getNewsFeedItems(parentId, newsfeedArray, profileImageUrl) {


    for (var i = 0; i < newsfeedArray.length; i++) {
        var newsFeedItem = newsfeedArray[i];
        var newsFeedItemId = newsFeedItem.id;
        var newsFeedItemImagesContainerId = newsFeedItemId + "imagesContainer";
        var commentsArray = newsFeedItem.usercomments;
        var imagesUrlsArray = newsFeedItem.imagesUrls;
        var commentsBoxId = newsFeedItemId + "commentsBox";
        var textAreaId = newsFeedItemId + "TextArea";
        var likeId = newsFeedItemId + "like";
        var likeImageId = likeId + "img";
        var commentCountTextId = newsFeedItemId + "commentCountText";


        //add top level news feed item

        var newsFeedItem = '<div id=' + newsFeedItemId + ' class="newsFeedItem boxShadowBig" style="padding: 10px;">' +
            '<img src="' + profileImageUrl + '" width="60" height="60" style="margin: 10px;" class="boxShadowBig">' +
            '<h2 class="wordBreak" style="margin: 10px;display: inline;"><b>' + newsFeedItem.username + '</b></h2>' +
            '<h4 style="margin: 10px 10px 10px 0px;display: inline;">posted</h4>' +
            '<h4 class="wordBreak" style="margin: 20px 10px 20px 10px;">' + newsFeedItem.description + '</h4>' +
            '<div id="' + newsFeedItemImagesContainerId + '" style="display: flex" class="newsFeedImagesContainer">' +
            '</div>' +
            '<h5 style="margin: 10px;margin-top: 20px;font-style: italic;">' + newsFeedItem.nfDateTime.substring(0, 10) + '</h5>' +
            '<div style="display: flex;flex-direction:column;justify-content: flex-start;margin: 10px;">' +
            '<div style="margin-bottom: 20px;display: flex;flex-direction: column;">' +
            '<div><img id=' + likeImageId + ' onclick="doLike(event,\'' + newsFeedItemId + '\',' + newsFeedItem.likecount + ');" style="margin-top: 20px;margin-bottom: 10px;" src="https://s18.postimg.org/6tk42epbt/like.png" width="40" height="40"></div>' +
            '<div style="display: flex;justify-content: space-between;">' +
            '<h5 id=' + likeId + '>' + newsFeedItem.likecount + ' Likes</h5>' +
            '<h5 id=' + commentCountTextId + ' class="commentText" onclick="expandComments(' + '\'' + commentsBoxId + '\'' + ');">' + commentsArray.length + ' Comments</h5>' +
            '</div>' +
            '</div>' +
            '<textarea class="boxShadowSmall" placeholder="Write a comment" onkeyup="writeComment(event,\'' + newsFeedItemId + '\');"></textarea>' +
            '</div></div>';

        $(newsFeedItem).appendTo(parentId);


        //populate images
        for (var j = 0; j < imagesUrlsArray.length; j++) {
            var source = imagesUrlsArray[i];
            var newsFeedImageItem = '<img src=' + source + ' width="200" height="200">';
            $(newsFeedImageItem).appendTo("#" + newsFeedItemImagesContainerId);
        }

        //populate comments

        var commentBox = '<div id=' + commentsBoxId + ' class="commentBox" style="display: block;"></div>';
        $(commentBox).appendTo("#" + newsFeedItemId);

        for (var k = 0; k < commentsArray.length; k++) {
            var commentItem = commentsArray[k];
            var commentItemId = newsFeedItemId + "-" + commentItem.email + "comment-" + k;
            var commentUsername = commentItem.userName;
            var commentUserProfileImageUrl = commentItem.profileImageUrl;
            var userFriendGetProfilePath = "/app/Profile.html";
            var commentDescription = commentItem.text;

            var comment = '<div id="' + commentItemId + '" style="display: flex;">' +
                '<div>' +
                '<a href="/" onclick="navigateToUrlByEmail(event,\'' + userFriendGetProfilePath + '\',\'' + commentItem.email + '\')">' +
                '<img class="boxShadowBig" src="' + commentUserProfileImageUrl + '" width="60" height="60" style="margin: 10px;">' +
                '</a>' +
                '</div>' +
                '<div style="padding: 10px;">' +
                '<a class="profileNameLink" href="/" onclick="navigateToUrlByEmail(event,\'' + userFriendGetProfilePath + '\',\'' + commentItem.email + '\')">' +
                '<h4 class="wordBreak"><b>' + commentUsername + '</b></h4></a>' +
                '<span class="wordBreak">' + commentDescription + '</span>' +
                '</div>' +
                '</div>';

            $(comment).appendTo("#" + commentsBoxId);
        }


    }


}

function populateComments(data, newsFeedItemId) {


    console.log("populating comments for news feed :" + newsFeedItemId);
    console.log(data);

    var commentsBoxId = newsFeedItemId + "commentsBox";
    var commentsArray = data.commentsList;
    document.getElementById(commentsBoxId).innerHTML = "";
    var commentCountTextId = newsFeedItemId + "commentCountText";
    document.getElementById(commentCountTextId).innerHTML = commentsArray.length + ' Comments';
    // var commentBox = '<div id=' + commentsBoxId + ' class="commentBox" style="display: block;"></div>';
    // $(commentBox).appendTo("#" + newsFeedItemId);

    for (var k = 0; k < commentsArray.length; k++) {
        var commentItem = commentsArray[k];
        var commentItemId = newsFeedItemId + "-" + commentItem.email + "comment-" + k;
        var commentUsername = commentItem.userName;
        var commentUserProfileImageUrl = commentItem.profileImageUrl;
        var userFriendGetProfilePath = "/app/Profile.html";
        var commentDescription = commentItem.text;

        var comment = '<div id="' + commentItemId + '" style="display: flex;">' +
            '<div>' +
            '<a href="/" onclick="navigateToUrlByEmail(event,\'' + userFriendGetProfilePath + '\',\'' + commentItem.email + '\')">' +
            '<img class="boxShadowBig" src="' + commentUserProfileImageUrl + '" width="60" height="60" style="margin: 10px;">' +
            '</a>' +
            '</div>' +
            '<div style="padding: 10px;">' +
            '<a class="profileNameLink" href="/" onclick="navigateToUrlByEmail(event,\'' + userFriendGetProfilePath + '\',\'' + commentItem.email + '\')">' +
            '<h4 class="wordBreak"><b>' + commentUsername + '</b></h4></a>' +
            '<span class="wordBreak">' + commentDescription + '</span>' +
            '</div>' +
            '</div>';

        $(comment).appendTo("#" + commentsBoxId);
    }

}

function expandComments(commentsBoxId) {
    var commentBox = document.getElementById(commentsBoxId);
    console.log(commentBox.style.display);
    if (commentBox.style.display === "none") {
        commentBox.style.display = "block";
    } else {
        commentBox.style.display = "none";
    }
}


