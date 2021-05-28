package com.dxctraining;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/postform")
public class PostFormServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
        writer.println("<h1> Welcome user </h1>");
        writer.println("username is "+ usernameVal+" password is "+passwordVal);
        writer.println("<div>");
        writer.println("Language You are using is "+languageVal);
        writer.println("</div>");
        writer.println("<a href='html1.html'>Go back to form </a>");
        String endHtml="</body> </html>";
        writer.println(endHtml);



    }

}
