package com.cg.securitydemo.userms.entities;

import javax.persistence.*;
import java.util.Objects;

@Table(name ="admins_data")
@Entity
public class Admin {

    @GeneratedValue
    @Id
    private Long adminId;

    @OneToOne
    private User user;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId);
    }
}
