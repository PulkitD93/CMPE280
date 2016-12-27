$(document).ready(function () {
	var status=navigator.onLine?"online":"offline";
	console.log(status);
	$("mark").html(status+";");
	$("<div id=\"status\"></div>").insertAfter('h1');
		
	function updateStatus() {
		var stat = navigator.onLine?"online":"offline";
		$('#status').html(stat);
		$('#status').removeClass();//remove class before adding class
		$('#status').addClass(stat); //for alert styling
		$("mark").append(" "+stat+";");
	}
	window.addEventListener('online',updateStatus);
	window.addEventListener('offline',updateStatus);
	
}) 
