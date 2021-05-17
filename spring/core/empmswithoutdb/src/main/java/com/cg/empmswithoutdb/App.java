package com.cg.empmswithoutdb;

import com.cg.empmswithoutdb.ui.AppFrontEnd;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {


    public static void main(String args[]){
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        AppFrontEnd frontEnd =context.getBean(AppFrontEnd.class);
        frontEnd.start();
    }



}
