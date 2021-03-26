package com.cg.onlinevotingsystem.votedlistms.dao;

import com.cg.onlinevotingsystem.votedlistms.entities.VotedList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVotedListRepository extends JpaRepository<VotedList, Integer> {
}
