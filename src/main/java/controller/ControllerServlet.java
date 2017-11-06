package controller;

import java.io.IOException;
import javax.servlet.http.*;

public class ControllerServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            double x = Double.parseDouble(request.getParameter("x").replaceAll(",", "."));
            double y = Double.parseDouble(request.getParameter("y"));
            double r = Double.parseDouble(request.getParameter("r"));
            System.out.println("R = " + r);
            System.out.println("X = " + x);
            System.out.println("Y = " + y);
            request.setAttribute("Sofy", true);
            request.getRequestDispatcher("check").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}