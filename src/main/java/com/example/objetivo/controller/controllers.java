package com.example.objetivo.controller;

import com.example.objetivo.model.DayModel;
import com.example.objetivo.model.MonthModel;
import com.example.objetivo.service.DayService;
import com.example.objetivo.service.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(name = "/")
public class controllers {

    @Autowired
    MonthService monthService;
    @Autowired
    DayService dayService;


    @GetMapping("/")
    public ModelAndView startPage(Map<String,Object> model) {



        return new ModelAndView("start", model);
    }
    @PostMapping(name = "/", params = {"monthNumber"})
    public ModelAndView createTable(@RequestParam int monthNumber, Map<String,Object> model) {
        MonthModel monthModel = monthService.createEmptyMonth(monthNumber);
        Long monthId;

        monthService.save(monthModel);
        for(int i= 0; i < monthModel.getTotalDays(); i++){
            DayModel dayModel = new DayModel(i+1,monthModel);
            dayService.save(dayModel);



        }
        monthModel =monthService.save(monthModel);
        monthId = monthModel.getId();

        model.put("days",dayService.findByMonthModelID(monthId));
        model.put("monthModel",monthModel);


        return new ModelAndView("table", model);
    }

}
