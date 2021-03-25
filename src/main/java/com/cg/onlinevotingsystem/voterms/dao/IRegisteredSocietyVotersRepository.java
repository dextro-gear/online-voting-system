package com.cg.onlinevotingsystem.voterms.dao;

import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegisteredSocietyVotersRepository extends JpaRepository<RegisteredSocietyVoters, Integer> {
}
