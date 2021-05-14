package com.cg.basics.collectionsdemo;

import java.util.*;

public class ListEx2 {

    public static void main(String[] args){
           List<Customer>list=new ArrayList<>();
           Customer priti=new Customer("priti",21);
           Customer raju=new Customer("raju",22);
           Customer chaitu=new Customer("chaitu",23);
           list.add(priti);
           list.add(chaitu);
           list.add(raju);
          // Comparator<Customer>comparator=new AgeComparator();
          // list.sort(comparator);
            Collections.sort(list);
           for (Customer customer:list){
               System.out.println(customer.getName()+"-"+customer.getAge());
           }

    }
}
