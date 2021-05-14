package com.cg.basics.collectionsdemo;

import java.util.*;

public class MapEx1 {

    public static void main(String[] args){
        Map<String,Customer>map=new HashMap<>();
        String name1="priti",name2="prajakta",name3="maniratnam",name4="raju";
        Customer customer1=new Customer(name1,21);
        Customer customer2=new Customer(name2,22);
        Customer customer3=new Customer(name3,23);
        Customer customer4=new Customer(name4,23);

        map.put(customer1.getName(),customer1);
        map.put(customer2.getName(),customer2);
        map.put(customer3.getName(),customer3);
        map.put(customer4.getName(),customer4);
        Customer fetched=map.get(name2);
        System.out.println("customer with key 2 "+fetched.getName()+"-"+fetched.getAge());
        int size=map.size();
        System.out.println("size="+size);
        System.out.println("iterating on keys and fetching values");
        Set<String>keys=map.keySet();
       for (String key:keys){
          Customer customer= map.get(key);
           System.out.println(customer.getName()+"-"+customer.getAge());
       }

       Collection<Customer>customers= map.values();
    }

}
