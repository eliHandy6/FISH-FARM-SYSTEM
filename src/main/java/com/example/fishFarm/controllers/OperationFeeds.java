package com.example.fishFarm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("operation")
public class OperationFeeds {

    @RequestMapping("requestedfeeds")
    public String UsedFeeds(){

        return  "OperationFeeds";
    }

}
