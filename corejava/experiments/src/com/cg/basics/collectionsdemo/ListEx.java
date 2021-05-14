package com.cg.basics.collectionsdemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListEx {

    public static void main(String args[]){
        List<String> list=new LinkedList<>();
        list.add("three");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        String result=list.get(0);
        boolean contains=list.contains("two");
        int size=list.size();
        System.out.println("contains two="+contains +" size="+size);
        int index=list.indexOf("three");
        System.out.println("first index of three ="+index);
        int lastIndexOfElement=list.lastIndexOf("three");
        System.out.println("last index of three="+lastIndexOfElement);
        list.set(2,"second");

        for (String element : list){
            System.out.println(element);
        }


    }
}
