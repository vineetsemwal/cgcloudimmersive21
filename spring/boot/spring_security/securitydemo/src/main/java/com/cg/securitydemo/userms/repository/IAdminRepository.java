package com.cg.securitydemo.userms.repository;

import com.cg.securitydemo.userms.entities.Admin;
import com.cg.securitydemo.userms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin,Long> {

    Admin findAdminByUser(User user);

}
