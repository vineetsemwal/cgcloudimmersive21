package com.cg.empmswithdb.ui;

import com.cg.empmswithdb.entities.Employee;
import com.cg.empmswithdb.exceptions.InvalidEmployeeIdException;
import com.cg.empmswithdb.exceptions.InvalidEmployeeNameException;
import com.cg.empmswithdb.exceptions.InvalidSalaryException;
import com.cg.empmswithdb.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class AppFrontEnd {

    @Autowired
    private IEmployeeService service;


    public void start() {
        try {
            System.out.println("*** add employees***");
            Employee krishna = service.add("krishna", 80000);
            service.add("krishna",100000);
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

            System.out.println("**** fetch and display employees with name krishna");
           List<Employee>byName= service.findEmployeesByName("krishna");
            displayEmployees(byName);

            System.out.println("**** fetch and display employees with name krishna and salary 80000");
            List<Employee>byNameAndSal= service.findEmployeesByNameAndSalary("krishna",80000);
            displayEmployees(byNameAndSal);


            System.out.println("*** display employee by id");
            Employee fetched = service.findById(vidhitId);
            display(fetched);



        } catch (InvalidSalaryException e) {
            System.out.println(e.getMessage());
        } catch (InvalidEmployeeIdException e) {
            System.out.println(e.getMessage());
        } catch (InvalidEmployeeNameException e) {
            System.out.println(e.getMessage());
        }
    }


    void display(Employee employee) {
        System.out.println(employee.getId() + "-" + employee.getName() + "-" + employee.getSalary());
    }

    void displayEmployees(Collection<Employee> employees) {
        for (Employee emp : employees) {
            display(emp);
        }
    }

}
