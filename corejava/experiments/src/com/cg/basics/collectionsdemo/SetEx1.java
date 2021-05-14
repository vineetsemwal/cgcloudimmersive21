package com.cg.basics.collectionsdemo;

import java.util.*;

public class SetEx1 {

    /*
      add(element)
      remove(element)
      contains(element)
      size()
      iterator()
     */
    public static void main(String args[]){
        Set<String>set=new HashSet<>();
        String element1="one";
        String element2="zero";
        String element3="two";
        set.add(element1);
        set.add(element2);
        set.add(element3);
        set.add(element2);

        int size=set.size();
        System.out.println("size="+size);

        for(String element:set){
            System.out.println(element);
        }
    }
}
