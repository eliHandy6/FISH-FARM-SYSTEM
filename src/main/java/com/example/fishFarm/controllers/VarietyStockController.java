package com.example.fishFarm.controllers;

import com.example.fishFarm.models.VarietyStock;
import com.example.fishFarm.services.PondTypeService;
import com.example.fishFarm.services.SpeciesService;
import com.example.fishFarm.services.VarietyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("inventoryManagerVariety")

public class VarietyStockController {

    @Autowired
    VarietyStockService varietyStockService;

    @Autowired
    SpeciesService  speciesService;


    @RequestMapping(value="Save",method = RequestMethod.POST)
    public  String saveVarietyData(@ModelAttribute("varietyStock")VarietyStock varietyStock,RedirectAttributes redirectAttributes){

        String data;

        System.out.println(varietyStock.getSpecies());

        Boolean existbySpecies=varietyStockService.existbySpecies(varietyStock.getSpecies().getId());

        System.out.println(existbySpecies);

        if(existbySpecies==true){

            data="The "+ varietyStock.getSpecies().getGeneName() +" " +varietyStock.getSpecies().getSpeciesName()+ " exists in the database,Kindly Update the existing record ";
            redirectAttributes.addFlashAttribute("message","failed");
            redirectAttributes.addFlashAttribute("data",data);

            return "redirect:/inventoryManagerVariety/varietyData";
        }
        else {

            varietyStockService.saveVarietyData(varietyStock);
            data="The data "+ varietyStock.getSpecies().getGeneName() +" " +varietyStock.getSpecies().getSpeciesName()+ "  Record  is successfully saved";
            redirectAttributes.addFlashAttribute("message","success");
            redirectAttributes.addFlashAttribute("data",data);
            return "redirect:/inventoryManagerVariety/varietyData";

        }
    }


    @RequestMapping("varietyData")
        public String addvariety(Model model){
        VarietyStock varietyStock=new VarietyStock();
        model.addAttribute("varietyStock",varietyStock);
        model.addAttribute("speciesData",speciesService.findAllSpecies());
        return "newVarietyStock";
    }




    @RequestMapping("viewVarietyStockData")
    public String viewVarietyStockData(Model model){
        model.addAttribute("varietyStockData",varietyStockService.findAll());

        return "viewVarietyStockPage";

    }
    @RequestMapping("edit/{id}")
    public ModelAndView editSpeciesData(@PathVariable(name="id")int id){
        ModelAndView mav=new ModelAndView("editVarietyStockData");
        VarietyStock varietyStock=varietyStockService.getbyID(id);

        mav.addObject("varietyStock",varietyStock);
        return mav;

    }
    @RequestMapping("delete/{id}")
    public void DeleteStockData(@PathVariable(name="id")int id, RedirectAttributes redirectAttribute){

        varietyStockService.deleteVariety(id);
    }

    @RequestMapping(value="SaveUpdate",method = RequestMethod.POST)
    public  String UpdateVarietyData(@ModelAttribute("varietyStock")VarietyStock varietyStock,RedirectAttributes redirectAttributes) {

//        System.out.println(varietyStock.getSpecies().getId());

        String data;

//        System.out.println(varietyStock.getSpecies().getId());
//
//        System.out.println(varietyStock.getNumber());
//
//        System.out.println(varietyStock.getPrice());

        Boolean existbySpecies = varietyStockService.existbySpecies(varietyStock.getSpecies().getId());
        Boolean existbyId = varietyStockService.existByID(varietyStock.getId());

//        System.out.println(varietyStock.getId());
//        System.out.println(existbyId);

        if (existbyId == true) {

            System.out.println("exist by id");

//            if (existbySpecies == true) {

                varietyStockService.saveVarietyData(varietyStock);
                data = "The data " + varietyStock.getSpecies().getGeneName() + " " + varietyStock.getSpecies().getSpeciesName() + "  Record  is successfully updated";
                redirectAttributes.addFlashAttribute("message", "success");
                redirectAttributes.addFlashAttribute("data", data);
                return "redirect:/inventoryManagerVariety/viewVarietyStockData";

//            } else {
//
//                return "redirect:/inventoryManagerVariety/viewVarietyStockData";
//
//            }

        }

        else{
            return "redirect:/inventoryManagerVariety/viewVarietyStockData";
        }
//        System.out.println(varietyStock.getSpecies());
//
//        Boolean existbySpecies=varietyStockService.existbySpecies(varietyStock.getSpecies().getId());
//
//        System.out.println(existbySpecies);

//            varietyStockService.saveVarietyData(varietyStock);
//            data="The data "+ varietyStock.getSpecies().getGeneName() +" " +varietyStock.getSpecies().getSpeciesName()+ "  Record  is successfully saved";
//            redirectAttributes.addFlashAttribute("message","success");
//            redirectAttributes.addFlashAttribute("data",data);
//            return "redirect:/inventoryManagerVariety/viewVarietyStockData";

    }
    }

