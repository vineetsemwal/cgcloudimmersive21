package com.cg.projectms.exceptions;

public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException(String msg){
        super(msg);
    }
}
