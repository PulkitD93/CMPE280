 
function login(){
    var uname=document.getElementById("uname").value;
    var upass=document.getElementById("pword").value;
    if(uname==="sjsu"&& upass==="sjsu"){
        window.location="pages/Question1.html";
    }
    else{
        alert("Re-enter sjsu as uid and password");
    }

    return false;
}
function checkAns1() {
	var cAns = 'd';
	var ans;
	var qScore=0;
	var qAttempt=1;
	var radios = document.getElementsByName('option');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			ans = radios[i].value;
			break;
		}
		}
		
	if(ans===cAns){
		qScore++;
	}
	else if(!ans){
		qAttempt=0;
	}
	console.log(qScore);
	localStorage.setItem('qScore',qScore);
	localStorage.setItem('qAttempt',qAttempt);
	console.log(localStorage.getItem('qAttempt'));
	window.location.href = "Question2.html";
}
function checkAns2() {
	var cAns = 'a';
	// console.log(cAns);
	var ans;
	var qAttempt=parseInt(localStorage.getItem('qAttempt'));
	var qScore=parseInt(localStorage.getItem('qScore'));
	var radios = document.getElementsByName('option');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			ans = radios[i].value;
			break;
		}
	}
	console.log(qAttempt+" schbs");
	qAttempt++;
	if(ans===cAns){
		qScore++;
	}
	else if(!ans){
		qAttempt--;
	}
	console.log(ans+ "   "+ cAns);
	console.log(qScore);
	localStorage.setItem('qScore',qScore);
	localStorage.setItem('qAttempt',qAttempt);
	console.log(localStorage.getItem('qAttempt')+" Tha");
	window.location.href = "Question3.html";
}
function checkAns3() {
	var cAns1 = '$650';
	var cAns2='Twitter';
	var rScore=0;
	var rAttempt=1;
	// console.log(cAns1+"  "+cAns2);
	var ans1, ans2;
	var radio1 = document.getElementsByName('option1');
	for (var i = 0, length = radio1.length; i < length; i++) {
		if (radio1[i].checked) {
			ans1 = radio1[i].value;
			break;
		}
	}
	var radio2 = document.getElementsByName('option2');
	for (var i = 0, length = radio2.length; i < length; i++) {
		if (radio2[i].checked) {
			ans2 = radio2[i].value;
			break;
		}
	}
	//Write for null case
	if(ans1===cAns1&&ans2===cAns2){
		rScore++;
	}
	else if(!ans1&&!ans2)
		rAttempt--;
	console.log(rScore);
	localStorage.setItem('rScore',rScore);
	localStorage.setItem('rAttempt',rAttempt);
	
	window.location.href = "Question4.html";
}
function checkAns4() {
	var cAns = 'a';
	//console.log(cAns);
	var avScore=0;
	var avAttempt=1;
	var ans;
	var radios = document.getElementsByName('option');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			ans = radios[i].value;
			break;
		}
	}
	if(ans===cAns){
		avScore++;
	}
	else if(!ans)
		avAttempt--;
	console.log(avScore);
	localStorage.setItem('avScore',avScore);
	localStorage.setItem('avAttempt',avAttempt);
	
	window.location.href = "Survey.html";
}
function getScore(){
	
	window.location.href="Summ.html";

}

function fillBlank1() {
	var answer;
	var radios = document.getElementsByName('option1');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			answer = radios[i].value;
			break;
		}
	}
	console.log(answer);
	document.getElementById("fill1").innerHTML = ""+answer;
}


function fillBlank2() {
	var answer;
	var radios = document.getElementsByName('option2');
	for (var i = 0, length = radios.length; i < length; i++) {
		if (radios[i].checked) {
			answer = radios[i].value;
			break;
		}
	}
	document.getElementById("fill2").innerHTML = ""+answer;
}
