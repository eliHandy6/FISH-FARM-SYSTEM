package com.example.fishFarm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("operationManag")
public class OperationHarvest {

    @RequestMapping("harvest")
    public String harvest(){
        return "OperationHarvest";
    }
}
