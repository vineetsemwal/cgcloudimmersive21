package com.cg.projectms.service;

import com.cg.projectms.dto.CreateProjectRequest;
import com.cg.projectms.dto.ProjectDetails;
import com.cg.projectms.dto.UpdateProjectNameRequest;
import com.cg.projectms.entities.Project;

public interface IProjectService {

    ProjectDetails add(CreateProjectRequest request);

    ProjectDetails updateProjectName(UpdateProjectNameRequest request);

    Project findProjectById(Long id);

    ProjectDetails findProjectDetailsById(Long id);

    ProjectDetails findBestProject();
}
