package com.example.fishFarm.controllers;

import com.example.fishFarm.services.DailyPondRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("OperationalMaanager")
public class DailyPondRecordsController {


    @Autowired
    DailyPondRecordsService dailyPondRecordsService;

    @RequestMapping("viewPhysChemRecords")
    public String viewDailyPondRecords(Model model){
        model.addAttribute("physchemical",dailyPondRecordsService.findAllDailyRecords());
        return "PysiochemicalParameters";
    }

}
