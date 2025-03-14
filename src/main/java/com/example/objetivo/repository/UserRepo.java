package com.example.objetivo.repository;

import com.example.objetivo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Long> {
    public UserModel save(UserModel userModel);

    List<UserModel> findByUsername(String username);
}
