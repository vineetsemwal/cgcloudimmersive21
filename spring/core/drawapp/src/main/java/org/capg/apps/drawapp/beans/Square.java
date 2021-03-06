package org.capg.apps.drawapp.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Square implements IShape{

    @Value("${square.side}")
    private int side;


    public Square(){
    }

    public  Square(int side){
        this.side = side;
    }


    public int getSide(){
        return side;
    }

    public void setSide(int side){
        this.side = side;
    }

    @PostConstruct
    public void afterInitialization(){
       System.out.println("inside square after initialization, side= "+side);
    }

    @PreDestroy
    public void beforeDestroyed() {
    	System.out.println("inside before destoryed");
    }
    
    
    @Override
    public double area(){
        return side*side;
    }

}
