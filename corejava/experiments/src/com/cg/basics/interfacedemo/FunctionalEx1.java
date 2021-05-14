package com.cg.basics.interfacedemo;

import com.cg.basics.java8deatures.IMultiply;

public class FunctionalEx1 {

    public static void main(String[] args){
        IMultiply multiply=new IMultiply(){

            @Override
            public int mul(int num1, int num2) {
                return num1+ num2;
            }
        };

       int result= multiply.mul(4,5);
       System.out.println("result="+result);
    }


}
