<%@ page import="model.Record" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Лабораторная работа №&nbsp;2</title>
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/draw.js"></script>
    <script type="text/javascript" src="js/drawCheck.js"></script>
    <script type="text/javascript" src="js/send.js"></script>
</head>
<body>
<table class="container">
    <tr id="fill">
        <td class="content" colspan="7">
            <table class="result">
                <thead>
                <tr>
                    <th class="number">x</th>
                    <th class="number">y</th>
                    <th class="number">r</th>
                    <th>Результат</th>
                </tr>
                </thead>
                <tbody>
                <%
                    LinkedList<Record> records = (LinkedList<Record>)request.getServletContext().getAttribute("record");
                    for (int i = 0; i < records.size(); i++) {
                        Record record = records.get(i);
                %>
                <script type="text/javascript">
                    window.addEventListener("load", function ()
                    {
                        drawPoint(canvas, <%= record.getPoint().getX() %>, <%= record.getPoint().getY() %>);
                    });
                </script>
                <tr>
                    <td class="number">
                        <%= String.format("%.2f", record.getPoint().getX())%>
                    </td>
                    <td class="number">
                        <%= String.format("%.2f", record.getPoint().getY())%>

                    </td>
                    <td class="number">
                        <%= String.format("%.2f", record.getRadius())%>
                    </td>
                    <td>
                        <%= record.getResult() %>
                    </td>
                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
            <input type="hidden" id="radius"
                   value="<%= records.get(records.size() - 1).getRadius() %>"/>
            <button id="back" class="crimson back" type="button"
                    onclick="window.location='./'">
                Назад
            </button>
        </td>
        <td class="sidebar" colspan="5">
            <%@include file="area.html" %>
        </td>
    </tr>
</table>
</body>
</html>


