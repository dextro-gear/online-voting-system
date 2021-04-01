package com.cg.onlinevotingsystem.userms.dao;

import com.cg.onlinevotingsystem.userms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
