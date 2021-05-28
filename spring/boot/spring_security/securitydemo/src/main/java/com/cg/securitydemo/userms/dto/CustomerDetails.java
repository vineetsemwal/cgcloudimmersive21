package com.cg.securitydemo.userms.dto;

public class CustomerDetails {

    private Long customerId;

    private String username;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
