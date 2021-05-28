package com.dxctraining;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/forwardtojstl")
public class ForwardToJstlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Student studentObj=topStudent();
        request.setAttribute("student",studentObj);

        List<Student>listObj=allStudents();
        request.setAttribute("list",listObj);

        RequestDispatcher dispatcher=request.getRequestDispatcher("jstldemo.jsp");
        dispatcher.forward(request,response);



    }

    public List<Student>allStudents(){
        List<Student>list=new ArrayList<>();
        Student student1=new Student("r1","anuj",21);
        Student student2=new Student("r2","ayushi",22);
        Student student3=new Student("r3","khadar",23);
        Student student4=new Student("r4","fazil",24);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        return list;
    }

    public Student topStudent(){
        Student studentObj=new Student("r1","anuj",21);
         return studentObj;
    }
}
