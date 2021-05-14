package com.cg.basics.collectionsdemo;

import java.util.Comparator;

public class NameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        String name1=customer1.getName();
        String name2=customer2.getName();
        int compared=name1.compareTo(name2);
        return compared;
    }
}
