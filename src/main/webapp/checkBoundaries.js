let form;
let canvas;
let radius;
let itmoRed = "#009fe3";

window.addEventListener("load",
    function () {
        form = document.forms['parameters'];
        canvas = document.getElementById("areaCanvas");
        radius = document.getElementById("rr").value;
        drawGraph(canvas, radius, itmoRed);
        canvas.addEventListener("click", function getPosition(event)
        {
            let [x, y] = convertFromCanvasToPoint(canvas, event.clientX, event.clientY);
            sendValues(x, y, radius);
        });
        let rButtons = Array.from(document.getElementsByName("r-butt"));
        for (let button of rButtons) {
            button.onclick = function () {
                form.r.value = button.value;
                radius = button.value;
                drawGraph(canvas, radius, itmoRed);
            };
        }
    });

function validateForm(form) {
    if (form.r.value === "0.0"){
        alert("Значение R не установлено")
        return false;
    }
    const REGEXP = /^[+-]?\d+(\.\d+)?$/;
    const yString = form.y.value;
    let newString =yString.replace(",", ".");
    form.y.value = newString;
    const y = parseFloat(newString);
    if (!REGEXP.test(newString) || isNaN(y) || y <= -5 || y >= 3) {
        alert(
            'Неверно указан параметр ‘y’.\n'+
            'Пожалуйста, введите число в интервале (-5 ... 3).'
        );
        return false;
    }
    return true;
}