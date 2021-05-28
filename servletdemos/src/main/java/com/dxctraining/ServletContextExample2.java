package com.dxctraining;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/appcounter2")
public class ServletContextExample2 extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer=response.getWriter();
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
