package com.cg.onlinevotingsystem.nominatedcandidatems.util;

import com.cg.onlinevotingsystem.nominatedcandidatems.dto.NominatedCandidateDTO;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.dto.VoterDTO;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.stereotype.Component;

@Component
public class NominatedCandidatesUtil {

    public NominatedCandidateDTO toDTO(NominatedCandidates candidate){
        return new NominatedCandidateDTO(candidate.getCandidateID(), candidate.getNominationFormNo(), toDTO(candidate.getSocietyVoter()));
    }

    public VoterDTO toDTO(RegisteredSocietyVoters voter){
        return new VoterDTO()
                .setFirstName(voter.getFirstName())
                .setLastName(voter.getLastName())
                .setDistrict(voter.getDistrict())
                .setPincode(voter.getPincode())
                .setAddress1(voter.getAddress1())
                .setAddress2(voter.getAddress2())
                .setEmailID(voter.getEmailId())
                .setGender(voter.getGender())
                .setMandal(voter.getMandal())
                .setVoterID(voter.getId())
                .setVoterIDCardNo(voter.getVoterIdCardNo())
                .setMobileNo(voter.getMobileNo())
                .setPassword(voter.getPassword())
                .setReservationCategory(voter.getReservationCategory())
                .setSocietyID(voter.getSociety().getSocietyId());
    }

}
