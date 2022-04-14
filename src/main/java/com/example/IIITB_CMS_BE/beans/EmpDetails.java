package com.example.IIITB_CMS_BE.beans;


import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table()
public class EmpDetails {

    @Id
    private String id;

    private String role;

    private String name;

    private String password;

    @Email
    private String email;

    private boolean status;

    public EmpDetails() {
    }

    public EmpDetails(String id, String role, String name, String password, String email, boolean status) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EmpDetails{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
