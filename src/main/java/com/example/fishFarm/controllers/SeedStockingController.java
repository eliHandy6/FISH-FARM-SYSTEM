package com.example.fishFarm.controllers;

import com.example.fishFarm.SMS.MessageProperties;
import com.example.fishFarm.SMS.SendSms;
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
import org.springframework.web.bind.annotation.PathVariable;
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


        List<Pond> pondslist= pondService.findAllPonds();
        List<SeedStock> seedStocks= seedingService.getallStockingData();


        for(int i=0;i<pondslist.toArray().length;i++){

                Pond pond = (Pond) pondslist.toArray()[i];
                int approved = seedingService.counttrue(pond.getId());
                int unpproved = seedingService.countfalse(pond.getId());
                 pond.setCreatedAt(Integer.toString(approved));
                 pond.setUpdatedAt(Integer.toString(unpproved));


        }


        model.addAttribute("listPonds",pondslist);

//        MessageProperties messageProperties=new MessageProperties();
//        SendSms sendSms=new SendSms();
//
//        messageProperties.setPhoneNumber("+254703907872");
//        messageProperties.setMessage("hello world");
//
//        sendSms.sendSMS(messageProperties);

        return "PondFishStocking";
    }

    @RequestMapping("stockpond/{id}")
    public String stockPondwithSeedlings(@PathVariable(name = "id") int id, RedirectAttributes   redirectAttributes,Model  model){
        Pond  pond=pondService.findPondById(id);


        //obtaina all varieties in stock and remove those with 0 number of seedlings

        List <VarietyStock> varietiesInStock=varietyStockService.findAll();

        for (int i = 0; i < varietiesInStock.toArray().length; i++) {

            VarietyStock varietyStock= (VarietyStock) varietiesInStock.toArray()[i];


        }

        model.addAttribute("variety",varietiesInStock);
        model.addAttribute("pond",pond);
        return "addfishStocking.html";

    }

    @RequestMapping("addfishStocking")
    public String addStock(Model model){
        SeedStock seedStock=new SeedStock();
        model.addAttribute("seedStock",seedStock);
        model.addAttribute("pond",pondService.findAllPonds());
        model.addAttribute("varietystock",varietyStockService.findAll());


        return "";

    }
@RequestMapping(value = "save",method = RequestMethod.POST)
    public String saveStockData(@ModelAttribute("seedStock") SeedStock seedStock, RedirectAttributes redirectAttributes ){

        String message;
        String data;

        VarietyStock currentSpecies=varietyStockService.getbyID(seedStock.getVariety().getId());
        int currentno=currentSpecies.getNumber();

         System.out.println(currentno);

     boolean answer=seedingService.exiting(seedStock.getPond(),seedStock.getVariety());

        if(seedStock.getQuantity()>currentno){

            data="The quantity  "+seedStock.getQuantity() +" exceeds " +seedStock.getVariety().getSpecies().getGeneName()+ " "+seedStock.getVariety().getSpecies().getSpeciesName()+ " quantity  which is "+currentno;

            redirectAttributes.addFlashAttribute("data",data);
            redirectAttributes.addFlashAttribute("message","failed");

            return "redirect:/operationManager/addfishStocking";

        }


        else if(answer) {

            data="The pond number "+seedStock.getPond().getPondNumber() +" has " +seedStock.getVariety().getSpecies().getGeneName()+ " "+seedStock.getVariety().getSpecies().getSpeciesName();

            redirectAttributes.addFlashAttribute("data",data);
            redirectAttributes.addFlashAttribute("message","failed");

                 return "redirect:/operationManager/addfishStocking";
          }
        else{


            currentSpecies.setNumber(currentSpecies.getNumber()-seedStock.getQuantity());
            seedingService.saveStockData(seedStock);
            data="The pond number "+seedStock.getPond().getPondNumber() +" is Successfuly stocked with "+seedStock.getQuantity()+" seeds of "+seedStock.getVariety().getSpecies().getGeneName()+ " "+seedStock.getVariety().getSpecies().getSpeciesName();
            redirectAttributes.addFlashAttribute("data",data);
            redirectAttributes.addFlashAttribute("message","success" );


            return "redirect:/operationManager/addfishStocking";
        }



}



}
