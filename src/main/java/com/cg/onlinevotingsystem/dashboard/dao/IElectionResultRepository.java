package com.cg.onlinevotingsystem.dashboard.dao;

import com.cg.onlinevotingsystem.dashboard.entities.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IElectionResultRepository extends JpaRepository<ElectionResult, Integer> {
}
