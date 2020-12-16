package com.example.fishFarm.controllers;


import com.example.fishFarm.services.FeedHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("operation")
public class OperationFeeds {

    @Autowired
    FeedHistoryService feedHistoryService;

    @RequestMapping("requestedfeeds")
    public String UsedFeeds( Model model){
        model.addAttribute("requestedfeeds",feedHistoryService.findAllbyStatus());
        return  "OperationFeeds";
    }

}
