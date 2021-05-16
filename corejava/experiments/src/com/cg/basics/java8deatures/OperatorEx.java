package com.cg.basics.java8deatures;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorEx {

    public static void main(String[] args){
        IDouble operator1=(num)->num*2;
        int result1=operator1.doubleValue(5);
        System.out.println("operator1 result="+result1);
        UnaryOperator<Integer> operator2=(num)->num*2;
        int result2=operator2.apply(5);
        System.out.println("operator2 result="+result2);


        IMultiply binaryOperator1=(num1,num2)->num1*num2;
        int result3=binaryOperator1.mul(5,7);
        System.out.println("binary operator result="+result3);

        BinaryOperator<Integer> binaryOperator2=(num1, num2)->num1*num2;
        int result4=binaryOperator2.apply(8,10);
        System.out.println("binary operator result="+result4);


    }
}
