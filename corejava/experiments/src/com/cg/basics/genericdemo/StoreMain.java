package com.cg.basics.genericdemo;

public class StoreMain {

    public static void main(String[]  args){
        Store<String> store = new Store<>();
        store.setElement("hello");
        String element= store.getElement();

    }
}
