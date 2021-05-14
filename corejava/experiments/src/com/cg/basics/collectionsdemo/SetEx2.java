package com.cg.basics.collectionsdemo;

import java.util.*;
public class SetEx2 {

    public static void main(String[] args){
        Customer customer1=new Customer("chaitu",21);
        Customer customer2=new Customer("priti",21);
        Customer customer3=new Customer("raju",21);
        Customer customer4=new Customer("chaitu",21);
        Set<Customer>set=new HashSet<>();
        set.add(customer1);
        set.add(customer2);
        set.add(customer3);
        set.add(customer4);
        int size=set.size();
        System.out.println("size="+size);
    }
}
