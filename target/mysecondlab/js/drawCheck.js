let canvas;
let radius;
let itmoRed = "#009fe3";

window.addEventListener("load",
    function () {
        canvas = document.getElementById("areaCanvas");
        radius = document.getElementById("radius").value;
        drawGraph(canvas, radius, itmoRed);
        canvas.addEventListener("click", function (event)
        {
            let [x, y] = convertFromCanvasToPoint(canvas, event.clientX, event.clientY);
            sendValues(x, y, radius);
        });
    });