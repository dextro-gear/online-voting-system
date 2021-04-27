package com.cg.onlinevotingsystem.nominatedcandidatems.util;

import com.cg.onlinevotingsystem.nominatedcandidatems.dto.NominatedCandidateDTO;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.dto.UpdateVoterRequest;
import com.cg.onlinevotingsystem.voterms.dto.VoterDetails;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.util.VoterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NominatedCandidatesUtil {

    @Autowired
    private VoterUtil voterUtil;

    public NominatedCandidateDTO toDTO(NominatedCandidates candidate){
        RegisteredSocietyVoters voter=candidate.getSocietyVoter();
        VoterDetails voterDetails=voterUtil.details(voter);
        return new NominatedCandidateDTO(candidate.getCandidateID(), candidate.getNominationFormNo(),voterDetails);
    }

    public List<NominatedCandidateDTO> toDTO(List<NominatedCandidates> candidates){
        List<NominatedCandidateDTO> returnList = new ArrayList<NominatedCandidateDTO>();
        for(NominatedCandidates c: candidates){
            returnList.add(toDTO(c));
        }

        return returnList;
    }


}
