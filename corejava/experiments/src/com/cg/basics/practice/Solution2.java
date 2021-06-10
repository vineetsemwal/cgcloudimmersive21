package com.cg.basics.practice;

import java.util.*;

public class Solution2 {

    public List<String> convert(Map<String,String>map, String searchFor){
        Set<String>keys=map.keySet();
        List<String>desired=new ArrayList<>();
        for(String key:keys){
           String value= map.get(key);
           if(value.equals(searchFor)){
               desired.add(key);
           }
        }
        return desired;
    }
}
