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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RequestMapping("/employees")
@RestController
public class EmployeeRestController {
    private static final Logger Log= LoggerFactory.getLogger(EmployeeRestController.class);

    @Autowired
    private EmployeeUtil employeeUtil;

    @Autowired
    private IEmployeeService service;

    /**
     * effective uri  /employees/add
     **/
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public EmployeeDetails addEmployee(@RequestBody @Valid CreateEmployeeRequest requestData) {
        System.out.println("***inside addEmployee() name=" + requestData.getName() + " salary=" + requestData.getSalary());
        Employee created = service.add(requestData.getName(), requestData.getSalary());
        Log.info("inside add created="+created);
        Log.info("inside add created="+created.getId()+"-"+created.getName());
        EmployeeDetails response = employeeUtil.toDetails(created);
        return response;
    }

    /**
     * effective uri  /employees/byid/1
     */
    @GetMapping("/byid/{id}")
    public EmployeeDetails getEmployee(@Min(1) @PathVariable("id") int id) {
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
    public EmployeeDetails update(@RequestBody @Valid UpdateSalaryRequest requestData) {
        Employee employee = service.changeSalary(requestData.getId(), requestData.getSalary());
        EmployeeDetails response = employeeUtil.toDetails(employee);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@Min(1) @PathVariable("id") int empId) {

        service.deleteById(empId);

        return "employee deleted";

    }

}
