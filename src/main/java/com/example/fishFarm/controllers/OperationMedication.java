package com.example.fishFarm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("operationMana")
public class OperationMedication {

    @RequestMapping("medication")

    public String FishMedication(){
        return "OperationMedication";
    }
}
