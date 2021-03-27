package com.cg.onlinevotingsystem.cooperativesocietyms.dto;

public class CreateCooperativeSocietyRequest {
    private String societyName;
    private String headOfSociety;
    private String village;
    private String mandal;
    private String district;
    private String pincode;

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    public String getHeadOfSociety() {
        return headOfSociety;
    }

    public void setHeadOfSociety(String headOfSociety) {
        this.headOfSociety = headOfSociety;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
