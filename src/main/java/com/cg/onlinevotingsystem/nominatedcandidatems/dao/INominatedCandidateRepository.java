package com.cg.onlinevotingsystem.nominatedcandidatems.dao;

import com.cg.onlinevotingsystem.nominatedcandidatems.entities.NominatedCandidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INominatedCandidateRepository extends JpaRepository<NominatedCandidates, Integer> {
}
