package com.cg.basics.java8deatures;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerEx {

    public static void main(String args[]){
        IPrint printer1=(msg)->System.out.println("message1 is "+msg);
        printer1.print("welcome to training");

        Consumer<String> printer2=(msg)->System.out.println("message 2 is "+msg);
        printer2.accept("welcome to cg");

        IAddFun addFun1=(num1,num2)->{
            int result=num1+num2;
            System.out.println("add 1 result="+result);
        };
        addFun1.add(5,6);

        BiConsumer<String, Integer> addFun2=(msg,times)->{
          String result="";
            for(int i=0;i<times;i++){
              result=result+msg;
          }
            System.out.println("concatenated as many times="+result);
        };
        addFun2.accept("hello",3);
    }
}
