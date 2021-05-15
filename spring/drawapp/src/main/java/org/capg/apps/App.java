package org.capg.apps;

public class App 
{
    public static void main( String[] args )
    {
        App app=new App();
        app.start();
    }

    public void start(){
        Canvas canvas=new Canvas();
        canvas.drawArea();
    }
}
