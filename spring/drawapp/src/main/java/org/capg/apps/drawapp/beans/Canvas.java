package org.capg.apps.drawapp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Canvas {

    private IShape shape;

    public Canvas(){

    }
    public Canvas(IShape shape){
        this.shape = shape;
    }


   @Qualifier("sq")
   @Autowired
    public void setShape(IShape shape){
        this.shape = shape;
    }

    public IShape getShape(){
        return shape;
    }

    public void drawArea(){
        double area=shape.area();
        System.out.println("drawing area, area="+area);
    }

}
