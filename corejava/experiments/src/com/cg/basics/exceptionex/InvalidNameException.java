package com.cg.basics.exceptionex;

public class InvalidNameException extends RuntimeException{

    public InvalidNameException(){
    }

    public InvalidNameException(String msg){
        super(msg);
    }

}
