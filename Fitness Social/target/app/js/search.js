/**
 * Created by shikh on 30-Nov-16.
 */


// var searchResultJSONResponse = JSON.stringify({
//     "userlist": [{
//         "email": "shikher9@gmail",
//         "name": "Shikher Pandey",
//         "profileImageUrl": "https://scontent.fsnc1-1.fna.fbcdn.net/t31.0-8/331095_2221555191753_3354635_o.jpg"
//     }, {
//         "email": "shikher9@gmail",
//         "name": "Shikher Pandey",
//         "profileImageUrl": "https://scontent.fsnc1-1.fna.fbcdn.net/t31.0-8/331095_2221555191753_3354635_o.jpg"
//     }],
//     "feedlist": [{
//         "id": "asdad",
//         "description": "asfcahsfcgsaj",
//         "datetime": "asdaascda",
//         "likes": 2,
//         "usercomments": [{
//             "email": "shikher9@gmail",
//             "name": "Shikher Pandey",
//             "profileImageUrl": "https://scontent.fsnc1-1.fna.fbcdn.net/t31.0-8/331095_2221555191753_3354635_o.jpg",
//             "comment": "asfchasfjfas"
//         }, {
//             "email": "shikher9@gmail",
//             "name": "Shikher Pandey",
//             "profileImageUrl": "https://scontent.fsnc1-1.fna.fbcdn.net/t31.0-8/331095_2221555191753_3354635_o.jpg",
//             "comment": "asfchasfjfas"
//         }],
//         "username": "Shikher Pandey",
//         "profileImageUrl":"",
//         "imagesUrls": ["https://scontent.fsnc1-1.fna.fbcdn.net/t31.0-8/331095_2221555191753_3354635_o.jpg"]
//     }]
// });
//
// var searchResultObj = JSON.parse(searchResultJSONResponse);


function addFriendAction(event, email) {
    addFriend(email, function (result) {
        if (result) {
            //showStatus("Friend Request sent");
        } else {
            //showStatus("Friend Request not sent");
        }
    });
}

var searchTerm = localStorage.getItem("searchTerm");

function doSearch(e) {
    if (e.keyCode == 13) {
        var searchInput = e.target.value;
        search(searchInput);
    }
}

function search(searchInput) {

    localStorage.setItem("searchTerm", searchInput);
    var url = "/app/search/" + searchInput + "?userToken=" + localStorage.getItem("userToken");
    var reqObj = {};

    ajaxCall("GET", url, reqObj, function (status, data) {
        if (status === 200) {
            var searchResultObj = JSON.parse(data);
            document.getElementById("wrapperSearch").style.display = "block";
            generateUserList(searchResultObj);
            getNewsFeedItems("#newsFeedBlock", searchResultObj.feedlist);

            var noResultsDiv = '<div id="noResultsDiv" style="text-align: center;font-size: 22px;"><b>NO RESULTS</b></div>';
            if (searchResultObj.feedlist.length === 0 && searchResultObj.userlist.length === 0) {
                $(noResultsDiv).appendTo("#wrapperSearch");
            } else {
                $("#noResultsDiv").remove();
            }
        } else {
            console.error("Unable to fetch search results");
        }
    });


}


function generateUserList(resObj) {

    document.getElementById("userlistBlock").innerHTML = "";

    var userlistArray = resObj.userlist;

    for (var i = 0; i < userlistArray.length; i++) {
        var email = userlistArray[i].email;
        var profileImageUrl = userlistArray[i].profileImageUrl;
        var name = userlistArray[i].name;
        var url = "/app/Profile.html";
        var isFriend = userlistArray[i].isFriend;
        var addFriendButtonInsert;
        var methodName;
        if (!isFriend) {
            methodName = '<a href="/" onclick="navigateToUrlByEmail(event,\'' + url + '\',\'' + email + '\')">';
            addFriendButtonInsert = '<button class="btn btn-info" style="margin: 10px;" onclick="addFriendAction(event,\'' + email + '\')"><b>Add friend</b></button>';
        } else {
            methodName = '<a href="/" onclick="navigateToFriendByEmail(event,\'' + url + '\',\'' + email + '\')">';
            addFriendButtonInsert = '<button class="btn btn-info" style="margin: 10px;"><b>Friend</b></button>';
        }


        var friendSuggestion = '<div style="display: flex;margin-bottom: 20px;padding: 20px;position: relative" class="boxShadowSmall">' +
            methodName +
            '<img class="boxShadowSmall" src="' + profileImageUrl + '" width="70" height="70">' +
            '<div style="display: flex;flex-direction: column">' +
            '</a>' +
            methodName +
            '<h4 style="margin: auto 10px">' + name + '</h4>' +
            '</a>' +
            addFriendButtonInsert +
            '</div>' +
            '</div>';

        $(friendSuggestion).appendTo("#userlistBlock");
    }

}


