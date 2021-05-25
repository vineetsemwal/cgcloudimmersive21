package com.cg.empmswithdb.util;

import com.cg.empmswithdb.dto.EmployeeDetails;
import com.cg.empmswithdb.dto.ProjectDetails;
import com.cg.empmswithdb.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeUtil {

    public EmployeeDetails toDetails(Employee employee, ProjectDetails project){
        EmployeeDetails details=new EmployeeDetails();
        details.setId(employee.getId());
        details.setName(employee.getName());
        details.setSalary(employee.getSalary());
        details.setProjectId(employee.getProjectId());
        if(project!=null) {
            details.setProjectName(project.getName());
        }
        return details;
    }

    /*
    public List<EmployeeDetails> toDetailsList(Collection<Employee> employees){
     //  List<EmployeeDetails>desired =employees.stream().map(emp-> toDetails(emp))
      //  .collect(Collectors.toList());
        List<EmployeeDetails>desired=new ArrayList<>();
        for(Employee emp:employees){
           EmployeeDetails details= toDetails(emp);
           desired.add(details);
        }
       return desired;
    }

     */
}
