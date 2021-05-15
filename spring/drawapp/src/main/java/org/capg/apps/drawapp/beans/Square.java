package org.capg.apps.drawapp.beans;

import org.springframework.stereotype.Component;


public class Square implements IShape{

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
