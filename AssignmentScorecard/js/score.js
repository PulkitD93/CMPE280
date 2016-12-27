$(document).ready(function () {
  var socket;

  function conn() {
  	console.log("connect")
  socket = new WebSocket('ws://localhost:9980');
  socket.onmessage= function (data) {
  	console.log(data);
    $( "#Score" ).html( "Current Score:"+data.data);
  };
  }
  conn();
  $("#tuneOut").click(function () {
    	socket.close();
    	socket=null;
    	console.log("disconnect")
    });
  $("#tuneIn").click(function () {
  	conn();
  });
}); 
