package com.cg.onlinevotingsystem.votedlistms.services;
import com.cg.onlinevotingsystem.cooperativesocietyms.entities.CooperativeSociety;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

import java.util.List;
public interface IVotedListService {

    public VotedList castVotedList(RegisteredSocietyVoters voter, NominatedCandidates candidate, CooperativeSociety society);
    public VotedList updateVotedListDetails(int votedListID, RegisteredSocietyVoters voter, NominatedCandidates candidate, CooperativeSociety society) ;
    public VotedList deletedVotedListDetails(int id);
    public List<VotedList> viewVotedList();
    public VotedList searchByVoterId(int voterId);
    public List<VotedList> searchByNominatedCandidateId(int candidateId);

}
