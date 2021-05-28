package com.dxctraining;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessionprofile")
public class SessionProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        Object usernameObj=session.getAttribute("username");
        String usernameVal=(String)usernameObj;
        Object paswordRef=session.getAttribute("password");
        String passwordVal=(String)paswordRef;
        Object languageRef=session.getAttribute("language");
        String languageVal=(String)languageRef;
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
        String endHtml="</body> </html>";
        writer.println(endHtml);
    }

}
