package com.cg.basics.practice;

import java.util.*;

public class Solution3 {

    public static void main(String[] args){
        Solution3 solution=new Solution3();
        List<Integer>list1=Arrays.asList(1,2,3,4);
        List<Integer>list2=Arrays.asList(1,2,3,5);
        List<Integer>result1= solution.missing(list1,list2);
        List<Integer>result2=solution.missing(list2,list1);
        List<Integer>missing=new ArrayList();
        missing.addAll(result1);
        missing.addAll(result2);
        System.out.println(missing);
    }

    public List<Integer>missing(List<Integer>list1, List<Integer> list2){
        List<Integer>desired=new ArrayList<>();
        for(Integer element:list1){
            boolean exists=list2.contains(element);
            if(!exists){
                desired.add(element);
            }
        }
        return desired;

    }
}
