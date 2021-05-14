package com.cg.basics.collectionsdemo;

import java.util.*;

public class MapEx1 {

    public static void main(String[] args){
        Map<Integer,Customer>map=new HashMap<>();
        Customer customer1=new Customer("priti",21);
        Customer customer2=new Customer("prajakta",22);
        Customer customer3=new Customer("maniratnam",23);
        Customer customer4=new Customer("raju",23);

        map.put(10,customer1);
        map.put(2,customer2);
        map.put(3,customer3);
        map.put(2,customer4);
        Customer fetched=map.get(2);
        System.out.println("customer with key 2 "+fetched.getName()+"-"+fetched.getAge());
        int size=map.size();
        System.out.println("size="+size);
        System.out.println("iterating on keys and fetching values");
        Set<Integer>keys=map.keySet();
       for (Integer key:keys){
          Customer customer= map.get(key);
           System.out.println(customer.getName()+"-"+customer.getAge());
       }

       Collection<Customer>customers= map.values();
    }

}
