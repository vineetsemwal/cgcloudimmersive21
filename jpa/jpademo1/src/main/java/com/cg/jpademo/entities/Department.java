package com.cg.jpademo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    private int id;

    private String deptName;

    public Department(){

    }

    public Department(int id, String name){
        this.id=id;
        this.deptName=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
