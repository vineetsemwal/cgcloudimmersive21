package com.cg.basics.practice;

import java.awt.*;

public class Solution5 {

    public static void main(String args[]){
        Solution5 solution=new Solution5();
        boolean result1=solution.check("hello*oee");
      //  boolean result2=solution.check("hello*hello");
        System.out.println("result1="+result1);
    }

    /**
     *
     * @param input   "hello*world"
     * @return
     */
    public boolean check(String input){
       boolean contains=input.contains("*");
       if(!contains){
           return false;
       }
       int index= input.indexOf("*");
       char before=input.charAt(index-1);
       char after=input.charAt(index+1);
       System.out.println(before+" "+after);
       boolean equals=before==after;
       return equals;

    }

}
