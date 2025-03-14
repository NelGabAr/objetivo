package com.example.objetivo;

import com.example.objetivo.model.DayModel;
import com.example.objetivo.model.MonthModel;
import com.example.objetivo.model.UserModel;
import com.example.objetivo.model.YearModel;
import com.example.objetivo.repository.DayRepo;
import com.example.objetivo.repository.MonthRepo;
import com.example.objetivo.repository.UserRepo;
import com.example.objetivo.repository.YearRepo;
import com.example.objetivo.service.DayService;
import com.example.objetivo.service.MonthService;
import com.example.objetivo.service.YearService;
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
    private YearService yearService;

    @Autowired
    MonthRepo monthRepo;
    @Autowired
    DayRepo dayRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private YearRepo yearRepo;

    @PostConstruct
    public void createMonth(){
        System.err.println("cago en dios");
        monthRepo.deleteAll();
        dayRepo.deleteAll();
        userRepo.deleteAll();
        yearRepo.deleteAll();

        UserModel userModel = new UserModel("nelson", "nelsonpass");
        userModel =userRepo.save(userModel);
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


        YearModel yearModel = new YearModel(2024,userModel);
        yearService.save(yearModel);

        MonthModel monthModel = new MonthModel(1,yearModel);
        monthService.save(monthModel);

        int iterator =monthModel.getTotalDays();
        for(int i=0;i<iterator;i++){
            DayModel dayModel = new DayModel(i+1,monthModel);
            dayService.save(dayModel);
        }

    }

}
