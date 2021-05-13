package com.cg.empmswithoutdb.exceptions;

public class InvalidEmployeeNameException extends RuntimeException{

    public InvalidEmployeeNameException(String msg){
        super(msg);
    }

}
