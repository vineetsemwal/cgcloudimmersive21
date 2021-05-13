package com.cg.empmswithoutdb;

import com.cg.empmswithoutdb.entities.Employee;
import com.cg.empmswithoutdb.exceptions.InvalidEmployeeIdException;
import com.cg.empmswithoutdb.exceptions.InvalidEmployeeNameException;
import com.cg.empmswithoutdb.exceptions.InvalidSalaryException;
import com.cg.empmswithoutdb.service.EmployeeServiceImpl;
import com.cg.empmswithoutdb.service.IEmployeeService;

import java.awt.*;
import java.util.Collection;
import java.util.List;

public class LayeredMainUi {

    private IEmployeeService service=new EmployeeServiceImpl();

    public static void main(String args[]){
        LayeredMainUi app=new LayeredMainUi();
        app.start();
    }

    public void start(){
       try {
           System.out.println("*** add employees***");
           Employee krishna = service.add("krishna", 80000);
           Employee vidhit = service.add("vidhit", 90000);

           System.out.println("****all employees");
           List<Employee> all = service.findAll();
           displayEmployees(all);

           System.out.println("*****change salary");
           int vidhitId = vidhit.getId();
           vidhit = service.changeSalary(vidhitId, 100000);

           System.out.println("***all employees after change");
           all = service.findAll();
           displayEmployees(all);

           System.out.println("*** display employee by id");
           Employee fetched = service.findById(vidhitId);
           display(fetched);

       }catch(InvalidSalaryException e){
           System.out.println(e.getMessage());
       }
       catch(InvalidEmployeeIdException e){
           System.out.println(e.getMessage());
       }
        catch(InvalidEmployeeNameException e){
           System.out.println(e.getMessage());
        }
    }


    void display(Employee employee){
        System.out.println(employee.getId()+"-"+employee.getName()+"-"+ employee.getSalary());
    }
    void displayEmployees(Collection<Employee> employees){
        for(Employee emp:employees){
            display(emp);
        }
    }
}
