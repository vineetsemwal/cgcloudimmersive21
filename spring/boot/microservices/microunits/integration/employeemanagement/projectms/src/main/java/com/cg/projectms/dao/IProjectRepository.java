package com.cg.projectms.dao;

import com.cg.projectms.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project,Long> {
}
