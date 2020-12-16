package com.example.fishFarm.controllers;

import com.example.fishFarm.models.Pond;
import com.example.fishFarm.models.PondType;
import com.example.fishFarm.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("pond")
public class PondController {

    @Autowired
    PondService pondService;

    @Autowired
    PondTypeService pondTypeService;

    @Autowired
    DailyPondRecordsService dailyPondRecordsService;

    @Autowired
    SeedingService seedingService;



    @Autowired
    private FeedHistoryService feedHistoryService;


    @Autowired
    private HarvestService harvestService;


    @Autowired
    private MedicineHistoryService medicineHistoryService;


    @RequestMapping("viewPonds")

    public String viewPonds(Model model){
        model.addAttribute("listPonds",pondService.findAllPonds());
        return "viewPonds";
    }

    @RequestMapping("addPond")
    public String addNewPond(Model model)
    {
        Pond pond= new Pond();
        model.addAttribute("pond",pond);
        model.addAttribute("pondTypes",pondTypeService.findAllPondType());
        return "addPond";

    }

    @RequestMapping("delete/{id}")
    public   String deletePond(@PathVariable(name = "id") int id){
        pondService.deletePond(id);
        return "redirect:/pond/viewPonds";
    }

    @RequestMapping("edit/{id}")

    public ModelAndView editPond(@PathVariable(name="id")int id){

        ModelAndView mav=new ModelAndView("editPond");
        Pond pond=pondService.findPondById(id);

        mav.addObject("pond",pond);
        mav.addObject("pondTypes",pondTypeService.findAllPondType());
        return mav;
    }

    @RequestMapping("/report/{id}")
    public String report(Model model, @PathVariable("id") int id){


        Pond pond=pondService.findPondById(id);
        int pondNumber=pond.getPondNumber();

        model.addAttribute("pond",pond);
        model.addAttribute("listPonds",seedingService.generateStockingData(pondNumber));
        model.addAttribute("feedHistory",feedHistoryService.generatePondFeedingHistory(pondNumber));
        model.addAttribute("physiochemical",dailyPondRecordsService.generatePhysioByPondNumber(pondNumber));
        model.addAttribute("harvestList",harvestService.generateHarvestingDataByPondNumber(pondNumber));
        model.addAttribute("medicineHistory",medicineHistoryService.generateMedicationReport(pondNumber));

        return "managersum";
    }

    @RequestMapping(value="save",method = RequestMethod.POST)

    public  String savePond(@ModelAttribute("pond")Pond pond, RedirectAttributes redirectAttributes){

        Boolean existbyPondNumber=pondService.existbyPondNumber(pond.getPondNumber());

        String data;


        if(existbyPondNumber){
            data="The pond number "+ pond.getPondNumber()+ " is  existing";

            redirectAttributes.addFlashAttribute("data",data);
            redirectAttributes.addFlashAttribute("message","failed");

            return "redirect:/pond/addPond";

        }
        else{
            pond.setStockingStatus(false);
            pondService.savePond(pond);
            data="The pond number " + pond.getPondNumber()+ " is successfully saved";
            redirectAttributes.addFlashAttribute("data",data);
            redirectAttributes.addFlashAttribute("message","success");
            return "redirect:/pond/addPond";

        }



    }

    @RequestMapping(value="saveUpdate",method = RequestMethod.POST)

    public  String savePondUpdate(@ModelAttribute("pond")Pond pond, RedirectAttributes redirectAttributes){

        Boolean existbyPondNumber=pondService.existbyPondNumber(pond.getPondNumber());

        Boolean existbyId=pondService.existbyId(pond.getId());

        Pond pond2=pondService.findPondById(pond.getId());



        String data;


        if(existbyId){

            if(existbyPondNumber){

                if(pond.getPondType()!=pond2.getPondType()){
                    pondService.savePond(pond);
                    data="The pond number " + pond.getPondNumber()+ " is successfully edited";
                    redirectAttributes.addFlashAttribute("data",data);
                    redirectAttributes.addFlashAttribute("message","success");
                    return "redirect:/pond/viewPonds";
                }

                else if(pond.getPondArea()!=pond2.getPondArea()){

                    pondService.savePond(pond);
                    data="The pond number " + pond.getPondNumber()+ " is successfully edited";
                    redirectAttributes.addFlashAttribute("data",data);
                    redirectAttributes.addFlashAttribute("message","success");
                    return "redirect:/pond/viewPonds";

                }
                else if(pond.getAvarageDepth()!=pond2.getAvarageDepth()){

                    pondService.savePond(pond);
                    data="The pond number " + pond.getPondNumber()+ " is successfully edited";
                    redirectAttributes.addFlashAttribute("data",data);
                    redirectAttributes.addFlashAttribute("message","success");
                    return "redirect:/pond/viewPonds";

                }
                else{


                    data="The pond number "+ pond.getPondNumber()+ " is  existing";

                    redirectAttributes.addFlashAttribute("data",data);
                    redirectAttributes.addFlashAttribute("message","failed");

                    return "redirect:/pond/viewPonds";

                }


            }
            else{

                pondService.savePond(pond);
                data="The pond number " + pond.getPondNumber()+ " is successfully edited";
                redirectAttributes.addFlashAttribute("data",data);
                redirectAttributes.addFlashAttribute("message","success");
                return "redirect:/pond/viewPonds";

            }


        }


        else {

            return "redirect:/pond/viewPonds";

        }


//        if(existbyPondNumber){
//            data="The pond number "+ pond.getPondNumber()+ " is  existing";
//
//            redirectAttributes.addFlashAttribute("data",data);
//            redirectAttributes.addFlashAttribute("message","failed");
//
//            return "redirect:/pond/viewPonds";
//
//        }
//        else{
//
//            pondService.savePond(pond);
//            data="The pond number " + pond.getPondNumber()+ " is successfully saved";
//            redirectAttributes.addFlashAttribute("data",data);
//            redirectAttributes.addFlashAttribute("message","success");
//            return "redirect:/pond/viewPonds";
//
//        }





    }




    }
