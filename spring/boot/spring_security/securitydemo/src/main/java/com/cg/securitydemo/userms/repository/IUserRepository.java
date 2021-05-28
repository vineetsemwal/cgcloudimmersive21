package com.cg.securitydemo.userms.repository;

import com.cg.securitydemo.userms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {

    User findUserByUsername(String username);
}
