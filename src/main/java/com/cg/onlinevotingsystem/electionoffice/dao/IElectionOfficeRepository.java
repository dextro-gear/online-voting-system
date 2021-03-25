package com.cg.onlinevotingsystem.electionoffice.dao;

import com.cg.onlinevotingsystem.electionoffice.entities.ElectionOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IElectionOfficeRepository extends JpaRepository<ElectionOfficer, Integer> {
}
