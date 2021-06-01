package com.cg.basics.enums;

public class OrderByEnumExample {

    public static void main(String[] args){
        OrderByEnumExample example=new OrderByEnumExample();
        OrderBy order=OrderBy.desc;
        example.orderElements(order);
    }

    void orderElements(OrderBy order){
        if(order.equals(OrderBy.asc)){
            System.out.println("do work in ascending");
        }else{
            System.out.println("do work in descending");
        }

    }

}

enum OrderBy {
    asc,
    desc

}
