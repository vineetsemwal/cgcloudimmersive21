package com.cg.securitydemo.userms.service;

import com.cg.securitydemo.userms.entities.User;

import java.util.Set;

public interface IUserService {

    User add(String username, String password, Set<String> roles);

    User findById(Long id);

    User findByUsername(String username);




}
