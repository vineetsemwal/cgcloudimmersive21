package com.cg.basics.genericdemo;

public class Store <T>{
    private T  element;

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;

    }
}
