$(document).ready(function(){

	$("#vPass").focusout(function (){	//validatePassword
		var pass1= $("#pass").val();
		var pass2= $("#vPass").val();
		if(pass1!==pass2||pass1=== null){
			{
				$("<div class=\"alert dngr\"><span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;PASSWORD invalidation</span></div><br>").insertAfter('header');
				console.log("invalidation");
			}
		}
		
	});
	$("#vPass, #vEmail").focusin(function(){
		$('.dngr').remove();
	});
	$("#pass").focusin(function(){
		$('.alert').remove();
	});
	
	$("#vEmail").focusout(function (){	//validateEmail

		var email1= $("#email").val();
		var email2= $("#vEmail").val();
		if(email1!==email2|| email1 === null){
			$("<div class=\"alert dngr\"><span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;Email invalidation</span></div><br>").insertAfter('header');
					
		}
	});
	$("#submitBtn").click(function() {	//saveData
		var uID=$("#userId").val();
		var pass=$("#pass").val();
		var	email=$("#email").val();
		var q0=$("#SecurityQ0").val(),		a0=$("#SecurityA0").val(),		q1=$("#SecurityQ1").val();
		var a1=$("#SecurityA1").val(),		mnum=$("#mnumber").val(),		add=$("#address").val(),		aoi=$("#AOI").val();
		console.log("Address is"+add);
		//session storage
		if (typeof(Storage) !== "undefined") { //CHECK IF BROWSER SUPPORTS STORAGE
			if(uID&& pass&& email&& q0&& a0&& q1&& a1){
			sessionStorage.username = uID;
			sessionStorage.password = pass;
			sessionStorage.email = email;
			sessionStorage.question0 = q0;
			sessionStorage.answer0 = a0;
			sessionStorage.question1 = q1;
			sessionStorage.answer1 = a1;
			sessionStorage.mobile = mnum;
			sessionStorage.address = add;
			sessionStorage.aoi = aoi;
			//Alert about succesful registration
			alert("USER sucessfully registered");
		}
		else
			alert("Enter All Mandatory Fields");
		}
		else{
			alert("NO STORAGE SUPPORT!!");
		}
	});
	$("#pass").keyup(function (){	//strengthChecker
		$('p').html("");
		var metric=0;
		var strengthStr;
		//get password
		var pass=$("#pass").val();
		//if uppercase increment metric by 1--Regex [A-Z]
		var upperCase= new RegExp('[A-Z]');
		if(pass.match(upperCase))
			metric++;
		//if lowercase increment metric by 1
		var lowercase=new RegExp('[a-z]');
		if (pass.match(lowercase))
			metric++;
		//if number found increment
		var numbers = new RegExp('[0-9]');
		if (pass.match(numbers))
			metric++;
		//8 or more length increase by 1
		if(pass.length>8)
			metric++;
		//English Char except A-z 0-9 @ - _ . decrease 1(increase 1 before this step).
		metric++;
		var negSymbol = new RegExp('[^a-zA-Z0-9@-_.]');	//console log to check
		if(pass.match(negSymbol))
			metric--;
		//userId match set to 0
		var uId=$("#userId").val();
		if (pass===uId)
			metric=0;

		if(metric<=2)
			strengthStr="Weak";
		else if(metric<4)
			strengthStr="Medium";
		else
			strengthStr="Strong";
		//use metric to add to progress and display.
		$("progress").val(metric);
		$("#pStren").removeAttr("hidden");
		$("<p>"+strengthStr+"</p>").insertAfter('progress');
	}).focusout(function () {
		//
		var valid=0;
		var pass=$("#pass").val();
		var userId=$("#userId").val();
		var errorMsg="";
		console.log(errorMsg);
		var  alphaReg = new RegExp('[A-Za-z]+');
		//check for pass length 7-20
		if(pass.length<7||pass.length>20){
			errorMsg=errorMsg+"Inavlid Length \n";
		}

		//match 4 alpha chars
		var alpha =pass.match(alphaReg)?pass.match(alphaReg):[""];
		console.log("length of alpha"+alpha[0].length+" "+alpha);
		if(alpha[0].length<4)
			errorMsg=errorMsg+"Invalid number of alpha chars\n";
		//match 1 numeric or 1 special char-!,#,$,%
		var numMatch=pass.match(new RegExp('[0-9!#$%]'));
		if(numMatch<1)
			errorMsg=errorMsg+"Insert a number or special char\n";
		//no space
		if(pass.match(/\s/))
			errorMsg=errorMsg+"Remove space from password\n";
		//no userId
		if(pass===userId)
			errorMsg=errorMsg+"Please use different password than username\n";
		if(errorMsg.length>1)
				$("<div class=\"alert\"><span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;"+"Weak password<br>"+errorMsg+"</span></div><br>").insertAfter('header');
				
	});
	});