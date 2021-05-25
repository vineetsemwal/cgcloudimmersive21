package com.cg.projectms.controllers;

import com.cg.projectms.dto.CreateProjectRequest;
import com.cg.projectms.dto.ProjectDetails;
import com.cg.projectms.dto.UpdateProjectNameRequest;
import com.cg.projectms.entities.Project;
import com.cg.projectms.service.IProjectService;
import com.cg.projectms.util.ProjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/projects")
@RestController
public class ProjectController {


    @Autowired
    private IProjectService service;


    @PostMapping("/add")
    public ProjectDetails add(@RequestBody CreateProjectRequest request){
       ProjectDetails response=service.add(request);
       return response;
    }

    @PutMapping("/update/name")
    public ProjectDetails updateName(@RequestBody UpdateProjectNameRequest request){
       ProjectDetails response= service.updateProjectName(request);
       return response;
    }


    @GetMapping("/byid/{id}")
    public ProjectDetails getProject(@PathVariable("id") long id){
       ProjectDetails response =service.findProjectDetailsById(id);
       return response;
    }



}
