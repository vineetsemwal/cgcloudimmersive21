package com.dxctraining;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forwarded")
public class RequestForwardServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usernameVal= request.getParameter("username");
        String passwordVal=request.getParameter("password");
        String languageVal=request.getParameter("language");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out= response.getWriter();
        String startHtml="<!DOCTYPE html>";
        out.println(startHtml);// writing to output stream
        out.println("<html><body>");
        out.println("<h1>Inside  Request forward servlet2</h1>");
        out.println("username is "+ usernameVal+" password is "+passwordVal);
        out.println("<div>");
        out.println("Language You are using is "+languageVal);
        out.println("</div>");
        String endHtml="</body> </html>";
        out.println(endHtml);

    }
}
