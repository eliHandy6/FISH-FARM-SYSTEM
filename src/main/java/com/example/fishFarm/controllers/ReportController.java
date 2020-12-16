package com.example.fishFarm.controllers;

import com.example.fishFarm.models.Medicine;
import com.example.fishFarm.models.Pond;
import com.example.fishFarm.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("farm")
public class ReportController {


    @Autowired
    private SeedingService seedingService;

    @Autowired
    private FeedHistoryService feedHistoryService;

    @Autowired
    private DailyPondRecordsService dailyPondRecordsService;

    @Autowired
    private HarvestService harvestService;

    @Autowired
    private PondService  pondService;

    @Autowired
    private MedicineHistoryService medicineHistoryService;

    @RequestMapping("pond")
    public String farmponds(Model model){
        model.addAttribute("listPonds",pondService.getStockedFishPond());
        return "farmponds";
    }

    @RequestMapping("report/{pondId}")
    public String generateReports(@PathVariable("pondId")int pondId, Model model){

        Pond pond=pondService.findPondById(pondId);
        int pondNumber=pond.getPondNumber();

        model.addAttribute("pond",pond);
        model.addAttribute("listPonds",seedingService.generateStockingData(pondNumber));
        model.addAttribute("feedHistory",feedHistoryService.generatePondFeedingHistory(pondNumber));
        model.addAttribute("physiochemical",dailyPondRecordsService.generatePhysioByPondNumber(pondNumber));
        model.addAttribute("harvestList",harvestService.generateHarvestingDataByPondNumber(pondNumber));
        model.addAttribute("medicineHistory",medicineHistoryService.generateMedicationReport(pondNumber));
        return "report";
    }
}
