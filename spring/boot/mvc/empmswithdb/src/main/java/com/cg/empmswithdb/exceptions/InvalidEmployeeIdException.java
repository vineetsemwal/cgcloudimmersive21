package com.cg.empmswithdb.exceptions;

public class InvalidEmployeeIdException extends RuntimeException{

    public InvalidEmployeeIdException(String msg){
        super(msg);
    }
}
