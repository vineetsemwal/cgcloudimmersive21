package org.capg.apps.drawapp;

import org.capg.apps.drawapp.beans.Square;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App
{
    public static void main( String[] args )
    {
        App app=new App();
        app.start();
    }

    public void start(){
     ClassPathResource resource=new ClassPathResource("beans.xml");	
      BeanFactory factory=new XmlBeanFactory(resource);
      Square square=factory.getBean(Square.class);
      System.out.println("square side="+square.getSide());
    }
}
