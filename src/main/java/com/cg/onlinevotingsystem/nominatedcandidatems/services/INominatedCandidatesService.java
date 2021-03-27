package com.cg.onlinevotingsystem.nominatedcandidatems.services;

import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import java.util.List;

public interface INominatedCandidatesService {

    public NominatedCandidates addNominatedCandidate(NominatedCandidates candidate);
    NominatedCandidates addNominatedCandidate(String nominationFormNo, RegisteredSocietyVoters societyVoters);
    NominatedCandidates updateNominatedCandidateDetails(int id, String nominationFormNo, RegisteredSocietyVoters societyVoters);
    NominatedCandidates deleteNominatedCandidate(int candidateID);
    NominatedCandidates searchByCandidateID(int candidateID);
    List<NominatedCandidates> viewNominatedCandidateList();

}
