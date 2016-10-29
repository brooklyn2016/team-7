
    color = d3.scale.category20c();     //builtin range of colors


    var array = [];
    var svg;
    var update1 = [];
    var path;

    var questions = [];

    var m = 100,
        r = 300,
        z = d3.scale.category20c();

    var JSON = {
         "Haiti": [
           {
             "pk_statistics": null,
             "stat": "Slaves freed",
             "val": 12,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Communities receiving support",
             "val": 30,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Community Members educated on rights and risks",
             "val": 50,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Communities that have reached full maturity",
             "val": 20,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Slaves effectively re-intergrated",
             "val": 20,
             "stat-id": null
           }
         ],
         "Ghana": [
           {
             "pk_statistics": null,
             "stat": "Slaves freed",
             "val": 125,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Communities receiving support",
             "val": 30,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Community Members educated on rights and risks",
             "val": 500,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Communities that have reached full maturity",
             "val": 200,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Slaves effectively re-intergrated",
             "val": 20,
             "stat-id": null
           }
         ],
         "India": [
           {
             "pk_statistics": null,
             "stat": "Slaves freed",
             "val": 125,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Communities receiving support",
             "val": 30,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Community Members educated on rights and risks",
             "val": 500,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Communities that have reached full maturity",
             "val": 200,
             "stat-id": null
           },
           {
             "pk_statistics": null,
             "stat": "Slaves effectively re-intergrated",
             "val": 20,
             "stat-id": null
           }
         ]
        }

    var q0 = [];
    var q1 = [];
    var q2 = [];
    var q3 = [];
    var q4 = [];

    var i=0;
    $.each(JSON, function(n, item) {

      // console.log("ITEM: " + item);
       $.each(item, function(question, obj) {
          // console.log(question);
          // console.log(obj.val);
          if (obj.stat == "Slaves freed") {
            // console.log("yeah");
            questions[0] = obj.stat;
            q0[i] = obj.val;
          } else if (obj.stat == "Communities receiving support") {
            questions[1] = obj.stat;
            q1[i] = obj.val;
          } else if (obj.stat == "Community Members educated on rights and risks") {
            questions[2] = obj.stat;
            q2[i] = obj.val;
          } else if (obj.stat == "Communities that have reached full maturity") {
            questions[3] = obj.stat;
            q3[i] = obj.val;
          } else if (obj.stat == "Slaves effectively re-intergrated") {
            questions[4] = obj.stat;
            q4[i] = obj.val;
          }
       });
       i++;
    });
    q0 = [q0];
    q1 = [q1];
    q2 = [q2];
    q3 = [q3];
    q4 = [q4];



    array = q0;

  
    // Insert an svg element (with margin) for each row in our dataset. A child g
    // element translates the origin to the pie center.

      svg = d3.select("#pie_div").selectAll("svg")
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




 function filter_selection() {
    var q = d3.select("#questions").node().value;
     $.each(questions, function(i, quest) {
        if (q == quest) {
            //set array
           array = window["q" + i];
        }
    });

    d3.select("#mypiechart").remove();


    svg = d3.select("#pie_div").selectAll("svg")
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