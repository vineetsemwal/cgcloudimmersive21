package com.cg.jpademo2.entities;

import javax.persistence.*;
import java.util.Objects;

@Table(name="students")
@Entity
public class Student {

    @GeneratedValue
    @Id
    private Integer id;
    @Column(name="studname",nullable=false)
    private String name;
    private Integer age;

    public Student(){

    }

    public Student( String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
