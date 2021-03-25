package com.cg.onlinevotingsystem.voterms.service;

import java.util.List;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

public interface IRegisteredSocietyVotersService {

    int voterRegistration(RegisteredSocietyVoters voter);
    int updateRegisteredVoterDetails(RegisteredSocietyVoters voter);
    int deleteRegisteredVoter(int voterId);
    List<RegisteredSocietyVoters> viewRegisteredVoterList();
    RegisteredSocietyVoters searchByVoterID(int voterId);
    RegisteredSocietyVoters loginValidate(String userid, String password);

}
