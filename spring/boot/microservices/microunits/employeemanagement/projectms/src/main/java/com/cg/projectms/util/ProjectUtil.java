package com.cg.projectms.util;

import com.cg.projectms.dto.ProjectDetails;
import com.cg.projectms.entities.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectUtil {


    public ProjectDetails toProjectDetails(Project project){
        ProjectDetails details=new ProjectDetails();
        details.setId(project.getId());
        details.setName(project.getName());
        return details;
    }

}
