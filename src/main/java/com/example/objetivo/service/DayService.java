package com.example.objetivo.service;

import com.example.objetivo.model.DayModel;
import com.example.objetivo.repository.DayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayService {
    @Autowired
    DayRepo dayRepo;


public DayModel save(DayModel dayModel){
    return dayRepo.save(dayModel);
}
public List<DayModel> findByMonthModelID(Long id){
    return dayRepo.findByMonthModelId(id);
}

}
