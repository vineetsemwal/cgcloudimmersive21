package org.capg.apps;

public class Square implements IShape{

    private int side;

    public Square(){
    }

    public  Square(int side){
        this.side = side;
    }

    @Override
    public double area(){
        return side*side;
    }

}
