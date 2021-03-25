package com.cg.onlinevotingsystem.electionoffice.service;

import com.cg.onlinevotingsystem.electionoffice.entities.ElectionOfficer;

import java.util.List;

public interface IElectionOfficeService {

    ElectionOfficer addElectionOfficer(String firstName, String lastName, String password, String gender, String mobileNo, String emailID, String address1 ,String address2, String district);
    ElectionOfficer updateElectionOfficerDetails(String firstName, String lastName, String password, String gender, String mobileNo, String emailID, String address1 ,String address2, String district);
    ElectionOfficer deleteElectionOfficer(int officerID);
    ElectionOfficer viewElectionOfficerByID(int officerID);
    List<ElectionOfficer> viewElectionOfficersList();

}
