package com.cg.basics.java8deatures;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionEx {

    public static void main(String[] args) {

        ILength function1 = (text) -> text.length();
        int length1 = function1.length("hello");
        System.out.println("function1 result=" + length1);

        Function<String, Integer> function2 = (text) -> text.length();
        int length2 = function2.apply("good evening");
        System.out.println("function 2 result=" + length2);

        IStringConcat function3=(text,times)->{
            String result="";
            for(int i=0;i<times;i++){
                result=result+text;
            }
            return result;
        };

        String concat1=function3.concat("good",3);
        System.out.println("bifunction result="+concat1);

        BiFunction<String,Integer, String>function4=(text,times)->{
            String result="";
            for(int i=0;i<times;i++){
                result=result+text;
            }
            return result;
        };

        String concat2=function4.apply("bad",4);
        System.out.println("bifunction result="+concat2);

    }


}

