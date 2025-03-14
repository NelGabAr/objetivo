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
        model.put("monthId",monthId);
        model.put("monthModel",monthModel);


        return new ModelAndView("table", model);
    }
    @PostMapping(value = "/table")
    public  ModelAndView showTable(@RequestParam Long monthId,@RequestParam Map<String,String> values, Map<String,Object> model) {
        List<DayModel> days = dayService.findByMonthModelID(monthId);

        values.forEach((key,value)->{
            System.err.println(key+":"+value);
            if(!key.equals("monthId")){
                if(key.contains("h")){
                    String aux =  key.replace("h","");
                    int auxKey = Integer.parseInt(aux) - 1;
                    days.get(auxKey).setHollyday(value.equals("true"));

                }
                else{
                    int auxKey = Integer.parseInt(key) - 1;
                    Double auxValue = Double.parseDouble(value);

                    days.get(auxKey).setSells(auxValue);
                    dayService.save(days.get(auxKey));
                }

            }

        });



        model.put("days",days);
        model.put("monthId",monthId);
        return new ModelAndView("table", model);
    }


}
