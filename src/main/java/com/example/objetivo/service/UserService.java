package com.example.objetivo.service;

import com.example.objetivo.model.UserModel;
import com.example.objetivo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Long login(String username, String password) {
        List<UserModel> userModel;
        try {
            userModel = userRepo.findByUsername(username);

            for (UserModel user : userModel) {
                if (user.getPassword().equals(password)) {
                    return user.getId();
                }

            }
        }
        catch (Exception e) {
            return 0L;
        }
        return 0L;
    }
    public UserModel findById(Long id){
        return userRepo.findById(id).get();
    }

}
