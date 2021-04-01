package com.cg.onlinevotingsystem.userms.ui;

import com.cg.onlinevotingsystem.userms.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUI {

    @Autowired
    UserServiceImpl userService;

    public void start(){
        userService.registerUser("password", "Raja", "G", "abhishek.bhattar@gmail.com", "9080597245");
    }

}
