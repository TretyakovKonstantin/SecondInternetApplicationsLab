package controller;

import model.Area;
import model.Point;
import model.Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "controller.AreaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isControllerPass = true;
        try {
            double x = Double.parseDouble(request.getParameter("x").replaceAll(",", "."));
            double y = Double.parseDouble(request.getParameter("y"));
            double r = Double.parseDouble(request.getParameter("r"));
            if (Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(r)) {
                throw new NumberFormatException();
            }
            if (request.getAttribute("Sofy") == null){
                isControllerPass = false;
                response.sendRedirect("index.jsp");
                return;
            }
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        String result = "";
        Double radius = null;
        Point point = new Point();
        try {
            point.setX(Double.valueOf(request.getParameter("x")));
        }
        catch (NumberFormatException e) {
            result += "Не удалось распознать параметр ‘x’.";
        }
        catch (NullPointerException e) {
            result += "Параметр ‘x’ не был указан.";
        }
        catch (IllegalArgumentException e) {
            result += e.getMessage();
        }
        try {
            point.setY(Double.valueOf(request.getParameter("y")));
        }
        catch (NumberFormatException e) {
            result += "Не удалось распознать параметр ‘y’.";
        }
        catch (NullPointerException e) {
            result += "Параметр ‘y’ не был указан.";
        }
        catch (IllegalArgumentException e) {
            result += e.getMessage();
        }
        try {
            Area area = new Area(Double.parseDouble(request.getParameter("r").replaceAll("%2C", ".")));
            radius = area.getRadius();
            if (result.isEmpty()) {
                result = area.contains(point) ?
                        "Точка входит в область." :
                        "Точка находится вне области.";
            }
        }
        catch (NumberFormatException e) {
            result += "Не удалось распознать параметр ‘r’.";
        }
        catch (NullPointerException e) {
            result += "Параметр ‘r’ не был указан.";
        }

        Record record = new Record();
        record.setPoint(point);
        record.setRadius(radius);
        record.setResult(result);
        LinkedList<Record> records = (LinkedList<Record>)getServletContext().getAttribute("record");
        if (records == null) {
            records = new LinkedList<Record>();
        }
        if (records.size() > 4) {
            records.remove(0);
        }
        records.add(record);
        getServletContext().setAttribute("record", records);
        if (isControllerPass){
            request.getRequestDispatcher("check.jsp").forward(request, response);
        }

    }
}