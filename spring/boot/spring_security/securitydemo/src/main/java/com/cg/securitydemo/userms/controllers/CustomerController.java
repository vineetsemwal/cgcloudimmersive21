package com.cg.securitydemo.userms.controllers;

import com.cg.securitydemo.userms.dto.CreateCustomerRequest;
import com.cg.securitydemo.userms.dto.CustomerDetails;
import com.cg.securitydemo.userms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/p/customers/add")
    public CustomerDetails createCustomer(@RequestBody CreateCustomerRequest requestData){
       CustomerDetails desired= customerService.add(requestData);
       return desired;
    }



}
