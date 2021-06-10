package com.cg.basics.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution4 {

    public static void main(String[] args){
       // List<String>list= Stream.of("apple", "orange", "grapes").collect(Collectors.toList());
        List<String>list1=new ArrayList<>();
        list1.add("apple");
        list1.add("orange");
        list1.add("grapes");
        List<String>list2=new ArrayList<>();
        list2.add("melon");
        list2.add("apple");
        list2.add("mango");
        Solution4 solution=new Solution4();
        solution.removeStartWithAOrG(list1);
        solution.removeEndWithNOrE(list2);
        List<String>remaining=new ArrayList<>();
        remaining.addAll(list1);
        remaining.addAll(list2);
        System.out.println(remaining);

    }

    public void removeEndWithNOrE(List<String>list2){
        List<String>removed=new ArrayList<>();
        for (String iterated:list2){
            boolean foundN=iterated.endsWith("n");
            if(foundN){
                removed.add(iterated);
            }
            boolean foundE=iterated.endsWith("e");
            if(foundE){
                removed.add(iterated);
            }
        }
        list2.removeAll(removed);
    }

    public  void removeStartWithAOrG(List<String> list1){
        List<String>removed=new ArrayList<>();
        for (String iterated:list1){
            boolean foundA=iterated.startsWith("a");
            if(foundA){
                removed.add(iterated);
            }
            boolean foundG=iterated.startsWith("g");
            if(foundG){
                removed.add(iterated);
            }

        }

        list1.removeAll(removed);
    }
}
