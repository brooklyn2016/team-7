
var arr = {
    "org1": {
        "radial": "90",
        "radial2": "20",
        "radial3": "30",
        "radial4": "70"
    },
    "org2": {
        "radial": "12",
        "radial2": "70",
        "radial3": "15",
        "radial4": "96"
    },
    "org3": {
        "radial": "10",
        "radial2": "100",
        "radial3": "12",
        "radial4": "43"
    }
};

//updateRadial("80");
//updateRadial2("50");
//updateRadial3("90");
//updateRadial4("10");
//d3.json("test.json", function(error, data) {
//	// $.each(data, function(i, item) {
//	// 	// if (i === d3.select("#orgs-select").node().value)
//	//    		 // console.log( item);
//	//    	arr
//	// });
//	arr = data;
//});

//function filter_selection() {
//    var q = d3.select("#org").node().value;
//    // console.log(q);
//
//    $.each(arr, function(i, item) {
//		if (i === q) {
//	   		$.each(item, function(radial, value) {
//	   			console.log(radial); //type
//	   			console.log(value); //value
//	   			if (radial === "radial") {
//	   				updateRadial(value);
//	   			}
//	   			if (radial === "radial2") {
//					updateRadial2(value);
//	   			}
//	   			if (radial === "radial3") {
//	   				updateRadial3(value);
//	   			}
//	   			if (radial === "radial4") {
//	   				updateRadial4(value);
//	   			}
//	   		});
//	   }
//	});
//
//
//}

var rp1 = radialProgress(document.getElementById("radial")) 
	.diameter(160)
	.value(60)
	.render();

var rp2 = radialProgress(document.getElementById("radial2")) 
	.diameter(160)
	.value(30)
	.render();

var rp3 = radialProgress(document.getElementById("radial3")) 
	.diameter(160)
	.value(06)
	.render();

var rp4 = radialProgress(document.getElementById("radial4")) 
	.diameter(160)
	.value(20)
	.render();

var rp5 = radialProgress(document.getElementById("radial5")) 
	.diameter(160)
	.value(10)
	.render();

var rp6 = radialProgress(document.getElementById("radial6")) 
	.diameter(160)
	.value(27)
	.render();

var rp7 = radialProgress(document.getElementById("radial7")) 
	.diameter(160)
	.value(05)
	.render();

var rp8 = radialProgress(document.getElementById("radial8")) 
	.diameter(160)
	.value(23)
	.render();

var rp9 = radialProgress(document.getElementById("radial9")) 
	.diameter(160)
	.value(10)
	.render();

var rp10 = radialProgress(document.getElementById("radial10")) 
	.diameter(160)
	.value(16)
	.render();

var rp11 = radialProgress(document.getElementById("radial11")) 
	.diameter(160)
	.value(35)
	.render();

var rp12 = radialProgress(document.getElementById("radial12")) 
	.diameter(160)
	.value(19)
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