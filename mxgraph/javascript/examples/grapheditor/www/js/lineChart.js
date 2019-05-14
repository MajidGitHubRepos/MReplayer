function lineChart()
{
	var elem = document.getElementById("showLineChartButton");
	var showChart = true;
	if (elem.value=="Show Line Chart") {elem.value = "Hide Line Chart"; showChart = true;}
	else {elem.value=="Show Line Chart"; showChart = false;}

	if (showChart){
		var cumTraceSize_mdebugger = []; // dataPoints
		var cumTraceSize_ourApproach = []; // dataPoints
		var chart = new CanvasJS.Chart("chartContainer", {
			title :{
				text: "Cumulative size of received traces"
			},
			axisY: {
				includeZero: false
			},      
			data: [{
				type: "line",
				color: "red",
				dataPoints: cumTraceSize_ourApproach
			},
			{
				type: "line",
				color: "blue",
				dataPoints: cumTraceSize_mdebugger
			}]
		});

		var xVal = 0;
		var yVal = 100; 
		var updateInterval = 1000;
		var dataLength = 20; // number of dataPoints visible at any point

		var updateChart = function (count) {

			count = count || 1;

			//for (var j = 0; j < count; j++) {
				yVal = yVal +  Math.round(5 + Math.random() *(-5-5));
				cumTraceSize_mdebugger.push({
					x: xVal,
					y: yVal
				});
				xVal++;
			//}

			if (cumTraceSize_mdebugger.length > dataLength) {
				cumTraceSize_mdebugger.shift();
			}

			chart.render();
		};

		updateChart(dataLength);
		setInterval(function(){updateChart()}, updateInterval);
	}

}