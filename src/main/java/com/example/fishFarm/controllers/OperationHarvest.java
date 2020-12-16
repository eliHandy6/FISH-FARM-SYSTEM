package com.example.fishFarm.controllers;

import com.example.fishFarm.config.mpesa.CustomerPayment;
import com.example.fishFarm.config.mpesa.Payment;
import com.example.fishFarm.models.Harvest;
import com.example.fishFarm.services.HarvestService;
import com.example.fishFarm.services.SeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("operationManag")
public class OperationHarvest {

    @Autowired
    private  CustomerPayment customerPayment;

    @Autowired
    private HarvestService harvestService;

    @Autowired

    private SeedingService seedingService;



    @RequestMapping("harvest")
    public String harvest(Model model) throws IOException, JSONException {
        model.addAttribute("harvestList",harvestService.findAllByStatus());
        return "OperationHarvest";
    }

    @RequestMapping("newharvest")
    public String newHarvest(Model model){
        Harvest harvest=new Harvest();
        model.addAttribute("harvest",harvest);
        model.addAttribute("existing",seedingService.approved());
        return "newharvest";
    }

    @RequestMapping("saveHarvest")
    public String saveHarvest(@ModelAttribute("saveHarvest")Harvest harvest, Model model, RedirectAttributes redirectAttributes){
        String message,data;
        harvest.setStatus(true);
        harvestService.saveHarvest(harvest);
        data="The harvest in pond number "+harvest.getSeedStock().getPond().getPondNumber()+ " is successfully saved";
        redirectAttributes.addFlashAttribute("data",data);
        redirectAttributes.addFlashAttribute("message","success");

     return "redirect:/operationManag/harvest";
    }


}
