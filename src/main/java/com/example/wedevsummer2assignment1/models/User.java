package com.example.wedevsummer2assignment1.models;

import javax.persistence.*;
import java.util.Date;
import java.time.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String role;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUser(User user) {

        this.firstName = user.firstName != null ? user.firstName : this.firstName;
        this.lastName = user.lastName != null ? user.lastName : this.lastName;
        this.username = user.username != null ? user.username : this.username;
        this.password = user.password != null ? user.password : this.password;
        this.phone = user.phone != null ? user.phone : this.phone;
        this.email = user.email != null ? user.email : this.email;
        this.role = user.role != null ? user.role : this.role;
        this.dateOfBirth = user.dateOfBirth != null ? user.dateOfBirth : this.dateOfBirth;

    }

}