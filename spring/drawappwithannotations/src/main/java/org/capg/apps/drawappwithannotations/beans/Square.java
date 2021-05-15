package org.capg.apps.drawappwithannotations.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    @Override
    public double area(){
        return side*side;
    }

}
