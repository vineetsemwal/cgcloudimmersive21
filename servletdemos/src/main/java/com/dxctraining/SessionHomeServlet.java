package com.dxctraining;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessionhome")
public class SessionHomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usernameVal= request.getParameter("username");
        String passwordVal=request.getParameter("password");
        String languageVal=request.getParameter("language");
        HttpSession session=request.getSession();
        session.setAttribute("username",usernameVal);
        session.setAttribute("password",passwordVal);
        session.setAttribute("language",languageVal);
        //in our case session should net get expired even after 1 year if user is constantly using it
        //it will only expire when user is not using for time (1 minute)
        //
        session.setMaxInactiveInterval(60);
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
        String url=String.format("<a href='sessionprofile'>Visit Profile </a>");
        writer.println(url);
        System.out.println("url created="+url);
        String endHtml="</body> </html>";
        writer.println(endHtml);
    }

}
