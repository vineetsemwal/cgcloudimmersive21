package org.capg.apps.drawappwithannotations;

import org.capg.apps.drawappwithannotations.beans.Canvas;
import org.capg.apps.drawappwithannotations.beans.Square;
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
       Square square=context.getBean(Square.class);
       System.out.println("square="+square.area() +" side="+square.getSide());

       //Canvas canvas=context.getBean(Canvas.class);
       Canvas canvas1 =context.getBean("canvas",Canvas.class);
       canvas1.drawArea();

       Canvas canvas2=context.getBean(Canvas.class);
       boolean same= canvas1== canvas2;
       System.out.print("canvas objects same="+same);

    }
}
