package com.cg.onlinevotingsystem.userms.services;

import com.cg.onlinevotingsystem.userms.dao.IUserRepository;
import com.cg.onlinevotingsystem.userms.entities.User;
import com.cg.onlinevotingsystem.userms.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User registerUser(String password, String firstName, String lastName, String emailID, String mobileNo) {
        return userRepository.save(new User()
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailID(emailID)
                .setMobileNo(mobileNo)
        );
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int userID, String password, String firstName, String lastName, String emailID, String mobileNo) {
        Optional<User> userOptional = userRepository.findById(userID);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User with userID:" + userID + " was not found in the DB");

        return userRepository.save(userOptional.get()
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailID(emailID)
                .setMobileNo(mobileNo)
        );
    }

    @Override
    public User deleteUser(int userID) {
        Optional<User> userOptional = userRepository.findById(userID);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User with userID:" + userID + " was not found in the DB");

        userRepository.delete(userOptional.get());
        return userOptional.get();
    }

    @Override
    public List<User> viewUserList() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserID(int userID) {
        Optional<User> userOptional = userRepository.findById(userID);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User with userID:" + userID + " was not found in the DB");

        return userOptional.get();
    }
}
