package com.cg.basics.collectionsdemo;

public class Customer implements Comparable<Customer>{
    private String name;
    private int age;

    public Customer(String name, int age){
        this.name = name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
      Customer c1=new Customer("chaitu",21);
      Customer c2=new Customer("priti",22);
       c1.compareTo(c2)
     */
    @Override
    public int compareTo(Customer that) {
        int compared = this.age-that.age;
        return compared;
    }
}
