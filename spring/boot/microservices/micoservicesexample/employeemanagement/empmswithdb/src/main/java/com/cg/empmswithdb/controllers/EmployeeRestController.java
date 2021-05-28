package com.cg.empmswithdb.controllers;

import com.cg.empmswithdb.dto.*;
import com.cg.empmswithdb.entities.Employee;
import com.cg.empmswithdb.service.IEmployeeService;
import com.cg.empmswithdb.util.EmployeeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Api("employees" )
@Validated
@RequestMapping("/employees")
@RestController
public class EmployeeRestController {
    private static final Logger Log= LoggerFactory.getLogger(EmployeeRestController.class);

    @Autowired
    private EmployeeUtil employeeUtil;

    @Autowired
    private IEmployeeService service;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${projectms.baseUrl}")
    private String baseProjectUrl;


    private ProjectDetails cachedTopProject;

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
        ProjectDetails project = null;// at start project is not assigned
        EmployeeDetails response = employeeUtil.toDetails(created,project);
        return response;
    }

    /**
     * effective uri  /employees/byid/1
     */
    /*
    @ApiOperation(value = "get employee by id", produces="application/json")
    @ApiResponses(value={
       @ApiResponse(code=200,message="successfully fetched by id",response=EmployeeDetails.class),
       @ApiResponse(code=404,message="employee not found by id",response=String.class)

    })

     */
    @GetMapping("/byid/{id}")
    public EmployeeDetails getEmployee(@Min(1) @PathVariable("id") int id) {
        Employee employee = service.findById(id);
        Long projectId= employee.getProjectId();
        ProjectDetails project=null;
        if(projectId!=null && projectId!=0){
          project= fetchProjectDetails(projectId);
        }
        EmployeeDetails response = employeeUtil.toDetails(employee, project);
        return response;
    }


    /**
     * effective uri /employees
     *
     *  fetches and returns all employees
     *
     */
  /*
    @GetMapping
    public List<EmployeeDetails> allEmployees() {
        List<Employee> list = service.findAll();
        List<EmployeeDetails> response = employeeUtil.toDetailsList(list);
        return response;
    }
*/

    @PutMapping("/update/salary")
    public EmployeeDetails update(@RequestBody @Valid UpdateSalaryRequest requestData) {
        Employee employee = service.changeSalary(requestData.getId(), requestData.getSalary());
        Long projectId=employee.getProjectId();
        ProjectDetails project =null;
        if(projectId!=null && projectId!=0){
            project= fetchProjectDetails(projectId);
        }
        EmployeeDetails response = employeeUtil.toDetails(employee, project);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@Min(1) @PathVariable("id") int empId) {

        service.deleteById(empId);
        return "employee deleted";

    }




    @PutMapping("/project/add")
    public EmployeeDetails addToProject(@RequestBody AddToProjectRequest request){
        long projectId=request.getProjectId();
       Employee employee= service.addToProject(request.getEmpId(),projectId);
       ProjectDetails project=fetchProjectDetails(projectId);
       EmployeeDetails response=employeeUtil.toDetails(employee,project);
       return response;
    }



    @GetMapping("/bestproject")
    @HystrixCommand(fallbackMethod = "getEmployeesInTopCachedProject")
    public List<EmployeeDetails> getEmployeesInTopProject(){
        Log.info("inside getEmployeesInTopProject");
       ProjectDetails project= fetchTopProject();
       Long projectId= project.getId();
       List<Employee>employees= service.findEmployeesByProject(projectId);
       List<EmployeeDetails>response= employeeUtil.toDetailsList(employees,project);
       return response;
    }


    public List<EmployeeDetails> getEmployeesInTopCachedProject(){
        Log.info("inside getEmployeesInTopCachedProject");
        ProjectDetails project= getCachedTopProject();
        Long projectId= project.getId();
        List<Employee>employees= service.findEmployeesByProject(projectId);
        List<EmployeeDetails>response= employeeUtil.toDetailsList(employees,project);
        return response;
    }

    public ProjectDetails fetchProjectDetails(long projectId){
        String url=baseProjectUrl+"/byid/"+projectId;
        ProjectDetails project=restTemplate.getForObject(url, ProjectDetails.class);
        return project;
    }


    ProjectDetails fetchTopProject(){
        String url=baseProjectUrl+"/best";
        Log.info("inside fetchtopProject , url="+url);
        ProjectDetails project =restTemplate.getForObject(url, ProjectDetails.class);
        setCachedTopProject(project);
        return project;
    }


    public ProjectDetails getCachedTopProject(){
        return cachedTopProject;
    }

    public void setCachedTopProject(ProjectDetails topProject) {
        this.cachedTopProject = topProject;
    }
}
