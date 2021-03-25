package com.cg.onlinevotingsystem.voterms.services;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import java.util.List;

public interface IRegisteredSocietyVotersService {

    RegisteredSocietyVoters voterRegistration(String voterIDCard, String firstName, String lastName, String gender, String password, String reservationCategory, String mobileNo, String emailID, String address1, String address2, String mandal, String district, int pincode, boolean castedVote, CooperativeSociety society);
    RegisteredSocietyVoters updateRegisteredVoterDetails(String voterIDCard, String firstName, String lastName, String gender, String password, String reservationCategory, String mobileNo, String emailID, String address1, String address2, String mandal, String district, int pincode, boolean castedVote, CooperativeSociety society);
    RegisteredSocietyVoters deleteRegisteredVoter(int voterID);
    List<RegisteredSocietyVoters> viewRegisteredVoterList();
    RegisteredSocietyVoters searchByVoterID(int voterID);
    RegisteredSocietyVoters loginValidate(String userID, String password);

}