function getNewsFeedItems(parentId, newsfeedArray) {

    document.getElementById("newsFeedBlock").innerHTML = "";
    for (var i = 0; i < newsfeedArray.length; i++) {
        var newsFeedItem = newsfeedArray[i];
        var newsFeedItemId = newsFeedItem.id;
        var newsFeedItemImagesContainerId = newsFeedItemId + "imagesContainer";
        var commentsArray = newsFeedItem.usercomments;
        var imagesUrlsArray = newsFeedItem.imagesUrls;
        var commentsBoxId = newsFeedItemId + "commentsBox";
        var textAreaId = newsFeedItemId + "TextArea";
        var likeId = newsFeedItemId + "like";
        var date = newsFeedItem.nfDateTime.toString(0, 11);

        //add top level news feed item

        var newsFeedItem = '<div id=' + newsFeedItemId + ' class="newsFeedItem boxShadowSmall" style="padding:10px;margin-bottom:10px;margin-top:0;">' +
            '<img src="' + newsFeedItem.profileImageUrl + '" width="60" height="60" style="margin: 10px;" class="boxShadowBig">' +
            '<h2 style="margin: 10px;display: inline;"><b>' + newsFeedItem.username + '</b></h2>' +
            '<h4 style="margin: 10px 10px 10px 0px;display: inline;">posted</h4>' +
            '<h4 style="margin: 20px 10px 20px 10px;">' + newsFeedItem.description + '</h4>' +
            '<div id="' + newsFeedItemImagesContainerId + '" style="display:flex;">' +
            '</div>' +
            '<h5 style="margin: 10px;margin-top: 20px;font-style: italic;">' + date + '</h5>' +
            '<div style="display: flex;flex-direction:column;justify-content: flex-start;margin: 10px;">' +
            '<div style="margin-bottom: 20px;display: flex;flex-direction: column;">' +
            '<div style="display: flex;justify-content: space-between;">' +
            '<h5>' + newsFeedItem.likecount + ' Likes</h5>' +
            '<h5 class="commentText" onclick="expandComments(' + '\'' + commentsBoxId + '\'' + ');">' + commentsArray.length + ' Comments</h5>' +
            '</div>' +
            '</div>' +
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
            var commentUsername = commentItem.name;
            var commentUserProfileImageUrl = commentItem.profileImageUrl;
            var userFriendGetProfilePath = "/app/Profile.html";
            var commentDescription = commentItem.comment;

            var comment = '<div id="' + commentItemId + '" style="display: flex;">' +
                '<div>' +
                '<a href="/" onclick="navigateToUrlByEmail(event,\'' + userFriendGetProfilePath + '\',\'' + commentItem.email + '\')">' +
                '<img class="boxShadowBig" src="' + commentUserProfileImageUrl + '" width="60" height="60" style="margin: 10px;">' +
                '</a>' +
                '</div>' +
                '<div style="padding: 10px;">' +
                '<a class="profileNameLink" href="/" onclick="navigateToUrlByEmail(event,\'' + userFriendGetProfilePath + '\',\'' + commentItem.email + '\')">' +
                '<h4><b>' + commentUsername + '</b></h4></a>' +
                '<div> ' + commentDescription + '</div>' +
                '</div>' +
                '</div>';

            $(comment).appendTo("#" + commentsBoxId);
        }


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















