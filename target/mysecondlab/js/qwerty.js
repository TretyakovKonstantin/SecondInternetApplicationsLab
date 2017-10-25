let canvas
let itmoGovno ="#DF0000"
function piska(radius) {
    alert("suka"+  radius);
    canvas = document.getElementById("areaCanvas");
    // radius = document.querySelector('input[class="r-button"]:focus').value;
    drawGraph(canvas, radius, itmoGovno);
}