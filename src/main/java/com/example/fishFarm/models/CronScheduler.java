package com.example.fishFarm.models;

import com.example.fishFarm.services.PondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class CronScheduler {

    @Autowired
   private PondService pondService;

    //fire at 12 ;07 am everyday
    @Scheduled(cron = "0 0 * * * *")
    public void run() throws InterruptedException {

        System.out.println("Hello");
        pondService.changeFeedingStatus();
        System.out.println("done");
        pondService.changeParamStatus();
        System.out.println("hello");
        pondService.changeMedicationStatus();
        System.out.println("done");

    }

}
