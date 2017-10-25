<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Лабораторная работа №1</title>
  <script type="text/javascript" src="checkBoundaries.js"></script>
  <script type="text/javascript" src="js/form.js"></script>
  <script type="text/javascript" src="js/draw.js"></script>
  <script type="text/javascript" src="js/drawIndex.js"></script>
  <script type="text/javascript" src="js/send.js"></script>
  <link rel="SHORTCUT ICON" href="/shovel.png" type="image/png">
  <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<table class="table1" cellpadding="0" cellspacing="0">
  <tbody>
  <tr class="header" align="center">
    <td colspan=2 class="td">
      Выполнили студенты группы P3201 Третьяков Константин и&nbsp;Закусило Виталий.
      <br>
      Вариант №&nbsp;211.
    </td>
  </tr>
  <tr class=table2>
    <td class = "sidebar" colspan = "5">
      <%@include file="area.html" %>

    </td>
    <td class="manipulation" width="60%" align="center" valign="top">
      <form method="GET" name="parameters" onsubmit="return validateForm(this)" action="controller">
        <div class="element">
          <label id="r-group">
            R =
            <button class="r-button" name="r-butt" type="button" value="1.0" >1</button>
            <button class="r-button" name="r-butt" type="button" value="1.5">1.5</button>
            <button class="r-button" name="r-butt" type="button" value="2.0">2</button>
            <button class="r-button" name="r-butt" type="button" value="2.5">2.5</button>
            <button class="r-button" name="r-butt" type="button" value="3.0">3</button>
            <input id="rr" type="input" name="r" hidden="true" value="0.0"/>

          </label>
        </div>
        <div class="element">
          <label>
            X =
            <select name="x">
              <option name="xs" value="-5">-5</option>
              <option name="xs" value="-4">-4</option>
              <option name="xs" value="-3">-3</option>
              <option name="xs" value="-2">-2</option>
              <option name="xs" value="-1">-1</option>
              <option name="xs" value="0">0</option>
              <option name="xs" value="1">1</option>
              <option name="xs" value="2">2</option>
              <option name="xs" value="3">3</option>
            </select>
          </label>
        </div>
        <div id="y-group" class="element">
          <label for="y">
            Y =
          </label>
          <input type="text" name="y" id="y" placeholder="-5 … 3">
        </div>
        <input id="submit" type="submit" class="submit" value="Проверить">
      </form>
    </td>

  </tr>

  <tr class="footer" align="center" >
    <td colspan=2 class="td">
      ©Третьяков Константин, Закусило Виталий
      <br>
    </td>
  </tr>

  </tbody>
</table>

</body>
</html>