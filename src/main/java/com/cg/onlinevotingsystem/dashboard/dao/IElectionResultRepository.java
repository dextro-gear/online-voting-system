package com.cg.onlinevotingsystem.dashboard.dao;

import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IElectionResultRepository extends JpaRepository<ElectionResult, Integer> {
    ElectionResult findElectionResultByCandidate(NominatedCandidates candidate);

}
