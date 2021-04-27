package com.cg.onlinevotingsystem.votedlistms.dao;

import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVotedListRepository extends JpaRepository<VotedList, Integer> {
    VotedList findVotedListByVoter(RegisteredSocietyVoters voter);

    boolean existsByVoter(RegisteredSocietyVoters voter);

    VotedList findByVoter_Id(int voterID);

    List<VotedList> findByCandidate_CandidateID(int candidateID);
}
