package com.example.fishFarm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("operationM")
public class OperationDead {

    @RequestMapping("deadFish")
    public String deadFish(){
        return "OperationDeadFish";
    }
}
