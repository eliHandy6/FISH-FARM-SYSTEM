package com.example.fishFarm.controllers;

import com.example.fishFarm.models.SeedStock;
import com.example.fishFarm.services.PondService;
import com.example.fishFarm.services.SeedingService;
import com.example.fishFarm.services.VarietyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("operationManager")
public class SeedStockingController {

    @Autowired
    PondService pondService;

    @Autowired
    SeedingService seedingService;

    @Autowired
    VarietyStockService varietyStockService;

    // Obtain all values in the SeedStock Table

    @RequestMapping("findall")

    public String obtainAllDatabaseVales(Model model){
        model.addAttribute("allStockData",seedingService.getallStockingData());

        for (SeedStock seedStock:seedingService.getallStockingData()) {

           System.out.println(seedStock.getPond().getPondNumber());
          System.out.println(seedStock.getVarietyStock().getSpecies().getGeneName());
            System.out.println(seedStock.getQuantity());
            System.out.println(seedStock.getAvailable_quantity());
            System.out.println(seedStock.getPond().getPondType().getName());

        }
        return "PondFishStocking";
    }




}
