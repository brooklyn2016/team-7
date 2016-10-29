
var arr = {};

d3.json("test.json", function(error, data) {
	arr = data;
	console.log(arr);
	console.log("laala");
});

function filter_selection() {
    var q = d3.select("#org").node().value;
    $.each(arr, function(i, item) {
		if (i === q) {
	   		$.each(item, function(radial, value) {
	   			console.log(radial); //type
	   			console.log(value); //value
	   			if (radial === "radial") {
	   				updateRadial(value);
	   			}
	   			if (radial === "radial2") {
					updateRadial2(value);
	   			}
	   			if (radial === "radial3") {
	   				updateRadial3(value);
	   			}
	   			if (radial === "radial4") {
	   				updateRadial4(value);
	   			}
	   		});
	   }
	});


}

var rp1 = radialProgress(document.getElementById("radial")) 
	.diameter(200)
	.value(10)
	.render();

var rp2 = radialProgress(document.getElementById("radial2")) 
	.diameter(200)
	.value(10)
	.render();

var rp3 = radialProgress(document.getElementById("radial3")) 
	.diameter(200)
	.value(10)
	.render();

var rp4 = radialProgress(document.getElementById("radial4")) 
	.diameter(200)
	.value(10)
	.render();

function updateRadial(val) {
	rp1.value(val)
		.render();
}

function updateRadial2(val) {
	rp2.value(val)
		.render();
}

function updateRadial3(val) {
	rp3.value(val)
		.render();
}

function updateRadial4(val) {
	rp4.value(val)
		.render();
}