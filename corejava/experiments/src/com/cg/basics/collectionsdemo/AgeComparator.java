package com.cg.basics.collectionsdemo;

import java.util.Comparator;

public class AgeComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        //customer 1 age > customer 2 age ,return +ve
        //customer 2 age <customer 1 age, return -ve
        // both equal ,. return 0
        int compared= customer2.getAge()- customer1.getAge();
        return compared;
    }
}
