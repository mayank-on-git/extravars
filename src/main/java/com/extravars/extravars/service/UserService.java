package com.extravars.extravars.service;

import com.extravars.extravars.entity.User;
import com.extravars.extravars.jpa.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    UserRepo  userRepo;

    public  User saveUser(User user){
        User savedUser = userRepo.save(user);
        return savedUser;

    }
}
