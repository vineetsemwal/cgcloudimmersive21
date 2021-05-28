package com.cg.securitydemo.userms.service;

import com.cg.securitydemo.userms.entities.Admin;

public interface IAdminService {
    Admin add(Admin admin);

   Admin findByUsername(String username);

}
