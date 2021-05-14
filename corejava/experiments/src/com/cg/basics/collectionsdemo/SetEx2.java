package com.cg.basics.collectionsdemo;

import java.util.*;
public class SetEx2 {

    public static void main(String[] args){
        Customer customer1=new Customer("chaitu",21);
        Customer customer2=new Customer("priti",23);
        Customer customer3=new Customer("raju",22);
        Customer customer4=new Customer("chaitu",24);
        Comparator<Customer>comparator=new AgeComparator();
        Set<Customer>set=new TreeSet<>(comparator);
        set.add(customer1);
        set.add(customer2);
        set.add(customer3);
        set.add(customer4);
        int size=set.size();
        System.out.println("size="+size);
        for(Customer customer:set){
            System.out.println(customer.getName()+"-"+customer.getAge());
        }
    }
}
