package org.capg.apps.drawapp;

import org.capg.apps.drawapp.beans.Canvas;
import org.capg.apps.drawapp.beans.Circle;
import org.capg.apps.drawapp.beans.IShape;
import org.capg.apps.drawapp.beans.Square;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        App app=new App();
        app.start();
    }

    public void start(){
       AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
       context.registerShutdownHook();
       
       Square square=context.getBean(Square.class);
       System.out.println("square="+square.area() +" side="+square.getSide());

        Circle circle=context.getBean(Circle.class);

       //Canvas canvas=context.getBean(Canvas.class);
       Canvas canvas1 =context.getBean("canvas",Canvas.class);
       canvas1.drawArea();

       Canvas canvas2=context.getBean(Canvas.class);
       boolean same= canvas1== canvas2;
       System.out.println("canvas objects same="+same);
       

    }
}
