package com.cg.empmswithdb.exceptions;

public class InvalidEmployeeNameException extends RuntimeException{

    public InvalidEmployeeNameException(String msg){
        super(msg);
    }

}
