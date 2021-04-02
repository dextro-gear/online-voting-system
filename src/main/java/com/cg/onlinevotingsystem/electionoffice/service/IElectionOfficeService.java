package com.cg.onlinevotingsystem.electionoffice.service;

import com.cg.onlinevotingsystem.electionoffice.entities.ElectionOfficer;

import java.util.List;

public interface IElectionOfficeService {

    ElectionOfficer addElectionOfficer(ElectionOfficer officer);

    ElectionOfficer updateElectionOfficerDetails(ElectionOfficer officer);

    ElectionOfficer deleteElectionOfficer(int officerID);

    ElectionOfficer viewElectionOfficerByID(int officerID);

    List<ElectionOfficer> viewElectionOfficersList();

}
