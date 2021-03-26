package com.cg.onlinevotingsystem.nominatedcandidatems.services;

import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import java.util.List;

public interface INominatedCandidatesService {

    NominatedCandidates addNominatedCandidate(String nominationFormNo, RegisteredSocietyVoters societyVoters);
    NominatedCandidates updateNominatedCandidateDetails(String nominationFormNo, RegisteredSocietyVoters societyVoters);
    NominatedCandidates deleteNominatedCandidate(int candidateID);
    NominatedCandidates searchByCandidateID(int candidateID);
    List<NominatedCandidates> viewNominatedCandidateList();

}
