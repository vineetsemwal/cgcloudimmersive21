package com.cg.basics.exceptionex;

public class InvalidRestaurantIdException extends InvalidRestaurantException {
    public InvalidRestaurantIdException(String msg) {
        super(msg);
    }
}
