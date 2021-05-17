package org.capg.apps.drawapp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * scope types are singleton, prototype, request, session ,global session
 * a part from singleton , prototype , others are used for web programming
 * @Scope("scopename") foreg @Scope("prototype")
 *
 */
@Component
public class Canvas {

    @Qualifier("square")
    @Autowired
    private IShape shape;


    public Canvas(){

    }

    public Canvas(IShape shape){
        this.shape = shape;
    }


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

    @PostConstruct
    public void afterInit(){
        System.out.println("inside canvas afterinit, shape= "+shape.area() );
    }

}
