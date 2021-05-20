package com.cg.bootmvcbasic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EmployeeController {

    private Map<Integer,Employee>store=new HashMap<>();

    public EmployeeController(){

    }

    @PostConstruct
    public void init(){
        Employee emp1=new Employee(1,"krishna",21);
        Employee emp2=new Employee(2,"farheen",22);
        Employee emp3=new Employee(3,"raju",23);
        store.put(emp1.getId(),emp1);
        store.put(emp2.getId(),emp2);
        store.put(emp3.getId(),emp3);
    }

    @GetMapping("/welcome")
    public ModelAndView welcome(){
        System.out.println("inside welcome method");
        ModelAndView response=new  ModelAndView("welcomepage");
        return  response;
    }


    @GetMapping("/info")
    public ModelAndView employeeDetails(@RequestParam("id")int id){
        Employee employee=store.get(id);
        ModelAndView response=new ModelAndView("employee","emp",employee);
        return response;
    }

}
