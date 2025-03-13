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
public class YearModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int yearNumber;

    @OneToMany(mappedBy = "yearModel")
    private List<MonthModel> monthModel;


}
