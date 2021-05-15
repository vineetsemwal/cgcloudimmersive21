package org.capg.apps.drawapp;

import org.capg.apps.drawapp.beans.Canvas;
import org.capg.apps.drawapp.beans.IShape;
import org.capg.apps.drawapp.beans.Square;
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
       ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
       Square square=context.getBean(Square.class);
       System.out.println("square="+square.area() +" side="+square.getSide());

       //Canvas canvas=context.getBean(Canvas.class);
       Canvas canvas =context.getBean("canvas",Canvas.class);
      // IShape shape=canvas.getShape();
       canvas.drawArea();

    }
}
