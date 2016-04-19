var margin = {top: 20, right: 20, bottom: 30, left: 40},
    width = 1920;
    height = 1080;

var x = d3.scale.linear()
    .range([0, width]);

var y = d3.scale.linear()
    .range([height, 0]);

var color = d3.scale.category10();

var xAxis = d3.svg.axis()
    .scale(x)
    .orient("bottom");

var yAxis = d3.svg.axis()
    .scale(y)
    .orient("left");


var radius = d3.scale.linear()
    .range([3, 30]);

var svg = d3.select("body").append("svg")
    .attr("width", width + margin.left + margin.right)
    .attr("height", height + margin.top + margin.bottom)
  .append("g")
    .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

d3.tsv("EyeTrack-raw.tsv", function(error, data) {
  if (error) throw error;
  data.forEach(function(d) {
     d["GazePointX(px)"] = + d["GazePointX(px)"];
     d["GazePointY(px)"] = + d["GazePointY(px)"];

     d["FixationIndex"] = + d["FixationIndex"];
     d["GazeEventDuration(mS)"] = + d["GazeEventDuration(mS)"];
  });

  



  x.domain(d3.extent(data, function(d) { return  d["GazePointX(px)"]; }));
  y.domain(d3.extent(data, function(d) { return  d["GazePointY(px)"]; }));
  radius.domain(d3.extent(data, function(d) { return d["GazeEventDuration(mS)"]; })).nice();


  svg.append("g")
      .attr("class", "x axis")
      .attr("transform", "translate(0," + height + ")")
      .call(xAxis)
    .append("text")
      .attr("class", "label")
      .attr("x", width)
      .attr("y", -6)
      .style("text-anchor", "end")
      .text("GazePointX");

  svg.append("g")
      .attr("class", "y axis")
      .call(yAxis)
    .append("text")
      .attr("class", "label")
      .attr("transform", "rotate(-90)")
      .attr("y", 6)
      .attr("dy", ".71em")
      .style("text-anchor", "end")
      .text("GazePointY")

  	svg.selectAll(".dot")
      .data(data)
    .enter().append("circle")
      .attr("class", "dot")
      .attr("r", function(d) { return radius(d["GazeEventDuration(mS)"]); }) 
      .attr("cx", function(d) { return x(d["GazePointX(px)"]); })
      .attr("cy", function(d) { return y(d["GazePointY(px)"]); })
      .style("fill", function(d) { return color(d["RecordingTimeStamp"]); });



});
