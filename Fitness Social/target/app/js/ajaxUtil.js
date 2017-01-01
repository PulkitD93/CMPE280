/**
 * Created by shikh on 27-Nov-16.
 */


/**
 * Utilities for common jax operations
 */



function ajaxCall(method, url, data, callback) {
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = handleResponse;
    httpRequest.open(method, url);
    httpRequest.setRequestHeader("Content-Type", "application/json");
    httpRequest.send(JSON.stringify(data));

    function handleResponse() {
        if (httpRequest.readyState == 4) {
            callback(httpRequest.status, httpRequest.responseText);
        }
    }
}

function doLike(event, newsFeedItemId, likecount) {
    var imageUrl = event.target.src;
    var likeId = newsFeedItemId + "like";
    var likeImageId = likeId + "img";
    var likeImageURL = "https://s18.postimg.org/6tk42epbt/like.png";
    var unlikeImageURL = "https://s17.postimg.org/lw0xkd7m7/unlike.png";
    var toLike = false;
    var url = "/app/newsfeed/" + newsFeedItemId + "/like?userToken=" + localStorage.getItem("userToken");
    var verb = "POST";


    if (imageUrl === likeImageURL) {
        toLike = true;
    } else {
        toLike = false;
    }

    if (toLike) {
        url = "/app/newsfeed/" + newsFeedItemId + "/like?userToken=" + localStorage.getItem("userToken");
        verb = "POST";
    } else {
        url = "/app/newsfeed/" + newsFeedItemId + "/unlike?userToken=" + localStorage.getItem("userToken");
        verb = "PUT";
    }


    var userToken = localStorage.getItem("userToken");
    var reqObj = {};
    ajaxCall(verb, url, reqObj, function (status, resData) {
        if (status === 200) {
            var data = JSON.parse(resData);
            updateLikeCount(data.likeCount, newsFeedItemId + "like");
            var emailList = data.emailList;
            var currentUserEmail = localStorage.getItem("userEmail");
            var ifUserLiked = contains(emailList, currentUserEmail);

            if (ifUserLiked) {
                document.getElementById(likeImageId).src = unlikeImageURL;
            } else {
                document.getElementById(likeImageId).src = likeImageURL;
            }
        }
        else {
            console.log("Like not working");
            console.log(url);
            console.log(status);
            console.log(data);
        }
    });
}

function contains(a, obj) {
    for (var i = 0; i < a.length; i++) {
        if (a[i] === obj) {
            return true;
        }
    }
    return false;
}


function updateLikeCount(likecount, itemId) {
    $('#' + itemId).html(likecount + " Likes");
}


function navigate(path) {
    window.location.href = path;
}

function navigateToUrl(e, path) {
    e.preventDefault();
    localStorage.setItem("currentProfileEmail", localStorage.getItem("userEmail"));
    localStorage.setItem("currentProfileEmailIsFriend", "false");
    localStorage.setItem("currentProfileEmailIsConfirmFriend", "false");
    window.location.href = path;
}


function navigateToUrlByEmail(e, path, email) {
    e.preventDefault();
    localStorage.setItem("currentProfileEmail", email);
    localStorage.setItem("currentProfileEmailIsFriend", "false");
    localStorage.setItem("currentProfileEmailIsConfirmFriend", "false");
    window.location.href = path;
}

function navigateToFriendByEmail(e, path, email) {
    e.preventDefault();
    localStorage.setItem("currentProfileEmail", email);
    localStorage.setItem("currentProfileEmailIsFriend", "true");
    localStorage.setItem("currentProfileEmailIsConfirmFriend", "false");
    window.location.href = path;
}

function navigateToConfirmFriendByEmail(e, path, email) {
    e.preventDefault();
    localStorage.setItem("currentProfileEmail", email);
    localStorage.setItem("currentProfileEmailIsFriend", "false");
    localStorage.setItem("currentProfileEmailIsConfirmFriend", "true");
    window.location.href = path;
}


function addFriend(email, callback) {
    var url = "/app/addFriend?userToken=" + localStorage.getItem("userToken") + "&friendEmail=" + email;
    var reqObj = {};
    ajaxCall("POST", url, reqObj, function (status, data) {
        if (status !== 200) {
            callback(false);
        } else {
            callback(true);
        }
    });
}


function confirmFriend(email, action, callback) {

    var url = "/app/confirmFriend?userToken=" + localStorage.getItem("userToken") + "&friendEmail=" + email + "&actiontaken=" + action;
    var reqObj = {};
    ajaxCall("POST", url, reqObj, function (status, data) {
        if (status !== 200) {
            callback(false);
        } else {
            var message = JSON.parse(data).message;
            if (message === "True") {
                callback(true);
            } else {
                callback(false);
            }
        }
    });
}


function showStatus(text) {

    var statusHolder = document.getElementById("statusHolder");
    statusHolder.innerHTML = "";

    var status = '<div id="status" class="btn btn-primary boxShadowBigStatus" style="z-index: 2;position: absolute;top: -20%;left: 35%;width: 30%;word-break: break-all;padding: 20px">' +
        '<b>' + text + '</b>' +
        '</div>';
    $(status).appendTo("#statusHolder");

}


function getAllUrlParams(url) {

    // get query string from url (optional) or window
    var queryString = url ? url.split('?')[1] : window.location.search.slice(1);

    // we'll store the parameters here
    var obj = {};

    // if query string exists
    if (queryString) {

        // stuff after # is not part of query string, so get rid of it
        queryString = queryString.split('&')[0];


        // split our query string into its component parts
        var arr = queryString.split('&');

        for (var i = 0; i < arr.length; i++) {
            // separate the keys and the values
            var a = arr[i].split('=');

            // in case params look like: list[]=thing1&list[]=thing2
            var paramNum = undefined;
            var paramName = a[0].replace(/\[\d*\]/, function (v) {
                paramNum = v.slice(1, -1);
                return '';
            });

            // set parameter value (use 'true' if empty)
            var paramValue = typeof(a[1]) === 'undefined' ? true : a[1];

//                        // (optional) keep case consistent
//                        paramName = paramName.toLowerCase();
//                        paramValue = paramValue.toLowerCase();

            // if parameter name already exists
            if (obj[paramName]) {
                // convert value to array (if still string)
                if (typeof obj[paramName] === 'string') {
                    obj[paramName] = [obj[paramName]];
                }
                // if no array index number specified...
                if (typeof paramNum === 'undefined') {
                    // put the value on the end of the array
                    obj[paramName].push(paramValue);
                }
                // if array index number specified...
                else {
                    // put the value at that index number
                    obj[paramName][paramNum] = paramValue;
                }
            }
            // if param name doesn't exist yet, set it
            else {
                obj[paramName] = paramValue;
            }
        }
    }

    return obj;
}



