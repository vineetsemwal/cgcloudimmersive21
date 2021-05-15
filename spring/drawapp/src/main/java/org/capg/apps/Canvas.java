package org.capg.apps;

public class Canvas {

    private Square square=new Square(5);


    public void drawArea(){
        int area=square.area();
        System.out.println("drawing area, area="+area);
    }

}
