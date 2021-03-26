package com.cg.onlinevotingsystem.voterms.service;

import java.util.List;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

public interface IRegisteredSocietyVotersService {

    RegisteredSocietyVoters voterRegistration(String voterIdCardNo,String firstName, String lastName, String gender, String password, String reservationCategory,
                                              String mobileNo, String emailId, String address1, String address2, String mandal, String district, int pincode, CooperativeSociety society,
                                              boolean castedVote);
    RegisteredSocietyVoters updateRegisteredVoterDetails(RegisteredSocietyVoters voter);
    RegisteredSocietyVoters deleteRegisteredVoter(int voterId);
    List<RegisteredSocietyVoters> viewRegisteredVoterList();
    RegisteredSocietyVoters searchByVoterID(int voterId);
    RegisteredSocietyVoters loginValidate(String userid, String password);

}
