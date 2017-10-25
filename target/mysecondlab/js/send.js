function sendValues(x, y, r) {
    let form = document.createElement('form');
    form.method = "GET";
    form.action = "controller";

    let inputX = document.createElement('input');
    inputX.name = "x";
    inputX.hidden = "true";
    inputX.value = x;
    form.appendChild(inputX);

    let inputY = document.createElement('input');
    inputY.name = "y";
    inputY.hidden = "true";
    inputY.value = y;
    form.appendChild(inputY);

    let inputR = document.createElement('input');
    inputR.name = "r";
    inputR.hidden = "true";
    inputR.value = r;
    if (inputR.value === "0.0"){
        alert("Значение R не установлено")
        return;
    }
    form.appendChild(inputR);

    document.body.appendChild(form);
    form.submit();
}