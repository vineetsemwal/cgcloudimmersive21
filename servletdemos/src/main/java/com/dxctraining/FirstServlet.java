package com.dxctraining;

import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;


@WebServlet("/first")//mapping path to servlet class
public class FirstServlet extends HttpServlet {

    // life cycle methods init , service, destroy

    /**
     * every time request is received , doGet method will get called by servlet container to generate response
     *
     *
     *   Servlet Container will call service method  because it is holding object of our servlet classs
     *    it must be doing servletobj.service(req, response);
     *
     *  @param request : request object  for fetching request data
     *   @param response : response object for writing response for the client
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer= response.getWriter();
        String startHtml="<!DOCTYPE html>";
        writer.println(startHtml);// writing to output stream
        writer.println("<html><body>");
        writer.println("Hello World");
        String endHtml="</body> </html>";
        writer.println(endHtml);
    }



}







