package com.cg.empmswithdb.controllers;

import com.cg.empmswithdb.entities.Employee;
import com.cg.empmswithdb.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {

    @Autowired
    private IEmployeeService service;

    /**
      effective uri  /employees/add
    **/
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
       System.out.println("***inside addEmployee() name="+employee.getName()+" salary="+employee.getSalary());
     Employee created=service.add(employee.getName(), employee.getSalary());
      return created;
    }

    /**
     *  effective uri  /employees/byid/1
     */
    @GetMapping("/byid/{id}")
    public Employee getEmployee(@PathVariable("id") int id){
         Employee employee= service.findById(id);
         return employee;
    }

    /**
     * effective uri /employees
     */
    @GetMapping
    public List<Employee>allEmployees(){
       List<Employee>list= service.findAll();
       return list;
    }

}
