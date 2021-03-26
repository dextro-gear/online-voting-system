package com.cg.onlinevotingsystem.nominatedcandidatems.services;

import com.cg.onlinevotingsystem.nominatedcandidatems.dao.INominatedCandidateRepository;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NominatedCandidateServiceImpl implements INominatedCandidatesService{

    @Autowired
    INominatedCandidateRepository nominatedCandidateRepository;

    @Override
    public NominatedCandidates addNominatedCandidate(String nominationFormNo, RegisteredSocietyVoters societyVoters) {
        return null;
    }

    @Override
    public NominatedCandidates updateNominatedCandidateDetails(String nominationFormNo, RegisteredSocietyVoters societyVoters) {
        return null;
    }

    @Override
    public NominatedCandidates deleteNominatedCandidate(int candidateID) {
        return null;
    }

    @Override
    public NominatedCandidates searchByCandidateID(int candidateID) {
        return null;
    }

    @Override
    public List<NominatedCandidates> viewNominatedCandidateList() {
        return null;
    }
}
