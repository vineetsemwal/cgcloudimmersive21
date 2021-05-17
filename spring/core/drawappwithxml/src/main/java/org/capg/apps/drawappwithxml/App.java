package org.capg.apps.drawappwithxml;

import org.capg.apps.drawappwithxml.beans.Canvas;
import org.capg.apps.drawappwithxml.beans.Circle;
import org.capg.apps.drawappwithxml.beans.Square;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        App app=new App();
        app.start();
    }

    public void start(){
       ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
       Circle circle =context.getBean(Circle.class);
      System.out.println("circle area="+circle.area());

      Canvas canvas=context.getBean(Canvas.class);
      canvas.drawArea();
    }
}
