var express = require("express");

var app = express();

app.use(express.static('public'));
app.use(express.static('node_modules'));

app.get("/", function (req, res) {
    res.redirect("/main.html");
});


app.listen(80, function () {
    console.log("Server starter at port 80");
});