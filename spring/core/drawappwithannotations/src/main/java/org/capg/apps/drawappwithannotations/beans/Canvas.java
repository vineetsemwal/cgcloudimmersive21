package org.capg.apps.drawappwithannotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * scope types are singleton, prototype, request, session ,global session
 * a part from singleton , prototype , others are used for web programming
 * @Scope("scopename") foreg @Scope("prototype")
 *
 */
@Component
public class Canvas {

    private IShape shape;

    public Canvas(){

    }
    public Canvas(IShape shape){
        this.shape = shape;
    }


   @Qualifier("square")
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
