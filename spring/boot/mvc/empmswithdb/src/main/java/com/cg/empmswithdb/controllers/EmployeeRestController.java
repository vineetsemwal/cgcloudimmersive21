package com.cg.empmswithdb.controllers;

import com.cg.empmswithdb.dto.CreateEmployeeRequest;
import com.cg.empmswithdb.dto.EmployeeDetails;
import com.cg.empmswithdb.dto.UpdateSalaryRequest;
import com.cg.empmswithdb.entities.Employee;
import com.cg.empmswithdb.exceptions.EmployeeNotFoundException;
import com.cg.empmswithdb.exceptions.InvalidEmployeeIdException;
import com.cg.empmswithdb.exceptions.InvalidEmployeeNameException;
import com.cg.empmswithdb.exceptions.InvalidSalaryException;
import com.cg.empmswithdb.service.IEmployeeService;
import com.cg.empmswithdb.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {

    @Autowired
    private EmployeeUtil employeeUtil;

    @Autowired
    private IEmployeeService service;

    /**
     * effective uri  /employees/add
     **/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public EmployeeDetails addEmployee(@RequestBody CreateEmployeeRequest requestData) {
        System.out.println("***inside addEmployee() name=" + requestData.getName() + " salary=" + requestData.getSalary());
        Employee created = service.add(requestData.getName(), requestData.getSalary());
        EmployeeDetails response = employeeUtil.toDetails(created);
        return response;
    }

    /**
     * effective uri  /employees/byid/1
     */
    @GetMapping("/byid/{id}")
    public EmployeeDetails getEmployee(@PathVariable("id") int id) {
        Employee employee = service.findById(id);
        EmployeeDetails response = employeeUtil.toDetails(employee);
        return response;
    }


    /**
     * effective uri /employees
     *
     *  fetches and returns all employees
     *
     */
    @GetMapping
    public List<EmployeeDetails> allEmployees() {
        List<Employee> list = service.findAll();
        List<EmployeeDetails> response = employeeUtil.toDetailsList(list);
        return response;
    }


    @PutMapping("/update/salary")
    public EmployeeDetails update(@RequestBody UpdateSalaryRequest requestData) {
        Employee employee = service.changeSalary(requestData.getId(), requestData.getSalary());
        EmployeeDetails response = employeeUtil.toDetails(employee);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int empId) {

        service.deleteById(empId);

        return "employee deleted";

    }

}
