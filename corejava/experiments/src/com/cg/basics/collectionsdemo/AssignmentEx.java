package com.cg.basics.collectionsdemo;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AssignmentEx {


}

class Citizenship{

    private Map<Integer, Person>map=new HashMap<>();


    void addPerson(Person person){
        int age=person.getAge();
        if(age>=0 && age<=10){
         person.setCategory("child");
        }
        if(age>=11 && age<=18){
            person.setCategory("adolescent");
        }


        map.put(person.getId(), person);

    }

    ArrayList<Person> showPersonDetailsByCategory(String category){
       ArrayList<Person>desired=new ArrayList<>();
        Set<Integer> ids= map.keySet();
       for (int id: ids){
         Person person= map.get(id);
         if(category.equals(person.getCategory())){
             desired.add(person);
         }
       }
       return desired;
    }

    /**

      stream1 --op1=>stream 2 --op2-->stream3 --terminate=>

       predicate , boolean isEven(int num)

     */
    int countPersonAbove35(List<Person> list){
       /*
        Stream<Person> stream1= list.stream();
       Predicate<Person> predicate=(person)->person.getAge()>35;
       Stream<Person>stream2=stream1.filter(predicate);
       long count=stream2.count();
       */
       long count=list.stream()
               .filter(person->person.getAge()>35)
               .count();
       return (int)count;
    }

    List<Person>sortedByAge(List<Person>list){
     List<Person>sorted=   list.stream()
                .sorted((person1, person2)->person2.getAge()-person1.getAge())
         .collect(Collectors.toList())    ;
     return sorted;
    }

    /*
    methods with lambda stream
int countPersonAbove35(List) {
  using stream, filter for above 35 age and return count

sortPersonOnAgeAsc(list) {
   use stream for sorting by age

sortPersonOnAgeDesc(list) {
     */


}

class Person {
    private int id, age;
    private String name,  category;
    public Person(){

    }

    public Person(int id, String name, int age, String category){
        this.id = id;
        this.name = name;
        this.age=age;
        this.category=category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

