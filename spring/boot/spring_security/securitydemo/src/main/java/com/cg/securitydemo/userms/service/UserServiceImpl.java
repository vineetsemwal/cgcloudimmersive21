package com.cg.securitydemo.userms.service;

import com.cg.securitydemo.userms.dto.CustomUserDetails;
import com.cg.securitydemo.userms.entities.User;
import com.cg.securitydemo.userms.exceptions.UserNotFoundException;
import com.cg.securitydemo.userms.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User add(String username, String password, Set<String> roles) {
        User user =new User(username, password,roles);
        User saved=userRepository.save(user);
        return saved;
    }

    @Override
    public User findById(Long id) {
       Optional<User>optional= userRepository.findById(id);
        if(!optional.isPresent()){
           throw new UserNotFoundException("user not found for id");
        }
        return optional.get();
    }

    @Override
    public User findByUsername(String username) {
       User user= userRepository.findUserByUsername(username);
      return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= findByUsername(username);
       CustomUserDetails desired=new CustomUserDetails(user);
       return desired;
    }
}
