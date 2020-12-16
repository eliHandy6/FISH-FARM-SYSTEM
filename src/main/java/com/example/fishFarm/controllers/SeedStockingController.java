package com.example.fishFarm.controllers;

import com.example.fishFarm.SMS.MessageProperties;
import com.example.fishFarm.SMS.SendSms;
import com.example.fishFarm.models.*;
import com.example.fishFarm.repositories.DailyPondRecordsRepository;
import com.example.fishFarm.services.*;
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

    @Autowired
    FeedService feedService;

    @Autowired
    FeedHistoryService feedHistoryService;

    @Autowired
    DailyPondRecordsService dailyPondRecordsService;

    @Autowired
    DailyPondRecordsRepository dailyPondRecordsRepository;

    @RequestMapping("breeding")
    public String  findBreedingPonds(Model  model){
        model.addAttribute("breedingponds",seedingService.findBreedingponds());
        return "breeding";

    }

    @RequestMapping("nursery")
    public String  findNurseryPonds(Model  model){
        model.addAttribute("nurseryponds",seedingService.findNurseryponds());
        return "nursery";

    }

    @RequestMapping("unfed")
    public String  findUnfedPonds(Model  model){
        List<Pond> pondslist= pondService.getUnfeedPonds();
        for(int i=0;i<pondslist.toArray().length;i++){
            Pond pond = (Pond) pondslist.toArray()[i];
            int approved = seedingService.counttrue(pond.getId());
            pond.setCreatedAt(Integer.toString(approved));
        }
        model.addAttribute("listPonds",pondslist);
        return "unfed";

    }
    @RequestMapping("unTempRecorded")
    public String  findTempUnrecoredPonds(Model  model){
        List<Pond> pondslist= pondService.getPondsWithUnrecordedPhysio();
        for(int i=0;i<pondslist.toArray().length;i++){
            Pond pond = (Pond) pondslist.toArray()[i];
            int approved = seedingService.counttrue(pond.getId());
            pond.setCreatedAt(Integer.toString(approved));
        }
        model.addAttribute("listPonds",pondslist);
        return "unTempRecorded";

    }



    @RequestMapping("findall")
    public String obtainAllDatabaseVales(Model model){
        List<Pond> pondslist= pondService.getUnstockockedFishPond();
        List<SeedStock> seedStocks= seedingService.getallStockingData();
        for(int i=0;i<pondslist.toArray().length;i++){
                Pond pond = (Pond) pondslist.toArray()[i];
                int approved = seedingService.counttrue(pond.getId());
                 pond.setCreatedAt(Integer.toString(approved));
        }
        model.addAttribute("listPonds",pondslist);
        return "PondFishStocking";
    }

    @RequestMapping("/viewpond/{id}")
    public  String speciesinapond(@PathVariable (name = "id") int id,Model model){
        List<SeedStock> findallspeciesinapond=seedingService.findallspeciesinapond(id);
        List <Feed> feedsInStock=feedService.findAllFeeds();
        Pond  pond=pondService.findPondById(id);
        FeedHistory feedhistory=new FeedHistory();
        model.addAttribute("feedhistory",feedhistory);
        model.addAttribute("pond",pond);
        model.addAttribute("findallspeciesinapond",findallspeciesinapond);
        model.addAttribute("feedsInStock",feedsInStock);
        return "pondspecies";
    }
    @RequestMapping("/viewtemp/{id}")
    public  String speciesexisting(@PathVariable (name = "id") int id,Model model){
        List<SeedStock> findallspeciesinapond=seedingService.findallspeciesinapond(id);
        Pond  pond=pondService.findPondById(id);
        DailyPondRecords dailyPondRecords=new DailyPondRecords();
        model.addAttribute("dailyPondRecords",dailyPondRecords);
        model.addAttribute("pond",pond);
        model.addAttribute("findallspeciesinapond",findallspeciesinapond);
        return "viewtemp";
    }

    @RequestMapping("/updatePhysio")
    public  String updatePhysioParam(@ModelAttribute("savePhysio") DailyPondRecords dailyPondRecords,Model model, RedirectAttributes redirectAttributes){
        String data,message = "success";
        System.out.println(dailyPondRecords.toString());
        DailyPondRecords pondRecords=dailyPondRecordsService.RecordById(dailyPondRecords.getId());
        pondRecords.setAmmonia(dailyPondRecords.getAmmonia());
        pondRecords.setNitrogen(dailyPondRecords.getNitrogen());
        pondRecords.setTemprature(dailyPondRecords.getTemprature());


        dailyPondRecordsRepository.save(pondRecords);
        model.addAttribute("physchemical",dailyPondRecordsService.findDailyRecordsByStatus());
        data = "The Physiochemical parameters of the pond number is Successfuly Updated" ;
        redirectAttributes.addFlashAttribute("data", data);
        redirectAttributes.addFlashAttribute("message", message);

        return "PysiochemicalParameters";
    }

    @RequestMapping("/savePhysio")
    public  String savePhysioParam(@ModelAttribute("savePhysio") DailyPondRecords dailyPondRecords, RedirectAttributes redirectAttributes){
       String data,message;
        Pond  pond=pondService.findPondById(dailyPondRecords.getPond().getId());
        dailyPondRecords.setStatus(true);
        dailyPondRecordsService.saveRecords(dailyPondRecords);

        pond.setParamStatus(true);
        pondService.savePond(pond);
        data = "The Physiochemical parameters of the pond number " + dailyPondRecords.getPond().getPondNumber() + " is Successfuly saved" ;
        redirectAttributes.addFlashAttribute("data", data);
        redirectAttributes.addFlashAttribute("message", "success");

        return "redirect:/operationManager/unTempRecorded";
    }



    @RequestMapping("stockpond/{id}")
    public String stockPondwithSeedlings(@PathVariable(name = "id") int id, RedirectAttributes   redirectAttributes,Model  model){
        Pond  pond=pondService.findPondById(id);
        //Obtaining existing species in the pond

        List<SeedStock>existingPondSpecies=seedingService.existingPondSpecies(id);


        //obtaina all varieties in stock and remove varieties which have been stocked

        List <VarietyStock> varietiesInStock=varietyStockService.findAll();

        for (int i = 0; i < varietiesInStock.toArray().length; i++) {

            VarietyStock varietyStock= (VarietyStock) varietiesInStock.toArray()[i];

            System.out.println(varietyStock.getSpecies().getId());

            for (int j=0;j<existingPondSpecies.toArray().length;j++){
                SeedStock seedStock= (SeedStock) existingPondSpecies.toArray()[j];

              //  System.out.println(seedStock.getPond().getId());

                if(varietyStock.getId()==seedStock.getVariety().getId()){
                    varietiesInStock.remove(i);
                }
            }


        }
        SeedStock seedStock=new SeedStock();
        model.addAttribute("seedStock",seedStock);
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

    @RequestMapping(value = "savefeed",method = RequestMethod.POST)
    public String savefeedData(@ModelAttribute("savefeed") FeedHistory feedHistory, RedirectAttributes redirectAttributes ) {


        Pond pond = pondService.findPondById(feedHistory.getPond().getId());


        Feed feed=feedService.FeedTypeById(feedHistory.getFeed().getId());

        String data,message;

        if(feedHistory.getQuanity()>feed.getFeedQuality()){

            data = "The "+feed.getFeedName()+" feed quantity  " + feedHistory.getQuanity() + " exceeds " + feed.getFeedQuality() + " currently in stock";
            redirectAttributes.addFlashAttribute("data", data);
            redirectAttributes.addFlashAttribute("message", "failed");
            return "redirect:/operationManager/viewpond/" + pond.getId();
        }
        else{
            feed.setFeedQuality(feed.getFeedQuality()- feedHistory.getQuanity());
            feedHistory.setStatus(true);
            feedService.saveFeed(feed);
            feedHistoryService.saveFeedHistory(feedHistory);
            pond.setFeedingStatus(true);
            pondService.savePond(pond);

            data = "The pond number " + feedHistory.getPond().getPondNumber()+ " is Successfuly feed with "+feedHistory.getQuanity() +"kgs of " +feedHistory.getFeed().getFeedName();
            redirectAttributes.addFlashAttribute("data", data);
            redirectAttributes.addFlashAttribute("message", "success");
            return "redirect:/operationManager/unfed";

        }


    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String saveStockData(@ModelAttribute("seedStock") SeedStock seedStock, RedirectAttributes redirectAttributes ) {
        Pond pond = pondService.findPondById(seedStock.getPond().getId());

        System.out.println(pond.getPondStockingType());

        String message;
        String data;

        VarietyStock currentSpecies = varietyStockService.getbyID(seedStock.getVariety().getId());
        int Count = seedingService.pondSpeciesNumber(seedStock.getPond().getId());

        System.out.println(Count);
        int currentno = currentSpecies.getNumber();

        boolean answer = seedingService.exiting(seedStock.getPond(), seedStock.getVariety());

        if(seedStock.getStockingDensity()>seedStock.getPond().getPondArea()*2){
            data = "The stocking density  " + seedStock.getStockingDensity() + " exceeds required pond stocking density " +pond.getPondArea()*2 ;
            redirectAttributes.addFlashAttribute("data", data);
            redirectAttributes.addFlashAttribute("message", "failed");
            return "redirect:/operationManager/findall";

        }

        else if (seedStock.getStockingDensity() > currentno) {
            data = "The quantity  " + seedStock.getStockingDensity() + " exceeds " + seedStock.getVariety().getSpecies().getGeneName() + " " + seedStock.getVariety().getSpecies().getSpeciesName() + " quantity  which is " + currentno;
            redirectAttributes.addFlashAttribute("data", data);
            redirectAttributes.addFlashAttribute("message", "failed");
            return "redirect:/operationManager/stockpond/" + seedStock.getPond().getId();

        } else if (answer) {

            data = "The pond number " + seedStock.getPond().getPondNumber() + " has " + seedStock.getVariety().getSpecies().getGeneName() + " " + seedStock.getVariety().getSpecies().getSpeciesName();

            redirectAttributes.addFlashAttribute("data", data);
            redirectAttributes.addFlashAttribute("message", "failed");

            //return "redirect:/operationManager/findall";

            return "redirect:/operationManager/stockpond/" + seedStock.getPond().getId();
        } else if (Count == 0 && seedStock.getPond().getPondStockingType().equals("Breeding")  ) {

            currentSpecies.setNumber(currentSpecies.getNumber() - seedStock.getStockingDensity());
            seedingService.saveStockData(seedStock);
            data = "The pond number " + seedStock.getPond().getPondNumber() + " is Successfuly stocked with " + seedStock.getStockingDensity() + " fingerlings of " + seedStock.getVariety().getSpecies().getGeneName() + " " + seedStock.getVariety().getSpecies().getSpeciesName();
            redirectAttributes.addFlashAttribute("data", data);
            redirectAttributes.addFlashAttribute("message", "success");
            pond.setStockingStatus(true);
            pondService.savePond(pond);
            return "redirect:/operationManager/findall";

        }
        else if (Count < 2 && seedStock.getPond().getPondStockingType().equals("Nursery") ){

            currentSpecies.setNumber(currentSpecies.getNumber() - seedStock.getStockingDensity());
            seedingService.saveStockData(seedStock);
            data = "The pond number " + seedStock.getPond().getPondNumber() + " is Successfuly stocked with " + seedStock.getStockingDensity() + " fingerlings of " + seedStock.getVariety().getSpecies().getGeneName() + " " + seedStock.getVariety().getSpecies().getSpeciesName();
            redirectAttributes.addFlashAttribute("data", data);
            redirectAttributes.addFlashAttribute("message", "success");

            if (Count == 1) {
                pond.setStockingStatus(true);
                pondService.savePond(pond);
            }

            return "redirect:/operationManager/findall";

        }
        else{
            return "redirect:/operationManager/findall";
        }

    }



}
