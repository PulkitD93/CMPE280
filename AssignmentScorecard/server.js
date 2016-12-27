var app = require('http').createServer(handler),
// var io = require('socket.io')(app);

WebSocketServer = require('ws').Server
    , wss = new WebSocketServer({server: app})
var fs = require('fs');

var tScore =0;
var over =0;
app.listen(9980);

function handler (req, res) {
  fs.readFile(__dirname + '/index.html',
  function (err, data) {
    if (err) {
      res.writeHead(500);
      return res.end('Error loading index.html');
    }

    res.writeHead(200);
    res.end(data);
  });
}
//Switch io.on on button click
wss.on('connection', function (socket) {

  setInterval(function () {
  	var cur=Math.floor(Math.random()*7);
  	var messages=["Very good catch by mid-on player","hat trick", "Good Shot", "Missed to field", "Classic Text Book Shot",  "Classical Sot", "Unbelievable miss" ];
	var curMes;
	if(cur===5){
		curMes="Commentary: "+messages[Math.floor(Math.random()*2)];
	}
	else if(cur===4|| cur===6)
		{
		tScore=tScore+cur;
		curMes="Commentary: "+messages[Math.floor(Math.random()*5)+2]
}
	else
	{
		tScore=tScore+cur;
		curMes="";
	}
	over++;
	var scoreString=tScore+"runs - "+over+"overs \n"+curMes; //score String
	try{
  	socket.send(scoreString);
  	}
  	catch(e){
  		//NOt handling
  	}
  },5000);
  

}); 
