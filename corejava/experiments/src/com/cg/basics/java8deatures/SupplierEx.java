package com.cg.basics.java8deatures;

import java.util.function.Supplier;

public class SupplierEx {

    public static void main(String[] args){
        IGreet greeting1=()->"good evening";
        String msg1=greeting1.greet();
        System.out.println("msg1="+msg1);

        Supplier<String>greeting2=()->"good night";
         String msg2=greeting2.get();
        System.out.println("msg2="+msg2);
    }
}
