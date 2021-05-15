package org.capg.apps;

public class App 
{
    public static void main( String[] args )
    {
        App app=new App();
        app.start();
    }

    public void start(){
        Circle circle=new Circle(10);
        Canvas canvas=new Canvas(circle);
        canvas.drawArea();
    }
}
