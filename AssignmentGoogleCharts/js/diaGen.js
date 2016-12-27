$(document).ready(function() {
		// body...

	$('#nextBtn').click(function () {
			if (typeof(Storage) !== "undefined") { //CHECK IF BROWSER SUPPORTS STORAGE
				var screen10, screen12, screen14, p12ipaza, thin12, thin14, pbkikreza, p16ibkza, p10igfza;
				screen10=sessionStorage.screen10?parseInt(sessionStorage.screen10):0;
				screen12=sessionStorage.screen12?parseInt(sessionStorage.screen12):0;
				screen14=sessionStorage.screen14?parseInt(sessionStorage.screen14):0;
				p12ipaza=sessionStorage.p12ipaza?parseInt(sessionStorage.p12ipaza):0;
				thin12=sessionStorage.thin12?parseInt(sessionStorage.thin12):0;
				thin14=sessionStorage.thin14?parseInt(sessionStorage.thin14):0;
				pbkikreza=sessionStorage.pbkikreza?parseInt(sessionStorage.pbkikreza):0;
				p16ibkza=sessionStorage.p16ibkza?parseInt(sessionStorage.p16ibkza):0;
				p10igfza=sessionStorage.p10igfza?parseInt(sessionStorage.p10igfza):0;
				// console.log(screen10);
				var variant= $('input[name="S_PIZZA|Variant"]:checked').val();
			
				switch(variant){
					case '10SCREEN':
						screen10++;
						break;
					case '12SCREEN':
						screen12++;
					break;
					case '14SCREEN':
						screen14++;
					break;
					case 'P12IPAZA':
						p12ipaza++;
					break;
					case '12THIN':
						thin12++;
					break;
					case '14THIN':
						thin14++;
					break;
					case 'PBKIREZA':
						pbkikreza++;
					break;
					case 'P16IBKZA':
						p16ibkza++;
					break;
					case 'P10IGFZA':
						p10igfza++;
					break;
			}
			sessionStorage.screen10=screen10;
			sessionStorage.screen12=screen12;
			sessionStorage.screen14=screen14;
			sessionStorage.p12ipaza=p12ipaza;
			sessionStorage.thin12=thin12;
			sessionStorage.thin14=thin14;
			sessionStorage.pbkikreza=pbkikreza;
			sessionStorage.p16ibkza=p16ibkza;
			sessionStorage.p10igfza=p10igfza;
			window.location.href="pages/cheese.html";
			}
		else
			alert("NO STORAGE SUPPORT!!");	
	});
	$("#nextBtn2").click(function () {
		window.location.href='toppings.html';
	});
	$('#cheeseCheck').click(function() {
    	$("#cheeseType").toggle(this.checked);
	});
	$('#sauceCheck').click(function () {
		$('#toppingSelect').toggle(this.checked);
	});
	$('#build').click(function(){
		pepper=sessionStorage.pepper?parseInt(sessionStorage.pepper):0;
		sis=sessionStorage.sis?parseInt(sessionStorage.sis):0;
		bacon=sessionStorage.bacon?parseInt(sessionStorage.bacon):0;
		salami=sessionStorage.salami?parseInt(sessionStorage.salami):0;
		pchick=sessionStorage.pchick?parseInt(sessionStorage.pchick):0;

		ccheese=sessionStorage.ccheese?parseInt(sessionStorage.ccheese):0;
		onions=sessionStorage.onions?parseInt(sessionStorage.onions):0;
		mushrooms=sessionStorage.mushrooms?parseInt(sessionStorage.mushrooms):0;
		gpeppers=sessionStorage.gpeppers?parseInt(sessionStorage.gpeppers):0;
		bOlives=sessionStorage.bOlives?parseInt(sessionStorage.bOlives):0;
		
		$("input:checkbox[name='S_PIZZA|Topping']:checked").each(function(){
			// console.log($(this).val());
    	switch($(this).val()){
    		case "Pepperoni":
    			pepper++;
    			break;
    		case "SIS":
    			sis++;
    			break;
    		case "Bacon":
    			bacon++;
    			break;
    		case "Salami":
    			salami++;
    			break;
    		case "PChicken":
    			pchick++;
    			break;
    		case "CCheese":
    			ccheese++;
    			break;
    		case "Onions":
    			onions++;
    			break;
    		case "Mushrooms":
    			mushrooms++;
    			break;
    		case "GPeppers":
    			gpeppers++;
    			break;
    		case "BOlives":
    			bOlives++;
    			break;

    	}
		});

		sessionStorage.pepper=pepper;
		sessionStorage.sis=sis;
		sessionStorage.bacon=bacon;
		sessionStorage.salami=salami;
		sessionStorage.pchick=pchick;
		sessionStorage.ccheese=ccheese;
		sessionStorage.onions=onions;
		sessionStorage.mushrooms=mushrooms;
		sessionStorage.gpeppers=gpeppers;
		sessionStorage.bOlives=bOlives;
		window.location.href="diagrams.html";
	});
	


	// $('#nextBtn2').click(function () {
	// 		var cheese, sauce;
			
	// 	if (typeof(Storage) !== "undefined") { //CHECK IF BROWSER SUPPORTS STORAGE
	// 		sessionStorage.cheese=cheese;
	// 		window.location.href="pages/topping.html";
	// 		}
	// 	else
	// 		alert("NO STORAGE SUPPORT!!");
	// }) 
})