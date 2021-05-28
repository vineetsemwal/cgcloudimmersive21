package com.dxctraining;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sessionex2")
public class HttpSessionExample2 extends HttpServlet {

     @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session= request.getSession();//
        int counter=0;
        Object counterObj=session.getAttribute("counter");
        if(counterObj!=null){
            counter=(Integer)counterObj;
        }
        counter++;
        session.setAttribute("counter",counter);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer= response.getWriter();
        String startHtml="<!DOCTYPE html>";
        writer.println(startHtml);// writing to output stream
        writer.println("<html><body>");
        writer.println("counter ="+counter);
        String endHtml="</body> </html>";
        writer.println(endHtml);

    }
}
