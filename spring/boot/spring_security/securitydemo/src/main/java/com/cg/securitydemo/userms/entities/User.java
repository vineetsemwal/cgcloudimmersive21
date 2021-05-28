package com.cg.securitydemo.userms.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name="users_data" )
@Entity
public class User {

    @GeneratedValue
    @Id
    private Long userId;

    @Column(nullable=false,unique=true)
    private String username;

    @Column(nullable=false)
    private  String password;


    @ElementCollection(fetch=FetchType.EAGER)
    private Set<String>roles;


    public User() {

    }

    public User(String username, String password,Set<String>roles){
        this.username=username;
        this.password=password;
        this.roles=roles;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
