package com.example.fishFarm.controllers;

import com.example.fishFarm.models.Feed;
import com.example.fishFarm.services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FeedRestController {

    @Autowired
    FeedService feedService;

    @RequestMapping(path = "/fes",method = RequestMethod.GET)
        public List<Feed> viewFeed() {
         return feedService.findAllFeeds();
	}


}
