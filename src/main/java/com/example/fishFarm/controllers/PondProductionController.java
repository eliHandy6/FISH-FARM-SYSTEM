package com.example.fishFarm.controllers;

import com.example.fishFarm.models.PondProduction;
import com.example.fishFarm.models.PondType;
import com.example.fishFarm.services.PondProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("pondproduction")
public class PondProductionController {

    @Autowired
    PondProductionService pondProductionService;


    @RequestMapping("viewpondproduction")

        public String viewFishStocking(Model model){
        model.addAttribute("pondproductionList",pondProductionService.findAllPondProductions());

        return "viewPondProduction";

    }

    @RequestMapping("addNewPondProduction")

    public String addNewPondproduction(Model model)
    {
        PondProduction pondProduction= new PondProduction();
        model.addAttribute("pondProduction",pondProduction);
        return "addNewPondproduction";

    }

    @RequestMapping("delete/{id}")
    public   String deletePondProduction(@PathVariable(name = "id") int id){
        pondProductionService.findPondProductionrById(id);
        return "redirect:/pondproduction/viewPondProduction";
    }

    @RequestMapping("edit/{id}")

    public ModelAndView editPondProduction(@PathVariable(name="id")int id){

        ModelAndView mav=new ModelAndView("edit_pond_production");
        PondProduction pondProduction=pondProductionService.findPondProductionrById(id);

        mav.addObject("pondProduction",pondProduction);
        return mav;
    }

    @RequestMapping(value="save",method = RequestMethod.POST)

    public  String savePondProduction(@ModelAttribute("pondtype")PondProduction pondProduction){
        pondProductionService.savePondProductions(pondProduction);
        return "redirect:/pondproduction/viewPondProduction";
    }

}




