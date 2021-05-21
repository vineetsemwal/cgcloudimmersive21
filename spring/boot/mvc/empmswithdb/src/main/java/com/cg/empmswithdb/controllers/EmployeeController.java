package com.cg.empmswithdb.controllers;

import com.cg.empmswithdb.entities.Employee;
import com.cg.empmswithdb.service.IEmployeeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {


    @Autowired
    private IEmployeeService service;



   @GetMapping("/fetchinfo")
    public ModelAndView fetchEmployee(@RequestParam("empid") int id){
       Employee employee= service.findById(id);
       ModelAndView response=new ModelAndView("empinfo","emp",employee);
       return response;
    }


    @GetMapping("/empdetails")
    public ModelAndView getEmployeeInformation(){
        ModelAndView response=new ModelAndView("getinfo");
        return response;
    }

    @GetMapping("/register")
    public ModelAndView registerEmployee(){
       ModelAndView response=new ModelAndView("register");
       return response;
    }

    @GetMapping("/processregister")
    public ModelAndView processRegister(@RequestParam("empname") String name, @RequestParam("empsalary") double salary){
       Employee employee=  service.add(name,salary);
        ModelAndView response=new ModelAndView("empinfo","emp",employee);
        return response;
    }

    @GetMapping("/getall")
    public ModelAndView getAllEmployees(){
       List<Employee> list=service.findAll();
       ModelAndView response=new ModelAndView("listemployees","list", list);
       return response;
    }

}
