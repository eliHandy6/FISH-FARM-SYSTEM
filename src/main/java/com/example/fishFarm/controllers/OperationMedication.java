package com.example.fishFarm.controllers;

import com.example.fishFarm.models.*;
import com.example.fishFarm.services.MedicineHistoryService;
import com.example.fishFarm.services.MedicineService;
import com.example.fishFarm.services.PondService;
import com.example.fishFarm.services.SeedingService;
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
@RequestMapping("operationMana")
public class OperationMedication {

    @Autowired
    PondService pondService;

    @Autowired
    SeedingService seedingService;

    @Autowired
    MedicineService medicineService;

    @Autowired
    MedicineHistoryService medicineHistoryService;

    @RequestMapping("medication")
    public String FishMedication( Model model){
        model.addAttribute("medicineHistory",medicineHistoryService.findAllBystatus());

        return "OperationMedication";
    }

    @RequestMapping("mediPonds")
    public String unmedicatedPonds( Model model){
        model.addAttribute("listPonds",pondService.getHealthyPonds());
        return "mediPonds";
    }

    @RequestMapping("treat/{id}" )
    public String treatPond(@PathVariable(name="id")int id,Model model){
        List<SeedStock> findallspeciesinapond=seedingService.findallspeciesinapond(id);
        List<Medicine> allMedicines=medicineService.allmedicines();
        Pond pond=pondService.findPondById(id);
        MedicineHistory medicineHistory=new MedicineHistory();
        model.addAttribute("medicineHistory",medicineHistory);
        model.addAttribute("pond",pond);
        model.addAttribute("findallspeciesinapond",findallspeciesinapond);
        model.addAttribute("allMedicines",allMedicines);
        return "treat";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public  String saveMedication(@ModelAttribute("save") MedicineHistory medicineHistory, RedirectAttributes redirectAttributes){
        String data,message;
        Pond  pond=pondService.findPondById(medicineHistory.getPond().getId());
        Medicine medicine=medicineService.getmedicinebyid(medicineHistory.getMedicine().getNumber());

        if(medicineHistory.getQuantity()>medicine.getMedicineQuantity()){

            data = "The "+medicineHistory.getMedicine().getMedicineName()+" medicine quantity  " + medicineHistory.getQuantity()+ " exceeds " + medicine.getMedicineQuantity() + " currently in stock";
            redirectAttributes.addFlashAttribute("data", data);
            redirectAttributes.addFlashAttribute("message", "failed");
            return "redirect:/operationMana/treat/"+medicineHistory.getPond().getId();

        }
        else {
            medicine.setMedicineQuantity(medicine.getMedicineQuantity()-medicineHistory.getQuantity());
            medicineService.saveMedicine(medicine);

            medicineHistory.setStatus(true);
            medicineHistoryService.createMedicineHistory(medicineHistory);
            pond.setMedicationStatus(true);
            pondService.savePond(pond);

            data = "The Medication of the pond number " + medicineHistory.getPond().getPondNumber() + " is Successfuly saved";
            redirectAttributes.addFlashAttribute("data", data);
            redirectAttributes.addFlashAttribute("message", "success");

            return "redirect:/operationMana/mediPonds";
        }
    }

}
