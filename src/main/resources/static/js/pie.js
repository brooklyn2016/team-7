    // var w = 500,                        //width
    // h = 500,                            //height
    // r = 200,                            //radius

    color = d3.scale.category20c();     //builtin range of colors

    // var vis;
    // var arc;
    // var pie;

    var array = [];
    var svg;
    var update1 = [];
    var path;

    var m = 100,
        r = 300,
        z = d3.scale.category20c();

    // load data
    d3.csv("2015-Indicators-All-Countries.csv", function(error, data) {
        data.forEach(function(d, i) {

            d.Brazil = parseInt(d.Brazil);
            d.DRC = parseInt(d.DRC);
            d.Ghana = parseInt(d.Ghana);
            d.Haiti = parseInt(d.Haiti);
            d.India = parseInt(d.India);
            d.Nepal = parseInt(d.Nepal);
            var tar = d.Target; //save for later

            d["Grand Total"] = +d["Grand Total"];
            if (!d["Grand Total"] ||  d["Grand Total"] == null)
                d["Grand Total"] = 1;

            if (!d.Brazil || d.Brazil == null)
              d.Brazil = 0;
            else
                d.Brazil = d.Brazil/d["Grand Total"];
            if (!d.DRC || d.DRC == null )
              d.DRC = 0;
            else
              d.DRC = d.DRC/d["Grand Total"];
            if (!d.Ghana || d.Ghana == null)
                d.Ghana = 0;
            else
              d.Ghana = d.Ghana/d["Grand Total"];
            if (!d.Haiti || d.Haiti == null)
                d.Haiti = 0;
            else
              d.Haiti = d.Haiti/d["Grand Total"];
            if (!d.India || d.India == null)
                d.India = 0;
            else
              d.India = d.India/d["Grand Total"];
            if (!d.Nepal || d.Nepal == null)
                d.Nepal = 0;
            else
              d.Nepal = d.Nepal/d["Grand Total"];


            d["Grand Total"] = 0.1;

            //convert object to array
            var arr = Object.keys(d).map(function (key) { return d[key]; });
            d = arr;
            data[i] = arr;


            if (tar === d3.select("#questions").node().value) {
                array = [d.slice(0, d.length)];
            }
          });

           for (var i = 0; i < data.length; i++) {
                update1[i] = data[i].slice(0, data[i].length);
            }

           array[0][0] = 0; //so i don't have to make Target 0;


        // Insert an svg element (with margin) for each row in our dataset. A child g
        // element translates the origin to the pie center.
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
            .text(function(d, i) { return data[i].label; });

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



      // function arcTween(a) {
      //   var i = d3.interpolate(this._current, a);
      //   this._current = i(0);
      //   return function(t) {
      //     return arc(i(t));
      //   };
      // }


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

        // path = svg.selectAll("path")
        //     .data(d3.layout.pie())
        //   .enter().append("path")
        //     .attr("d", d3.svg.arc()
        //         .innerRadius(r / 2)
        //         .outerRadius(r))
        //     .style("fill", function(d, i) { return z(i); })
        //     .text(function(d, i) { return data[i].label; });

        // svg.append("text")
        //       .attr("dy", ".35em")
        //       .style("text-anchor", "middle")
        //       .text(function(d) { return d3.select("#questions").node().value; })
        //       .style("fill", function(d){ return "pink"; })




        }


