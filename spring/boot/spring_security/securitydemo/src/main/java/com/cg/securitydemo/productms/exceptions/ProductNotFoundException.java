package com.cg.securitydemo.productms.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String  msg){
        super(msg);
    }
}
