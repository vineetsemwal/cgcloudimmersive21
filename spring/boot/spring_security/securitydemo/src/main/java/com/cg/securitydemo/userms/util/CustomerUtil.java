package com.cg.securitydemo.userms.util;

import com.cg.securitydemo.userms.dto.CustomerDetails;
import com.cg.securitydemo.userms.entities.Customer;
import com.cg.securitydemo.userms.entities.User;
import org.springframework.stereotype.Component;

@Component
public class CustomerUtil {

    public CustomerDetails toDetails(Customer customer){
        User user=customer.getUser();
        CustomerDetails desired=new CustomerDetails();
        desired.setUsername(user.getUsername());
        desired.setCustomerId(customer.getCustomerId());
        return desired;
    }
}
