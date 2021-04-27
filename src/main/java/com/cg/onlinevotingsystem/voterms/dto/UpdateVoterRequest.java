package com.cg.onlinevotingsystem.voterms.dto;

public class UpdateVoterRequest {

    private int societyID;
    private String voterIDCardNo;
    private String firstName;
    private String lastName;
    private String gender;
    private String password;
    private String reservationCategory;
    private String mobileNo;
    private String emailID;
    private String address1;
    private String address2;
    private String mandal;
    private String district;
    private int pincode;

    public int getSocietyID() {
        return societyID;
    }

    public UpdateVoterRequest setSocietyID(int societyID) {
        this.societyID = societyID;
        return this;
    }

    public String getVoterIDCardNo() {
        return voterIDCardNo;
    }

    public UpdateVoterRequest setVoterIDCardNo(String voterIDCardNo) {
        this.voterIDCardNo = voterIDCardNo;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UpdateVoterRequest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UpdateVoterRequest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public UpdateVoterRequest setGender(String gender) {
        this.gender= gender;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UpdateVoterRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getReservationCategory() {
        return reservationCategory;
    }

    public UpdateVoterRequest setReservationCategory(String reservationCategory) {
        this.reservationCategory = reservationCategory;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public UpdateVoterRequest setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getEmailID() {
        return emailID;
    }

    public UpdateVoterRequest setEmailID(String emailID) {
        this.emailID = emailID;
        return this;
    }

    public String getAddress1() {
        return address1;
    }

    public UpdateVoterRequest setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public UpdateVoterRequest setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getMandal() {
        return mandal;
    }

    public UpdateVoterRequest setMandal(String mandal) {
        this.mandal = mandal;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public UpdateVoterRequest setDistrict(String district) {
        this.district = district;
        return this;
    }

    public int getPincode() {
        return pincode;
    }

    public UpdateVoterRequest setPincode(int pincode) {
        this.pincode = pincode;
        return this;
    }
}
