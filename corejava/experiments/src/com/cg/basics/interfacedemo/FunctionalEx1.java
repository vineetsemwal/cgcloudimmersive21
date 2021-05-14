package com.cg.basics.interfacedemo;

import com.cg.basics.java8deatures.IMultiply;

public class FunctionalEx1 {

    public static void main(String[] args){
        IMultiply prajakta=new IMultiply(){

            @Override
            public int mul(int num1, int num2) {
                return num1* num2;
            }
        };

      int result= prajakta.mul(4,5);
       System.out.println("anonymous result="+result);

       IMultiply lambdaExpression=(num1,num2)-> num1*num2;
       int expressionResult=lambdaExpression.mul(7,4);
      System.out.println("expression result="+expressionResult);

      IMultiply lambdaBlock=(num1,num2)->{
          System.out.println("inside lambda block");
          int mulResult=num1*num2;
          return mulResult;
      };
      int lambdaBlockResult=lambdaBlock.mul(5,10);
      System.out.println("lambda block result="+lambdaBlockResult);
    }


}
