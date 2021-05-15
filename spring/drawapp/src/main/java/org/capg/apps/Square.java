package org.capg.apps;

public class Square {

    private int side;

    public Square(){
    }

    public  Square(int side){
        this.side = side;
    }

    public int area(){
        return side*side;
    }

}
