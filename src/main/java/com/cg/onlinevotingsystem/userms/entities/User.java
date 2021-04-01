package com.cg.onlinevotingsystem.userms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_user")
public class User {

    @Id
    @GeneratedValue
    int userID;

    String password;
    String firstName;
    String lastName;
    String emailID;
    String mobileNo;

    public User() {
    }

    public User(String password, String firstName, String lastName, String emailID, String mobileNo) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailID = emailID;
        this.mobileNo = mobileNo;
    }

    // Getters
    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    // Setters
    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setEmailID(String emailID) {
        this.emailID = emailID;
        return this;
    }

    public User setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }
}
