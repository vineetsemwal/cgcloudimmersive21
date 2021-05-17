package com.cg.empmswithdb;

import com.cg.empmswithdb.ui.AppFrontEnd;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {


    public static void main(String args[]){
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        AppFrontEnd frontEnd =context.getBean(AppFrontEnd.class);
        frontEnd.start();
    }



}
