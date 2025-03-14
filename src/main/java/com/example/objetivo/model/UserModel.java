package com.example.objetivo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    private Long Id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    private List<YearModel> yearModel;


    public UserModel(String nelson, String nelsonpass) {
        this.Id = 1L;
        this.username = nelson;
        this.password = nelsonpass;

    }
}
