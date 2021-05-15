package org.capg.apps;

public class Canvas {

    private IShape shape;

    public Canvas(IShape shape){
        this.shape = shape;
    }

    public void setShape(IShape shape){
        this.shape = shape;
    }

    public void drawArea(){
        double area=shape.area();
        System.out.println("drawing area, area="+area);
    }

}
