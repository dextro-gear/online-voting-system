package com.cg.onlinevotingsystem.voterms.dto;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;

import javax.validation.constraints.NotBlank;

public class CreateVoterRequest {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String gender;
    @NotBlank
    private String password;
    private String reservationCategory;
    @NotBlank
    private String mobileNo;
    @NotBlank
    private String emailID;
    @NotBlank
    private String address1;
    private String address2;
    private String mandal;
    private String district;
    private int pincode;
    private int societyId;
    private boolean castedVote;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReservationCategory() {
        return reservationCategory;
    }

    public void setReservationCategory(String reservationCategory) {
        this.reservationCategory = reservationCategory;
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

    public String getMandal() {
        return mandal;
    }

    public void setMandal(String mandal) {
        this.mandal = mandal;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public boolean getCastedVote() {
        return castedVote;
    }

    public void setCastedVote(boolean castedVote) {
        this.castedVote = castedVote;
    }

    public int getSocietyId() {
        return societyId;
    }

    public void setSocietyId(int societyId) {
        this.societyId = societyId;
    }

    public boolean isCastedVote() {
        return castedVote;
    }
}
