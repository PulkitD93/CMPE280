 google.charts.load("current", {packages:["sankey","corechart"]});
  google.charts.setOnLoadCallback(drawChart);
    function redirect() {
      window.location.href="../index.html";
    }
   function drawChart() {
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

	var dataRows= new Array();
	if(screen10>0)
		dataRows.push(['Hand Tossed', 'Small', screen10]);
	if(screen12>0)
		dataRows.push(['Hand Tossed', 'Medium', screen12]);
	if(screen14>0)
		dataRows.push(['Hand Tossed', 'Large', screen14]);
	if(p12ipaza>0)
		dataRows.push(['HandMade Pan', 'Medium', p12ipaza]);
	if(thin12>0)
		dataRows.push(['Crunchy Thin Crust', 'Medium', thin12]);
	if(thin14>0)
		dataRows.push(['Crunchy Thin Crust', 'Large', thin14]);
	if(pbkikreza>0)
		dataRows.push(['Brooklyn Style', 'Large', pbkikreza]);
	if(p16ibkza>0)
		dataRows.push(['Brooklyn Style', 'Large', p16ibkza]);
	if(p10igfza>0)
		dataRows.push(['Gluten Free Crust', 'Small', p10igfza]);
	
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'From');
    data.addColumn('string', 'To');
    data.addColumn('number', 'Weight');
    data.addRows(dataRows);

    // Set chart options
    var options = {
      width: 600,
    };

    // Instantiate and draw our chart, passing in some options.
    var chart = new google.visualization.Sankey(document.getElementById('sankey'));
    chart.draw(data, options);
   }

// google.charts.load('current', {'packages':[]});
google.charts.setOnLoadCallback(drawChart2);
 
   function drawChart2() {
   		var pepper=sessionStorage.pepper?parseInt(sessionStorage.pepper):0,
		sis=sessionStorage.sis?parseInt(sessionStorage.sis):0,
		bacon=sessionStorage.bacon?parseInt(sessionStorage.bacon):0,
		salami=sessionStorage.salami?parseInt(sessionStorage.salami):0,
		pchick=sessionStorage.pchick?parseInt(sessionStorage.pchick):0,

		ccheese=sessionStorage.ccheese?parseInt(sessionStorage.ccheese):0,
		onions=sessionStorage.onions?parseInt(sessionStorage.onions):0,
		mushrooms=sessionStorage.mushrooms?parseInt(sessionStorage.mushrooms):0,
		gpeppers=sessionStorage.gpeppers?parseInt(sessionStorage.gpeppers):0,
		bOlives=sessionStorage.bOlives?parseInt(sessionStorage.bOlives):0;
        
        var data = google.visualization.arrayToDataTable([
          ['Toppings', 'popularity'],
          ['Pepper',     pepper],
          ['Sliced Italian Sausage',      sis],
          ['Bacon',  bacon],
          ['Premium Chicken', pchick],
          ['Chedder Cheese',    ccheese],
          ['Onions',    onions],
          ['Salami',salami],
          ['Mushrooms',    mushrooms],
          ['Green Pepper',    gpeppers],
          ['Black Olives',    bOlives],
        ]);

        var options = {
          title: 'Toppings Popularity'
        };

        var chart = new google.visualization.PieChart(document.getElementById('pieChart'));

        chart.draw(data, options);
      }
