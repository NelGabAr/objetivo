package com.example.objetivo.service;

import com.example.objetivo.model.MonthModel;
import com.example.objetivo.repository.MonthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonthService {
    @Autowired
    MonthRepo monthRepo;

    public MonthModel createEmptyMonth(int totalDays){
        return new MonthModel(totalDays);
    }
    public MonthModel save(MonthModel monthModel){

        return monthRepo.save(monthModel);
    }

    public MonthModel findByID(Long id){
        return monthRepo.findById(id).get();
    }

}
