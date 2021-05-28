package com.cg.projectms.controllers;

import com.cg.projectms.dto.CreateProjectRequest;
import com.cg.projectms.dto.ProjectDetails;
import com.cg.projectms.dto.UpdateProjectNameRequest;
import com.cg.projectms.entities.Project;
import com.cg.projectms.service.IProjectService;
import com.cg.projectms.util.ProjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/projects")
@RestController
public class ProjectController {


    @Autowired
    private IProjectService service;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public ProjectDetails add(@RequestBody CreateProjectRequest request){
       ProjectDetails response=service.add(request);
       return response;
    }

  /*
    @PostMapping("/add")
    public ResponseEntity<ProjectDetails> add(@RequestBody CreateProjectRequest request){
        ProjectDetails response=service.add(request);
        ResponseEntity<ProjectDetails>responseEntity=new ResponseEntity<>(response, HttpStatus.CREATED);
        return responseEntity;
    }
*/

    @PutMapping("/update/name")
    public ProjectDetails updateName(@RequestBody UpdateProjectNameRequest request){
       ProjectDetails response= service.updateProjectName(request);
       return response;
    }

    /*
    @PutMapping("/update/name")
    public ResponseEntity<ProjectDetails> updateName(@RequestBody UpdateProjectNameRequest request){
        ProjectDetails response= service.updateProjectName(request);
        ResponseEntity<ProjectDetails>responseEntity=new  ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;
    }
*/

    @GetMapping("/byid/{id}")
    public ProjectDetails getProject(@PathVariable("id") long id){
       ProjectDetails response =service.findProjectDetailsById(id);
       return response;
    }

    @GetMapping("/best")
    public ProjectDetails bestProject(){
       ProjectDetails response =service.findBestProject();
      return response;
    }




}
