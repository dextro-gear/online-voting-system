package com.cg.onlinevotingsystem.votedlistms.dao;

import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVotedListRepository extends JpaRepository<VotedList, Integer> {
    VotedList findByIdVoter(RegisteredSocietyVoters voter);
    List<VotedList> findByIdCandidate(NominatedCandidates candidates);
}
