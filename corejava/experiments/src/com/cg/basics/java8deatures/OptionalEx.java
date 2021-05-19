package com.cg.basics.java8deatures;

import java.util.Optional;

public class OptionalEx {

    public static void main(String[] args){
        OptionalEx example=new OptionalEx();
        Optional<Integer>optional=example.getValue();
        if(optional.isPresent()) {
            int value = optional.get();
            System.out.println("value ="+value);
        }else{
            System.out.println("value does not exist");
        }
    }

     Optional<Integer> getValue(){
        Optional<Integer> optional=Optional.empty();
        return optional;
    }

}
