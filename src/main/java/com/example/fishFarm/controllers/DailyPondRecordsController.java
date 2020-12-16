package com.example.fishFarm.controllers;

import com.example.fishFarm.models.DailyPondRecords;
import com.example.fishFarm.models.Medicine;
import com.example.fishFarm.models.Pond;
import com.example.fishFarm.models.SeedStock;
import com.example.fishFarm.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("OperationalMaanager")
public class DailyPondRecordsController {


    @Autowired
    DailyPondRecordsService dailyPondRecordsService;

    @Autowired
    SeedingService seedingService;



    @Autowired
    private FeedHistoryService feedHistoryService;


    @Autowired
    private HarvestService harvestService;

    @Autowired
    private PondService pondService;

    @Autowired
    private MedicineHistoryService medicineHistoryService;

    @RequestMapping("viewPhysChemRecords")
    public String viewDailyPondRecords(Model model){
        model.addAttribute("physchemical",dailyPondRecordsService.findDailyRecordsByStatus());
        return "PysiochemicalParameters";
    }





}
