package com.example.fishFarm.controllers;

import com.example.fishFarm.models.Feed;
import com.example.fishFarm.models.FeedHistory;
import com.example.fishFarm.models.Owner;
import com.example.fishFarm.services.FeedHistoryService;
import com.example.fishFarm.services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("feedHistory")
public class FeedHistoryController {

    @Autowired
    FeedHistoryService feedHistoryService;


    @Autowired
    FeedService feedService;

    @RequestMapping("viewFeedController")
    public String viewFeedHistory(Model model){
        model.addAttribute("feedhistorylist",feedHistoryService.findAllFeedHistory());
        return "viewFeedHistory";
    }

    @RequestMapping("addFeedHistory")
    public String addFeedHistory(Model model) {
        FeedHistory feedHistory=new FeedHistory();
        model.addAttribute("feed",feedService.findAllFeeds());
        model.addAttribute("feedHistory", feedHistory);
        return "addFeedHistory";
    }

    @RequestMapping("delete/{id}")
    public   String deleteFeedHistory(@PathVariable(name = "id") int id){
       feedHistoryService.deleteFeedHistory(id);
        return "redirect:/feedHistory/viewFeedHistory";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView editFeedHistory(@PathVariable(name="id")int id){

        ModelAndView mav=new ModelAndView("edit_feedHistory");
        FeedHistory feedHistory=feedHistoryService.FeedHistoryTypeById(id);
        mav.addObject("ownfeedHistory",feedHistory);
        return mav;
    }

    @RequestMapping(value="save",method = RequestMethod.POST)

    public  String saveFeedHistory(@ModelAttribute("feedHistory")FeedHistory feedHistory){
        feedHistoryService.saveFeedHistory(feedHistory);
        return "redirect:/feedHistory/viewFeedController";
    }

}
