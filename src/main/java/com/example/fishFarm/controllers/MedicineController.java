package com.example.fishFarm.controllers;

import com.example.fishFarm.models.Medicine;
import com.example.fishFarm.services.MedicineService;
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
@RequestMapping("inventoryManagerMedicines")
public class MedicineController {

    //autowiring Service class

    @Autowired
    MedicineService medicineService;

    //retrieving all medicines in the database
    @RequestMapping("viewMedicines")
    public String viewMedicines(Model model){
        model.addAttribute("medicines",medicineService.allmedicines());
        return "allMedicines";
    }

    // creating a new page to  capture data

    @RequestMapping("addmedicine")
    public String addmedicine(Model model){
        Medicine medicine=new Medicine();
        model.addAttribute("medicine",medicine);
        return "addnewMedicine";

    }


    //Storing medicine into the database

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String saveMedicine(@ModelAttribute("medicine") Medicine medicine, RedirectAttributes redirectAttributes){
        String message;
        String values;
        Boolean existByName=medicineService.existByMedicineName(medicine.getMedicineName());

        if(existByName==true)
        {
            message="The "+ medicine.getMedicineName()+ " medicine exists in the database";

            redirectAttributes.addFlashAttribute("values","failed");
            redirectAttributes.addFlashAttribute("data",message);

            return "redirect:/inventoryManagerMedicines/addmedicine";

        }
        else
        {
            medicineService.saveMedicine(medicine);
            message="The "+ medicine.getMedicineName()+" medicine is successfully saved in the database";
            redirectAttributes.addFlashAttribute("values","success");
            redirectAttributes.addFlashAttribute("data",message);
            return "redirect:/inventoryManagerMedicines/addmedicine";


        }





    }

    //deletes a given id;
    @RequestMapping("delete/{id}")
    public String deletemedicine(@PathVariable(name = "id") int id,RedirectAttributes redirectattribute){

        String message;
        medicineService.deleteById(id);
        message="The medicine data has been successfuly deleted";
        redirectattribute.addFlashAttribute("status","success");
        redirectattribute.addFlashAttribute("data",message);

        return "redirect:/inventoryManagerMedicines/viewMedicines";

    }

        @RequestMapping("edit/{id}")
        public ModelAndView editMedicine(@PathVariable(name = "id")int id){
            ModelAndView mav=new ModelAndView("editmedicine");
            Medicine medicine=medicineService.getmedicinebyid(id);
            mav.addObject("medicine",medicine);
            return mav;
        }

    @RequestMapping(value = "saveUpdate",method = RequestMethod.POST)
    public String saveUpdateMedicine(@ModelAttribute("medicine") Medicine medicine, RedirectAttributes redirectAttributes) {
        String message;
        String values;
        Boolean existByName = medicineService.existByMedicineName(medicine.getMedicineName());

        Medicine medicine1=medicineService.getmedicinebyid(medicine.getNumber());

        if (existByName == false) {

            medicineService.saveMedicine(medicine);
            message = "The " + medicine.getMedicineName() + " medicine is successfully edited";

            redirectAttributes.addFlashAttribute("status", "success");
            redirectAttributes.addFlashAttribute("data", message);

            return "redirect:/inventoryManagerMedicines/viewMedicines";

        }

        if(existByName==true) {

            if (medicine.getMedicineName().equalsIgnoreCase(medicine1.getMedicineName())) {


                medicineService.saveMedicine(medicine);
                message = "The " + medicine.getMedicineName() + " medicine is successfully edited ";
                redirectAttributes.addFlashAttribute("status", "success");
                redirectAttributes.addFlashAttribute("data", message);
                return "redirect:/inventoryManagerMedicines/viewMedicines";
            } else {


                message = "The " + medicine.getMedicineName() + " medicine exists in the database";

                redirectAttributes.addFlashAttribute("status", "failed");
                redirectAttributes.addFlashAttribute("data", message);

                return "redirect:/inventoryManagerMedicines/viewMedicines";

            }

        }



        return "redirect:/inventoryManagerMedicines/viewMedicines";
    }
    }

