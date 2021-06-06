package org.cg.apps.calcydemo;

public class Calculator {

    private Adder adder;

    public Calculator(Adder adder) {
        this.adder=adder;
    }

    public int add(int num1, int num2){
        System.out.println("inside calcuator add");
        int result=adder.add(num1, num2);
        return result;
    }

    public int addBy10(int num){
        System.out.println("isnide add by 10");
       int result= add(num,10);
       return result;
    }

}
