package org.capg.apps.drawapp.beans;

public class Circle implements IShape{

    private int radius;

    public Circle(){

    }
    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14*radius*radius;
    }
}
