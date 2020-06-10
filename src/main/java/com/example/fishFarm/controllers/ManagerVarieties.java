package com.example.fishFarm.controllers;

import com.example.fishFarm.services.VarietyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ManagerVariety")
public class ManagerVarieties {

    @Autowired
    VarietyStockService varietyStockService;

    @RequestMapping("ManagerStockData")
    public String viewVarietyStockData(Model model) {
        model.addAttribute("varietyStockData", varietyStockService.findAll());

        return "managerVarietiesData";

    }
}