package com.cg.empmswithoutdb.exceptions;

public class InvalidEmployeeIdException extends RuntimeException{

    public InvalidEmployeeIdException(String msg){
        super(msg);
    }
}
