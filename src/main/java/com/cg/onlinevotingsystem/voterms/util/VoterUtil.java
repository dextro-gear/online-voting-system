package com.cg.onlinevotingsystem.voterms.util;

import com.cg.onlinevotingsystem.voterms.dto.VoterDetails;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.stereotype.Component;

@Component
public class VoterUtil {
    public VoterDetails details(RegisteredSocietyVoters registeredSocietyVoters){
        VoterDetails vd = new VoterDetails();
        vd.setVoterIDCardNo(registeredSocietyVoters.getVoterIdCardNo());
        vd.setFirstName(registeredSocietyVoters.getFirstName());
        vd.setLastName(registeredSocietyVoters.getLastName());
        vd.setGender(registeredSocietyVoters.getGender());
        vd.setPassword(registeredSocietyVoters.getPassword());
        vd.setReservationCategory(registeredSocietyVoters.getReservationCategory());
        vd.setMobileNo(registeredSocietyVoters.getMobileNo());
        vd.setEmailID(registeredSocietyVoters.getEmailId());
        vd.setAddress1(registeredSocietyVoters.getAddress1());
        vd.setAddress2(registeredSocietyVoters.getAddress2());
        vd.setMandal(registeredSocietyVoters.getMandal());
        vd.setDistrict(registeredSocietyVoters.getDistrict());
        vd.setPincode(registeredSocietyVoters.getPincode());
        vd.setCooperativeSociety(registeredSocietyVoters.getSociety());
        vd.setCastedVote(registeredSocietyVoters.getCastedVote());
        return vd;
    }
}
