package com.example.objetivo.service;

import com.example.objetivo.model.MonthModel;
import com.example.objetivo.model.YearModel;
import com.example.objetivo.repository.MonthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthService {

    @Autowired
    MonthRepo monthRepo;

    public MonthModel createEmptyMonth(int totalDays, YearModel yearModel) {
        return new MonthModel(totalDays, yearModel);
    }
    public MonthModel save(MonthModel monthModel){

        return monthRepo.save(monthModel);
    }

    public MonthModel findByID(Long id){
        return monthRepo.findById(id).get();
    }
    public List<MonthModel> findByYearModelId(Long yearModelId) {
        return monthRepo.findByYearModel_Id(yearModelId);
    }

}
