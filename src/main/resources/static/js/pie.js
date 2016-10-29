
    color = d3.scale.category20c();     //builtin range of colors


    var array = [];
    var svg;
    var update1 = [];
    var path;

    var m = 100,
        r = 300,
        z = d3.scale.category20c();

    var JSON = {
                "senegal": {
                    "q1": "90",
                    "q2": "20",
                    "q3": "30",
                    "q4": "70",
                    "q5": "70"
                },
                "india": {
                    "q1": "91",
                    "q2": "20",
                    "q3": "30",
                    "q4": "71",
                    "q5": "70"
                },
                "Drc": {
                    "q1": "92",
                    "q2": "20",
                    "q3": "30",
                    "q4": "72",
                    "q5": "70"
                }
            };

    var q1 = [];
    var q2 = [];
    var q3 = [];
    var q4 = [];
    var q5 = [];

    var i=0;
    $.each(JSON, function(n, item) {

      console.log("ITEM: " + item);
       $.each(item, function(question, value) {
          console.log(question);
          // console.log(value);
          if (question == "q1") {
            q1[i] = value;
          } else if (question == "q2") {
            q2[i] = value;
          } else if (question == "q3") {
            q3[i] = value;
          } else if (question == "q4") {
            q4[i] = value;
          } else if (question == "q5") {
            q5[i] = value;
          }
       });
       i++;
    });
    q1 = [q1];
    q2 = [q2];
    q3 = [q3];
    q4 = [q4];
    q5 = [q5];

    console.log(q1);
    console.log(q2);
    console.log(q3);
    console.log(q4);
    console.log(q5);


    // d3.csv("2015-Indicators-All-Countries.csv", function(error, data) {
    //   data.forEach(function(d, i) {

    //     //convert object to array
    //     var arr = Object.keys(d).map(function (key) { return d[key]; });
    //     d = arr;
    //     data[i] = arr;


    //     if (tar === d3.select("#questions").node().value) {
    //         array = [d.slice(0, d.length)];
    //     }

    //   });

    //    for (var i = 0; i < data.length; i++) {
    //         update1[i] = data[i].slice(0, data[i].length);
    //     }

    //    array[0][0] = 0; //so i don't have to make Target 0;

  
    // Insert an svg element (with margin) for each row in our dataset. A child g
    // element translates the origin to the pie center.
    var area =d3.select(document.getElementById("pie_div"));

    area.each(function (data) {
      svg = d3.select("body").selectAll("svg")
          .data(q1)
        .enter().append("svg")
          .attr("width", (r + m) * 2)
          .attr("height", (r + m) * 2)
          .attr("id", "mypiechart")
        .append("g")
          .attr("transform", "translate(" + (r + m) + "," + (r + m) + ")");


      var arc = d3.svg.arc()
              .innerRadius(r / 2)
              .outerRadius(r);
      var pie = d3.layout.pie();

      path = svg.selectAll("path")
          .data(pie)
        .enter().append("path")
          .attr("d", arc)
          .style("fill", function(d, i) { return z(i); })
          // .text(function(d, i) { return data[i].label; });  

      svg.append("text")
            .attr("dy", ".35em")
            .style("text-anchor", "middle")
            .text(function(d) { 
              var str = $("#questions :selected").text();
              str = str.substring(3, str.length);
              return str;
            })
            .style("fill", function(d){ return "white"; })


  });




 function filter_selection() {
    var q = d3.select("#questions").node().value;
    // console.log(q);

    update1.forEach(function(d, i) {
        // console.log(d[0]);
        if (d[0] === d3.select("#questions").node().value) {
            console.log("YEP");
            array = [d.slice(0, d.length)];
        }
    });

    array[0][0] = 0;
    d3.select("#mypiechart").remove();

    console.log(array);
    console.log(update1);


    svg = d3.select("body").selectAll("svg")
        .data(array)
      .enter().append("svg")
        .attr("width", (r + m) * 2)
        .attr("height", (r + m) * 2)
        .attr("id", "mypiechart")
      .append("g")
        .attr("transform", "translate(" + (r + m) + "," + (r + m) + ")");


    var arc = d3.svg.arc()
            .innerRadius(r / 2)
            .outerRadius(r);

    var pie = d3.layout.pie();

    path = svg.selectAll("path")
        .data(pie)
      .enter().append("path")
        .attr("d", arc)
        .style("fill", function(d, i) { return z(i); })

    svg.append("text")
          .attr("dy", ".35em")
          .style("text-anchor", "middle")
          .text(function(d) { 
            var str = $("#questions :selected").text();
            str = str.substring(3, str.length);
            return str;
          })
          .style("fill", function(d){ return "white"; })

    }

    // load data
    // d3.csv("2015-Indicators-All-Countries.csv", function(error, data) {
    //     data.forEach(function(d, i) {

    //         d.Brazil = parseInt(d.Brazil);
    //         d.DRC = parseInt(d.DRC);
    //         d.Ghana = parseInt(d.Ghana);
    //         d.Haiti = parseInt(d.Haiti);
    //         d.India = parseInt(d.India);
    //         d.Nepal = parseInt(d.Nepal);
    //         var tar = d.Target; //save for later
            
    //         d["Grand Total"] = +d["Grand Total"];
    //         if (!d["Grand Total"] ||  d["Grand Total"] == null)
    //             d["Grand Total"] = 1;

    //         if (!d.Brazil || d.Brazil == null)
    //           d.Brazil = 0;
    //         else 
    //             d.Brazil = d.Brazil/d["Grand Total"];
    //         if (!d.DRC || d.DRC == null ) 
    //           d.DRC = 0;
    //         else 
    //           d.DRC = d.DRC/d["Grand Total"];
    //         if (!d.Ghana || d.Ghana == null) 
    //             d.Ghana = 0;
    //         else 
    //           d.Ghana = d.Ghana/d["Grand Total"];
    //         if (!d.Haiti || d.Haiti == null) 
    //             d.Haiti = 0;
    //         else
    //           d.Haiti = d.Haiti/d["Grand Total"];
    //         if (!d.India || d.India == null) 
    //             d.India = 0;
    //         else
    //           d.India = d.India/d["Grand Total"];
    //         if (!d.Nepal || d.Nepal == null) 
    //             d.Nepal = 0;
    //         else
    //           d.Nepal = d.Nepal/d["Grand Total"];

            
    //         d["Grand Total"] = 0.1;

    //         //convert object to array
    //         var arr = Object.keys(d).map(function (key) { return d[key]; });
    //         d = arr;
    //         data[i] = arr;


    //         if (tar === d3.select("#questions").node().value) {
    //             array = [d.slice(0, d.length)];
    //         }
    //       });

    //        for (var i = 0; i < data.length; i++) {
    //             update1[i] = data[i].slice(0, data[i].length);
    //         }

    //        array[0][0] = 0; //so i don't have to make Target 0;

      
    //     // Insert an svg element (with margin) for each row in our dataset. A child g
    //     // element translates the origin to the pie center.
    //     svg = d3.select("body").selectAll("svg")
    //         .data(array)
    //       .enter().append("svg")
    //         .attr("width", (r + m) * 2)
    //         .attr("height", (r + m) * 2)
    //         .attr("id", "mypiechart")
    //       .append("g")
    //         .attr("transform", "translate(" + (r + m) + "," + (r + m) + ")");


    //     var arc = d3.svg.arc()
    //             .innerRadius(r / 2)
    //             .outerRadius(r);
    //     var pie = d3.layout.pie();

    //     path = svg.selectAll("path")
    //         .data(pie)
    //       .enter().append("path")
    //         .attr("d", arc)
    //         .style("fill", function(d, i) { return z(i); })
    //         .text(function(d, i) { return data[i].label; });  

    //     svg.append("text")
    //           .attr("dy", ".35em")
    //           .style("text-anchor", "middle")
    //           .text(function(d) { 
    //             var str = $("#questions :selected").text();
    //             str = str.substring(3, str.length);
    //             return str;
    //           })
    //           .style("fill", function(d){ return "white"; })


    // });




    //  function filter_selection() {
    //     var q = d3.select("#questions").node().value;
    //     // console.log(q);

    //     update1.forEach(function(d, i) {
    //         // console.log(d[0]);
    //         if (d[0] === d3.select("#questions").node().value) {
    //             console.log("YEP");
    //             array = [d.slice(0, d.length)];
    //         }
    //     });

    //     array[0][0] = 0;
    //     d3.select("#mypiechart").remove();

    //     console.log(array);
    //     console.log(update1);


    //     svg = d3.select("body").selectAll("svg")
    //         .data(array)
    //       .enter().append("svg")
    //         .attr("width", (r + m) * 2)
    //         .attr("height", (r + m) * 2)
    //         .attr("id", "mypiechart")
    //       .append("g")
    //         .attr("transform", "translate(" + (r + m) + "," + (r + m) + ")");


    //     var arc = d3.svg.arc()
    //             .innerRadius(r / 2)
    //             .outerRadius(r);

    //     var pie = d3.layout.pie();

    //     path = svg.selectAll("path")
    //         .data(pie)
    //       .enter().append("path")
    //         .attr("d", arc)
    //         .style("fill", function(d, i) { return z(i); })

    //     svg.append("text")
    //           .attr("dy", ".35em")
    //           .style("text-anchor", "middle")
    //           .text(function(d) { 
    //             var str = $("#questions :selected").text();
    //             str = str.substring(3, str.length);
    //             return str;
    //           })
    //           .style("fill", function(d){ return "white"; })

    //     }


