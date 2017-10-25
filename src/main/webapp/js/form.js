let form;
let xButtons;

window.addEventListener("load", function () {
    form = document.forms['parameters'];
    xButtons = Array.from(document.getElementsByClassName('x-button'));
    selectXButton(getX());
    for (let button of xButtons) {
        button.onclick = function () {
            setX(button.value);
        };
    }
});

function validateForm(form) {
    const REGEXP = /^[+-]?\d+(\.\d+)?$/;
    const yString = form.y.value;
    const y = parseFloat(yString);
    if (!REGEXP.test(yString) || isNaN(y) || y <= -5 || y >= +5) {
        alert(
            'Неверно указан параметр ‘y’.\n' +
            'Пожалуйста, введите число в интервале (-5, +5).'
        );
        return false;
    }
    return true;
}

function getX() {
    return parseInt(form.x.value);
}

function setX(newValue) {
    form.x.value = newValue;
    selectXButton(newValue);
}

function selectXButton(value) {
    let intValue = parseInt(value);
    for (let button of xButtons) {
        if (parseInt(button.value) === intValue) {
            button.classList.add('active');
        } else {
            button.classList.remove('active');
        }
    }
}