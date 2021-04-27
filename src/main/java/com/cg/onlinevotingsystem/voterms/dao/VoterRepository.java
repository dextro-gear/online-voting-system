package com.cg.onlinevotingsystem.voterms.dao;

import com.cg.onlinevotingsystem.voterms.entities.RegisteredSocietyVoters;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<RegisteredSocietyVoters, Integer> {

    RegisteredSocietyVoters findRegisteredSocietyVotersByVoterIDCardNo(String cardId);


    boolean existsByVoterIDCardNo(String cardId);
}
