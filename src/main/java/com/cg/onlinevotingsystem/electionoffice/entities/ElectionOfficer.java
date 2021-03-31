package com.cg.onlinevotingsystem.electionoffice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ElectionOfficer {

    @Id
    @GeneratedValue
    private int officerID;

    private String firstName;
    private String lastName;
    private String password;
    private String gender;
    private String mobileNo;
    private String emailID;
    private String address1;
    private String address2;
    private String district;


    public ElectionOfficer(String firstName, String lastName, String password, String gender, String mobileNo, String emailID, String address1, String address2, String district) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.gender = gender;
        this.mobileNo = mobileNo;
        this.emailID = emailID;
        this.address1 = address1;
        this.address2 = address2;
        this.district = district;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "ElectionOfficer{" +
                "officerID=" + officerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", emailID='" + emailID + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", district='" + district + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectionOfficer)) return false;
        ElectionOfficer that = (ElectionOfficer) o;
        return officerID == that.officerID && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(password, that.password) && Objects.equals(gender, that.gender) && Objects.equals(mobileNo, that.mobileNo) && Objects.equals(emailID, that.emailID) && Objects.equals(address1, that.address1) && Objects.equals(address2, that.address2) && Objects.equals(district, that.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(officerID, firstName, lastName, password, gender, mobileNo, emailID, address1, address2, district);
    }
}
