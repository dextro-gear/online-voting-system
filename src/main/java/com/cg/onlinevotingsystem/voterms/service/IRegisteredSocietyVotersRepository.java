package com.cg.onlinevotingsystem.voterms.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;

public interface IRegisteredSocietyVotersRepository extends JpaRepository<RegisteredSocietyVoters,Integer> {

}
