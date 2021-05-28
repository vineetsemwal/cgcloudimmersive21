package com.cg.projectms.dao;

import com.cg.projectms.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProjectRepository extends JpaRepository<Project,Long> {

    Project findFirstByOrderByCostDesc();


}
