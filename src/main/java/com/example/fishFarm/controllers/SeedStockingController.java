package com.example.fishFarm.controllers;

import com.example.fishFarm.models.Pond;
import com.example.fishFarm.models.SeedStock;
import com.example.fishFarm.models.Species;
import com.example.fishFarm.models.VarietyStock;
import com.example.fishFarm.services.PondService;
import com.example.fishFarm.services.SeedingService;
import com.example.fishFarm.services.VarietyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

//        for (SeedStock seedStock:seedingService.getallStockingData()) {
//
//           System.out.println(seedStock.getPond().getPondNumber());
//          System.out.println(seedStock.getVarietyStock().getSpecies().getGeneName());
//            System.out.println(seedStock.getQuantity());
//            System.out.println(seedStock.getAvailable_quantity());
//            System.out.println(seedStock.getPond().getPondType().getName());
//
//        }
        return "PondFishStocking";
    }

    @RequestMapping("addfishStocking")
    public String addStock(Model model){
        SeedStock seedStock=new SeedStock();
        model.addAttribute("seedStock",seedStock);
        model.addAttribute("pond",pondService.findAllPonds());
        model.addAttribute("varietystock",varietyStockService.findAll());



        for(VarietyStock z:varietyStockService.findAll()){

            System.out.println(z.getId());

        }
        return "addfishStocking";

    }
@RequestMapping(value = "save",method = RequestMethod.POST)
    public String saveStockData(@ModelAttribute("seedStock") SeedStock seedStock, RedirectAttributes redirectAttributes ){

        String message;
        String data;

    System.out.println(seedStock.getVarietyStock().getSpecies());

//        boolean answer=seedingService.exiting(seedStock.getPond().getId(),seedStock.getVarietyStock().getId());
//
//    System.out.println(answer);

//        if(answer) {
//
//            data="The pond number "+seedStock.getPond().getPondNumber() +"has " +seedStock.getVarietyStock().getSpecies().getGeneName()+ " "+seedStock.getVarietyStock().getSpecies().getSpeciesName();
//
//            redirectAttributes.addFlashAttribute("data",data);
//            redirectAttributes.addFlashAttribute("message","failed");
//
//        return "redirect:/operationManager/addfishStocking";
//          }
//        else{
//
//
//
//        return "redirect:/operationManager/addfishStocking";
//        }

    return "redirect:/operationManager/addfishStocking";

}



}
