package com.dxctraining;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/init",
        initParams =  @WebInitParam(name = "start" ,value = "100")

)
public class ServletInitExample extends HttpServlet {

    private int counter;// servletscoped , available in al the requests to this servlet

    @Override
    public void init() throws ServletException {
        ServletConfig  config=getServletConfig();
       String value= config.getInitParameter("start");
       counter=Integer.parseInt(value);
       System.out.println("count="+counter);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        counter++;
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer= response.getWriter();
        String startHtml="<!DOCTYPE html>";
        writer.println(startHtml);// writing to output stream
        writer.println("<html><body>");
        writer.println("counter="+counter);
        String endHtml="</body> </html>";
        writer.println(endHtml);
    }

}
