package com.cg.onlinevotingsystem.nominatedcandidatems.ui;

import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.nominatedcandidatems.services.NominatedCandidateServiceImpl;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import com.cg.onlinevotingsystem.voterms.service.RegisteredSocietyVotersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CandidatesUI {

    @Autowired
    NominatedCandidateServiceImpl candidateService;

    @Autowired
    RegisteredSocietyVotersServiceImpl votersService;

    private static final Logger LOG = LoggerFactory.getLogger(CandidatesUI.class);

    public void start(){
        RegisteredSocietyVoters voter1 = votersService.searchByVoterID(14);
        RegisteredSocietyVoters voter2 = votersService.searchByVoterID(17);
        RegisteredSocietyVoters voter3 = votersService.searchByVoterID(16);

        LOG.debug("CANDIDATES CREATION");

        NominatedCandidates candidate1 = new NominatedCandidates("AE1F2G3455", voter1);
        candidate1 = candidateService.addNominatedCandidate(candidate1);

        NominatedCandidates candidate2 = new NominatedCandidates("AE1F545F55", voter2);
        candidate2 = candidateService.addNominatedCandidate(candidate2);

        NominatedCandidates candidate3 = new NominatedCandidates("AE1F747F77", voter3);
        candidate3 = candidateService.addNominatedCandidate(candidate3);

        LOG.debug(candidate1.toString());
        LOG.debug(candidate2.toString());
        LOG.debug(candidate3.toString());

    }

}
