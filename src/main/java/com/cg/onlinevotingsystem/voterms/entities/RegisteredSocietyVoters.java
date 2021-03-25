package com.cg.onlinevotingsystem.voterms.entities;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

public class RegisteredSocietyVoters {

    @Id
    @GeneratedValue
    private int id;

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
    private boolean castedVote;

    @OneToOne
    CooperativeSociety cooperativeSociety;

    public RegisteredSocietyVoters() {
        this.voterIDCardNo = null;
        this.firstName = null;
        this.lastName = null;
        this.gender = null;
        this.password = null;
        this.reservationCategory = null;
        this.mobileNo = null;
        this.emailID = null;
        this.address1 = null;
        this.address2 = null;
        this.mandal = null;
        this.district = null;
        this.pincode = 0;
        this.castedVote = false;
        this.cooperativeSociety = null;
    }

    public RegisteredSocietyVoters(String voterIDCardNo, String firstName, String lastName, String gender, String password, String reservationCategory, String mobileNo, String emailID, String address1, String address2, String mandal, String district, int pincode, boolean castedVote, CooperativeSociety cooperativeSociety) {
        this.voterIDCardNo = voterIDCardNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.password = password;
        this.reservationCategory = reservationCategory;
        this.mobileNo = mobileNo;
        this.emailID = emailID;
        this.address1 = address1;
        this.address2 = address2;
        this.mandal = mandal;
        this.district = district;
        this.pincode = pincode;
        this.castedVote = castedVote;
        this.cooperativeSociety = cooperativeSociety;
    }

    public RegisteredSocietyVoters(String voterIDCardNo, String firstName, String lastName, String gender, String password, String reservationCategory, String mobileNo, String emailID, String address1, String address2, String mandal, String district, int pincode, boolean castedVote) {
        this.voterIDCardNo = voterIDCardNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.password = password;
        this.reservationCategory = reservationCategory;
        this.mobileNo = mobileNo;
        this.emailID = emailID;
        this.address1 = address1;
        this.address2 = address2;
        this.mandal = mandal;
        this.district = district;
        this.pincode = pincode;
        this.castedVote = castedVote;
    }

    public int getId() {
        return id;
    }

    public String getVoterIDCardNo() {
        return voterIDCardNo;
    }

    public void setVoterIDCardNo(String voterIDCardNo) {
        this.voterIDCardNo = voterIDCardNo;
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

    public boolean isCastedVote() {
        return castedVote;
    }

    public void setCastedVote(boolean castedVote) {
        this.castedVote = castedVote;
    }

    public CooperativeSociety getCooperativeSociety() {
        return cooperativeSociety;
    }

    public void setCooperativeSociety(CooperativeSociety cooperativeSociety) {
        this.cooperativeSociety = cooperativeSociety;
    }
}
