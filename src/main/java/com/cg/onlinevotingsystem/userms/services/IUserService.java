package com.cg.onlinevotingsystem.userms.services;

import com.cg.onlinevotingsystem.userms.entities.User;

import java.util.List;

public interface IUserService {

    User registerUser(User user);
    User registerUser(String password, String firstName, String lastName, String emailID, String mobileNo);

    User updateUser(User user);
    User updateUser(int id, String password, String firstName, String lastName, String emailID, String mobileNo);

    User deleteUser(int userID);

    List<User> viewUserList();

    User findByUserID(int userID);

}
