package com.cg.onlinevotingsystem.voterms.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.cooperativesocietyms.service.CooperativeSocietyServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.IRegisteredSocietyVotersService;

import jdk.internal.org.jline.utils.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Component
public class VoterUI {

    @Autowired
    IRegisteredSocietyVotersService voterService;

    @Autowired
    CooperativeSocietyServiceImpl societyService;

    private static final Logger LOG = LoggerFactory.getLogger(VoterUI.class);

    public void display() {

        CooperativeSociety s1 = societyService.viewSocietyById(1);
        CooperativeSociety s2 = societyService.viewSocietyById(2);
        CooperativeSociety s3 = societyService.viewSocietyById(3);
        CooperativeSociety s4 = societyService.viewSocietyById(4);
        CooperativeSociety s5 = societyService.viewSocietyById(5);
        CooperativeSociety s6 = societyService.viewSocietyById(6);
        CooperativeSociety s7 = societyService.viewSocietyById(7);
        CooperativeSociety s8 = societyService.viewSocietyById(8);
        CooperativeSociety s9 = societyService.viewSocietyById(9);
        CooperativeSociety s10 = societyService.viewSocietyById(10);

        LOG.debug("VOTERS CREATION");
        RegisteredSocietyVoters v1 = new RegisteredSocietyVoters();
        v1.setFirstName("Ritik");
        v1.setLastName("S");
        v1.setGender("Male");
        v1.setPassword("password1");
        v1.setReservationCategory("General");
        v1.setMobileNo("9997876560");
        v1.setEmailId("ritik@gmail.com");
        v1.setAddress1("House No. 1");
        v1.setAddress2("MR Nagar");
        v1.setMandal("Mesur");
        v1.setDistrict("Theni");
        v1.setPincode(111111);
        v1.setCastedVote(false);
        v1.setSociety(s1);
        v1 = voterService.voterRegistration(v1);
        LOG.debug(v1.toString());

        v1 = new RegisteredSocietyVoters();
        v1.setFirstName("Raja");
        v1.setLastName("A");
        v1.setGender("Male");
        v1.setPassword("password2");
        v1.setReservationCategory("General");
        v1.setMobileNo("9952688959");
        v1.setEmailId("raja@gmail.com");
        v1.setAddress1("House No. 2");
        v1.setAddress2("GR Nagar");
        v1.setMandal("Mehsur");
        v1.setDistrict("Aryalur");
        v1.setPincode(222222);
        v1.setCastedVote(false);
        v1.setSociety(s2);
        v1 = voterService.voterRegistration(v1);
        LOG.debug(v1.toString());

        v1 = new RegisteredSocietyVoters();
        v1.setFirstName("Shvi");
        v1.setLastName("G");
        v1.setGender("Female");
        v1.setPassword("password3");
        v1.setReservationCategory("SC");
        v1.setMobileNo("7389217147");
        v1.setEmailId("shivanya@gmail.com");
        v1.setAddress1("House No. 3");
        v1.setAddress2("LR Nagar");
        v1.setMandal("Soch");
        v1.setDistrict("Mulugu");
        v1.setPincode(999999);
        v1.setCastedVote(false);
        v1.setSociety(s9);
        v1 = voterService.voterRegistration(v1);
        LOG.debug(v1.toString());

        v1 = new RegisteredSocietyVoters();
        v1.setFirstName("Samira");
        v1.setLastName("H");
        v1.setGender("Female");
        v1.setPassword("password4");
        v1.setReservationCategory("OBC");
        v1.setMobileNo("9109587771");
        v1.setEmailId("s@gmail.com");
        v1.setAddress1("House No. 4");
        v1.setAddress2("SR Nagar");
        v1.setMandal("Miniasi");
        v1.setDistrict("Erode");
        v1.setPincode(333333);
        v1.setCastedVote(false);
        v1.setSociety(s3);
        v1 = voterService.voterRegistration(v1);
        LOG.debug(v1.toString());

        v1 = new RegisteredSocietyVoters();
        v1.setFirstName("Sam");
        v1.setLastName("M");
        v1.setGender("Male");
        v1.setPassword("password5");
        v1.setReservationCategory("General");
        v1.setMobileNo("9109587774");
        v1.setEmailId("sam@gmail.com");
        v1.setAddress1("House No. 5");
        v1.setAddress2("RS Nagar");
        v1.setMandal("Megham");
        v1.setDistrict("Amravati");
        v1.setPincode(444444);
        v1.setCastedVote(false);
        v1.setSociety(s4);
        v1 = voterService.voterRegistration(v1);
        LOG.debug(v1.toString());

        v1 = new RegisteredSocietyVoters();
        v1.setFirstName("Ira");
        v1.setLastName("N");
        v1.setGender("Female");
        v1.setPassword("password7");
        v1.setReservationCategory("SC");
        v1.setMobileNo("9109587772");
        v1.setEmailId("ira@gmail.com");
        v1.setAddress1("House No. 4");
        v1.setAddress2("SRM Nagar");
        v1.setMandal("Megham");
        v1.setDistrict("Amravati");
        v1.setPincode(666666);
        v1.setCastedVote(false);
        v1.setSociety(s6);
        v1 = voterService.voterRegistration(v1);
        LOG.debug(v1.toString());

        v1 = new RegisteredSocietyVoters();
        v1.setFirstName("Samir");
        v1.setLastName("J");
        v1.setGender("Male");
        v1.setPassword("password8");
        v1.setReservationCategory("OBC");
        v1.setMobileNo("9109587773");
        v1.setEmailId("samir@gmail.com");
        v1.setAddress1("House No. 4");
        v1.setAddress2("STR Nagar");
        v1.setMandal("Megham");
        v1.setDistrict("Amravati");
        v1.setPincode(666666);
        v1.setCastedVote(false);
        v1.setSociety(s6);
        v1 = voterService.voterRegistration(v1);
        LOG.debug(v1.toString());

        v1 = new RegisteredSocietyVoters();
        v1.setFirstName("Mira");
        v1.setLastName("A");
        v1.setGender("Female");
        v1.setPassword("password6");
        v1.setReservationCategory("General");
        v1.setMobileNo("9993320929");
        v1.setEmailId("mira@gmail.com");
        v1.setAddress1("House No. 6");
        v1.setAddress2("SMR Nagar");
        v1.setMandal("Mehsur");
        v1.setDistrict("Aryalur");
        v1.setPincode(222222);
        v1.setCastedVote(false);
        v1.setSociety(s10);
        v1 = voterService.voterRegistration(v1);
        LOG.debug(v1.toString());

        v1 = new RegisteredSocietyVoters();
        v1.setFirstName("Amir");
        v1.setLastName("K");
        v1.setGender("Male");
        v1.setPassword("password9");
        v1.setReservationCategory("General");
        v1.setMobileNo("9109587775");
        v1.setEmailId("amira@gmail.com");
        v1.setAddress1("House No. 4");
        v1.setAddress2("TR Nagar");
        v1.setMandal("Miniasi");
        v1.setDistrict("Erode");
        v1.setPincode(333333);
        v1.setCastedVote(false);
        v1.setSociety(s3);
        v1 = voterService.voterRegistration(v1);
        LOG.debug(v1.toString());

        v1 = new RegisteredSocietyVoters();
        v1.setFirstName("Ram");
        v1.setLastName("L");
        v1.setGender("Male");
        v1.setPassword("password10");
        v1.setReservationCategory("OBC");
        v1.setMobileNo("9109587776");
        v1.setEmailId("ram@gmail.com");
        v1.setAddress1("House No. 4");
        v1.setAddress2("RS Nagar");
        v1.setMandal("Paripakta");
        v1.setDistrict("Chiyaan");
        v1.setPincode(7777777);
        v1.setCastedVote(false);
        v1.setSociety(s7);
        v1 = voterService.voterRegistration(v1);
        LOG.debug(v1.toString());

    }

}
