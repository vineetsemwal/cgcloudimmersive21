package org.capg.apps.drawappwithxml.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class Circle implements IShape{

    private int radius;

    public Circle(){

    }
    public Circle(int radius){
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14*radius*radius;
    }
}
