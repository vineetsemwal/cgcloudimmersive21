package com.cg.basics.collectionsdemo;

import java.util.ArrayList;
import java.util.List;

public class ListEx3 {


    public List<Citizen> findByName(List<Citizen>list, String nameArg, int pincodeArg){
        List<Citizen>desired=new ArrayList<>();
         for (Citizen iterated:list){
             if(iterated.getName().equals(nameArg) && iterated.getPincode()==pincodeArg){
                 desired.add(iterated);
             }
         }

         if(desired.isEmpty()){
             return null;
         }

         return desired;

    }



}

class Citizen{

   private String name;
   private int pincode;
   private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}