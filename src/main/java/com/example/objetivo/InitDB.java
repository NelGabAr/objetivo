package com.example.objetivo;

import com.example.objetivo.repository.DayRepo;
import com.example.objetivo.repository.MonthRepo;
import com.example.objetivo.service.DayService;
import com.example.objetivo.service.MonthService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDB {
    @Autowired
    MonthService monthService;
    @Autowired
    private DayService dayService;

    @Autowired
    MonthRepo monthRepo;
    @Autowired
    DayRepo dayRepo;

    @PostConstruct
    public void createMonth(){
        System.err.println("cago en dios");
        monthRepo.deleteAll();
        dayRepo.deleteAll();

/*
        MonthModel monthModel = monthService.createEmptyMonth(2);
        monthService.save(monthModel);

        for(int i= 0; i < monthModel.getTotalDays(); i++){
            DayModel dayModel = new DayModel(i+1,monthModel);
            System.err.println(dayModel.toString());
            dayService.save(dayModel);



        }
        monthService.save(monthModel);
  */
    }

}
