package com.example.fishFarm.controllers;

import com.example.fishFarm.services.FeedHistoryService;
import com.example.fishFarm.services.HarvestService;
import com.example.fishFarm.services.MedicineHistoryService;
import com.example.fishFarm.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("farmmanager")
public class FarmManagerController {


    @Autowired
    FeedHistoryService feedHistoryService;

    @Autowired
    MedicineService medicineService;

    @Autowired
    MedicineHistoryService medicineHistoryService;

    @Autowired
    HarvestService harvestService;


    @GetMapping("feedHistory")
    public String managerFeedHistory(Model model){
        model.addAttribute("requestedfeeds",feedHistoryService.findAllbyStatus());
        return "managerfeedhistory";
    }

    @GetMapping("medicines")
    public String managerMedicines(Model model){
        model.addAttribute("medicines",medicineService.allmedicines());
        return "managermedicines";
    }

    @GetMapping("medicinesHistory")
    public String managerMedicineHistory(Model model){

        model.addAttribute("medicineHistory",medicineHistoryService.findAllBystatus());
        return "managermedicineshistory";
    }

    @GetMapping("harvest")
    public String managerHarvest(Model model){
        model.addAttribute("harvestList",harvestService.findAllByStatus());
        return "managerHarvest";
    }





}
