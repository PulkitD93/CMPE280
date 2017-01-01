/**
 * Created by shikh on 27-Nov-16.
 */


var signUpRequestObj = {};
var loginRequestObj = {};


function checkAuthentication(page) {
    var authenticated = localStorage.getItem("authenticated");
    if (authenticated === "true" && window.location.href.indexOf("/app/NewsFeed.html") == -1) {
        window.location.href = "/app/NewsFeed.html";
    } else if (authenticated === "false" && window.location.href.indexOf("/app/" + page) == -1) {
        window.location.href = "/app/" + page;
    }
}

function getToken() {
    if (localStorage.getItem("authenticated") === "true") {
        return localStorage.getItem("userToken");
    } else {
        return null;
    }
}


function signup(e) {
    e.preventDefault();
    var error = document.getElementById("error");
    error.style.visibility = "none";
    var email, gender, firstName, lastName, password;
    var errorMessage = "";

    var signupForm = e.target;
    var inputArray = signupForm.getElementsByTagName("input");

    for (var i = 0; i < inputArray.length; i++) {
        var input = inputArray[i];

        if (input.getAttribute("name") === "firstName") {
            signUpRequestObj["firstName"] = input.value;
            firstName = input.value;
        }

        if (input.getAttribute("name") === "lastName") {
            signUpRequestObj["lastName"] = input.value;
            lastName = input.value;
        }

        if (input.getAttribute("name") === "email") {
            email = input.value;
            signUpRequestObj["email"] = input.value;
        }

        if (input.getAttribute("name") === "password") {
            signUpRequestObj["userpassword"] = input.value;
            password = input.value;
        }

        if (input.getAttribute("name") === "gender" && input.value === "male" && input.checked) {
            gender = "male";
            signUpRequestObj["gender"] = "male";
        }

        if (input.getAttribute("name") === "gender" && input.value === "female" && input.checked) {
            gender = "female";
            signUpRequestObj["gender"] = "female";
        }
    }

    console.log(email.indexOf("@"));

    //do validation
    if (firstName === undefined || firstName === "") {
        errorMessage = "Enter your first name."
        error.innerHTML = errorMessage;
        error.style.display = "block";
        inputArray[0].focus();
        return;
    } else if (lastName === undefined || lastName === "") {
        errorMessage = "Enter your last name."
        error.innerHTML = errorMessage;
        error.style.display = "block";
        inputArray[1].focus();
        return;
    }
    else if (email === undefined || email.indexOf("@") === -1) {
        errorMessage = "Enter email in proper format."
        error.innerHTML = errorMessage;
        error.style.display = "block";
        inputArray[2].focus();
        return;
    }
    else if (password === undefined || password === "") {
        errorMessage = "Enter your password"
        error.innerHTML = errorMessage;
        error.style.display = "block";
        inputArray[3].focus();
        return;
    } else if (gender === undefined) {
        errorMessage = "Select a gender."
        error.innerHTML = errorMessage;
        error.style.display = "block";
        inputArray[4].focus();
        return;
    }


    signUpRequestObj["usertype"] = "user";

    //store the object in session storage temporarily
    sessionStorage.setItem("signUpRequestObj", JSON.stringify(signUpRequestObj));

    //do Oauth and get fitbit userID, toke, and duration

    var fitbitUrl = "";
    
    window.location.href = fitbitUrl;


}


function getCurrentLocation(e) {
    e.preventDefault();

    //ask for user for his location
    //gives problem on chrome

    var locationDiv = document.getElementById("locationDiv");

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;
            signUpRequestObj["latitude"] = latitude;
            signUpRequestObj["longitude"] = longitude;
        });
    }

    locationDiv.style.display = "none";
}


function login(e) {
    e.preventDefault();
    var loginForm = e.target;
    var inputArray = loginForm.getElementsByTagName("input");

    for (var i = 0; i < inputArray.length; i++) {
        var input = inputArray[i];

        if (input.getAttribute("name") === "email") {
            loginRequestObj["email"] = input.value;
        }

        if (input.getAttribute("name") === "password") {
            loginRequestObj["password"] = input.value;
        }
    }

    ajaxCall("POST", "/app/login", loginRequestObj, function (status, body) {
        if (status == 200) {
            //get userToken in auth response
            var responseObj = JSON.parse(body);

            if (responseObj.message === "wrongcredentials") {
                window.location.href = "/app/Login.html?errorMessage=" + responseObj.message;
                return;
            }
            localStorage.setItem("userToken", responseObj.message);
            localStorage.setItem("authenticated", "true");
            localStorage.setItem("userEmail", loginRequestObj["email"]);
            window.location.href = "/app/NewsFeed.html";
        } else {
            window.location.href = "/app/Login.html";
        }
    });
}

function logout(e) {
    e.preventDefault();
    var userToken = localStorage.getItem("userToken");
    var url = "/app/logout";

    if (userToken !== "") {
        url = url + "?userToken=" + userToken;

        var logoutRequestObj = {};

        ajaxCall("PUT", url, logoutRequestObj, function (status, body) {
            if (status == 200) {
                localStorage.setItem("authenticated", "false");
                localStorage.setItem("userToken", "");
                localStorage.setItem("userEmail", "");
                window.location.href = "/app/Login.html";
            } else {
                console.log("Logout not done : " + status + " userToken : " + userToken);
            }
        });
    }


}


function boxShadowOnFocus(event) {
    //console.log(event.target);
}




