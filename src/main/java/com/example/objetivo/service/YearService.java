package com.example.objetivo.service;

import com.example.objetivo.model.MonthModel;
import com.example.objetivo.model.YearModel;
import com.example.objetivo.repository.YearRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YearService {
@Autowired
YearRepo yearRepo;

public YearModel save(YearModel yearModel){
    return yearRepo.save(yearModel);
}
public YearModel findYearById(Long id){
    return yearRepo.findYearModelById(id);
}

}
