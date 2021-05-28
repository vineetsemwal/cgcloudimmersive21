package com.cg.securitydemo.userms.service;

import com.cg.securitydemo.userms.entities.Admin;
import com.cg.securitydemo.userms.entities.User;
import com.cg.securitydemo.userms.repository.IAdminRepository;
import com.cg.securitydemo.userms.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements IAdminService{

    @Autowired
    private IAdminRepository adminRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Admin add(Admin admin) {
       Admin saved=adminRepository.save(admin);
       return saved;
    }

    @Override
    public Admin findByUsername(String username) {
       User user= userRepository.findUserByUsername(username);
       Admin admin=adminRepository.findAdminByUser(user);
       return admin;
    }
}
