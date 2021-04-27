package com.cg.onlinevotingsystem.voterms.dto;

public class VoterDTO {

    private int voterID;
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

    public int getVoterID() {
        return voterID;
    }

    public VoterDTO setVoterID(int voterID) {
        this.voterID = voterID;
        return this;
    }

    public int getSocietyID() {
        return societyID;
    }

    public VoterDTO setSocietyID(int societyID) {
        this.societyID = societyID;
        return this;
    }

    public String getVoterIDCardNo() {
        return voterIDCardNo;
    }

    public VoterDTO setVoterIDCardNo(String voterIDCardNo) {
        this.voterIDCardNo = voterIDCardNo;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public VoterDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public VoterDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public VoterDTO setGender(String gender) {
        this.gender= gender;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public VoterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getReservationCategory() {
        return reservationCategory;
    }

    public VoterDTO setReservationCategory(String reservationCategory) {
        this.reservationCategory = reservationCategory;
        return this;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public VoterDTO setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
        return this;
    }

    public String getEmailID() {
        return emailID;
    }

    public VoterDTO setEmailID(String emailID) {
        this.emailID = emailID;
        return this;
    }

    public String getAddress1() {
        return address1;
    }

    public VoterDTO setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public VoterDTO setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getMandal() {
        return mandal;
    }

    public VoterDTO setMandal(String mandal) {
        this.mandal = mandal;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public VoterDTO setDistrict(String district) {
        this.district = district;
        return this;
    }

    public int getPincode() {
        return pincode;
    }

    public VoterDTO setPincode(int pincode) {
        this.pincode = pincode;
        return this;
    }
}
