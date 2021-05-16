package com.cg.basics.java8deatures;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateEx {

    public static void main(String args[]){
        IEven predicate1=(num)->num%2==0;
        boolean result1= predicate1.isEven(10);
        System.out.println("predicate result="+result1);

        Predicate<Integer>predicate2=(num)->num%2==0;
        boolean result2=predicate2.test(20);
        System.out.println("predicate result="+result2);


        IAddEven biPredicate1=(num1,num2)->(num1+num2)%2==0;
        boolean result3=biPredicate1.isEven(6,7);
        System.out.println("bi predicate result="+result3);

        BiPredicate<Integer, Integer>biPredicate2=(num1,num2)->(num1+num2)%2==0;
         boolean result4=biPredicate2.test(7,5);
        System.out.println("bi predicate result="+result4);

    }
}
