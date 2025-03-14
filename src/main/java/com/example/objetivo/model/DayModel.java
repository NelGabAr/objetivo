package com.example.objetivo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DayModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean hollyday = false;
    private Double sells;
    private int dayNumber;

    @ManyToOne
    @JoinColumn(name = "monthModel_id")
    private MonthModel monthModel;

    public DayModel(int dayNumber, MonthModel monthModel) {
        this.dayNumber = dayNumber;
        this.monthModel = monthModel;
        this.sells = (double) 0;

    }

}
