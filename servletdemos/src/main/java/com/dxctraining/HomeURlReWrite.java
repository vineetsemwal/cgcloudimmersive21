package com.dxctraining;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/home")
public class HomeURlReWrite extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usernameVal= request.getParameter("username");
        String passwordVal=request.getParameter("password");
        String languageVal=request.getParameter("language");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer= response.getWriter();
        String startHtml="<!DOCTYPE html>";
        writer.println(startHtml);// writing to output stream
        writer.println("<html><body>");
        writer.println("<h1> Welcome to home </h1>");
        writer.println("username is "+ usernameVal+" password is "+passwordVal);
        writer.println("<div>");
        writer.println("Language You are using is "+languageVal);
        writer.println("</div>");
        String url=String.format("<a href='profile?username=%s&password=%s&language=%s'>Visit Profile </a>",usernameVal,passwordVal,languageVal);
        writer.println(url);
        System.out.println("url created="+url);
        String endHtml="</body> </html>";
        writer.println(endHtml);
    }
}
