package com.example.IIITB_CMS_BE.beans;


import javax.persistence.*;

@Entity
@Table()
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String Role;

    private String Name;

    private String Password;

    public UserDetails() {
    }

    public UserDetails(int id, String role, String name, String password) {
        this.id = id;
        Role = role;
        Name = name;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", Role='" + Role + '\'' +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
