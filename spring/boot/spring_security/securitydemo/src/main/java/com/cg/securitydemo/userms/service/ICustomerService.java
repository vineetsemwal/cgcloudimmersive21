package com.cg.securitydemo.userms.service;

import com.cg.securitydemo.userms.dto.CreateCustomerRequest;
import com.cg.securitydemo.userms.dto.CustomerDetails;
import com.cg.securitydemo.userms.entities.Customer;

public interface ICustomerService {

    Customer add(Customer customer);

    CustomerDetails add(CreateCustomerRequest requestData);

    Customer findByUsername(String username);


}
