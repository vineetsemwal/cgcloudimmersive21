package com.cg.basics.interfacedemo;

public class CalculatorMain {

    public static void main(String args[]){
        ICalculator calcy=new CasioCalculator();
        int addResult=calcy.add(1,2);
        int subResult=calcy.sub(10,5);
        System.out.println("add result="+addResult);
        System.out.println("sub result="+subResult);

    }

}
