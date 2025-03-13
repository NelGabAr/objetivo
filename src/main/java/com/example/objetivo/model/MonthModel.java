package com.example.objetivo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MonthModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int monthNumber;
    private int totalDays;

    @OneToMany(mappedBy = "monthModel", cascade = CascadeType.ALL)
    private List<DayModel> days;

    @ManyToOne
    @JoinColumn(name = "yearModel_id")
    private YearModel yearModel;

    public  MonthModel(int monthNumber) {
        this.monthNumber = monthNumber;totalDays(monthNumber);

    }



    public void totalDays(int monthNumber) {
        if(monthNumber < 8) {
            if (monthNumber%2==0) {
                if(monthNumber == 2) {
                    totalDays = 28;
                }
                else {
                    totalDays = 30;
                }
            }
            else {
                totalDays=31;
            }
        }
        else {
            if(monthNumber%2==0) {
                totalDays=31;
            }
            else {
                totalDays=30;
            }
        }
    }


}
