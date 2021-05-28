package com.cg.securitydemo.userms.repository;

import com.cg.securitydemo.userms.entities.Customer;
import com.cg.securitydemo.userms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByUser(User user);
}
