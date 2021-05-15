package org.capg.apps.drawapp.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements IShape{

    @Value("${circle.radius}")
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
