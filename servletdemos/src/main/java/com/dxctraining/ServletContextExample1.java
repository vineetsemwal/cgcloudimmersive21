package com.dxctraining;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/appcounter1")
public class ServletContextExample1 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer=response.getWriter();
        //servletcontext is application scope
        // data in servletcontext is available in all the servlets and in all the requests to different servlets
        //
        ServletContext context=request.getServletContext();
        int appcounter=0;
        Object counterObj=context.getAttribute("appcounter");
        if(counterObj!=null){
            appcounter=(Integer)counterObj;
        }
        appcounter++;
        context.setAttribute("appcounter",appcounter);
        writer.println("app counter is "+appcounter);
    }
}
