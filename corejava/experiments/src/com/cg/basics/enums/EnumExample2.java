package com.cg.basics.enums;

public class EnumExample2 {

    public static  void main(String args[]){
      DayBreak foundBreak=DayBreak.fromText("lunchbreak");
      String breakName=foundBreak.name();
     System.out.println(breakName);
    }


     enum DayBreak{

        LunchBreak, TeaBreak;



        static DayBreak fromText(String textArgs){

            DayBreak breaks[]=DayBreak.values();
            for (DayBreak dayBreak:breaks){
                String text=dayBreak.name();
                if(text.equalsIgnoreCase(textArgs)){
                    return dayBreak;
                }
            }
            throw new InvalidBreakException("no daybreak  found matching your text");

        }

     }


 }

 class  InvalidBreakException extends RuntimeException{

    public InvalidBreakException(String msg){
        super(msg);
    }

 }

