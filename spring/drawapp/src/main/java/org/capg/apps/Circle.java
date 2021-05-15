package org.capg.apps;

public class Circle implements IShape{

    private int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14*radius*radius;
    }
}
