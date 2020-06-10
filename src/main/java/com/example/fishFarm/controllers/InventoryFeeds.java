package com.example.fishFarm.controllers;

import com.example.fishFarm.models.Feed;
import com.example.fishFarm.models.Pond;
import com.example.fishFarm.models.SystemUser;
import com.example.fishFarm.services.FeedService;
import com.example.fishFarm.services.NotificationService;
import com.example.fishFarm.services.PondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("inventoryManager")
public class InventoryFeeds {

    @Autowired
    FeedService feedService;

    @Autowired
    PondService pondService;

    @Autowired
    NotificationService notificationService;

    @RequestMapping("feedsData")
    public String viewFeed(Model model) {
        List<Feed> feedList = feedService.findAllFeeds();

        List<Pond> ponds=pondService.findAllPonds();

        for (Pond pond:ponds) {
            System.out.println("hello");
            System.out.println(pond.getPondType());

        }

        model.addAttribute("feedList", feedList);
        //inventoryViewFeeds
        return "inventoryViewFeeds";

    }

    @RequestMapping("addFeed")
    public String addFeed(Model model) {
        Feed feed = new Feed();

        model.addAttribute("feed", feed);
        return "addFeeds";

    }

    @RequestMapping("delete/{id}")
    public String deleteFeed(@PathVariable(name = "id") int id, RedirectAttributes redirectAttributes) {
        feedService.deleteFeed(id);

        String message = "Feed name is deleted ";

        redirectAttributes.addFlashAttribute("data", message);
        redirectAttributes.addFlashAttribute("message", "success");
        return "redirect:/inventoryManager/feedsData";
    }

    @RequestMapping("edit/{id}")
    public ModelAndView editFeed(@PathVariable(name = "id") int id) {

        ModelAndView mav = new ModelAndView("EditFeeds");
        Feed feed = feedService.FeedTypeById(id);
        mav.addObject("feed", feed);
        return mav;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)

    public String saveFeed(@ModelAttribute("feed") Feed feed, RedirectAttributes redirectAttributes) {
        String message;
        Boolean existbyID = feedService.findbyId(feed.getId());
        Boolean existbyName = feedService.findbyFeedname(feed.getFeedName());

//        SystemUser  systemUser=new SystemUser();
//
//        systemUser.setEmail("zackogoma@gmail.com");







//
//				if(feedService.FeedTypeById(feed.getId())){
//
//				}


        if (existbyName == false) {

            feedService.saveFeed(feed);

            message = " Feed " + feed.getFeedName() + " Successfully Saved";
            redirectAttributes.addFlashAttribute("data", message);
            redirectAttributes.addFlashAttribute("message", "success");
//            notificationService.sendNotification(systemUser);

            return "redirect:/inventoryManager/addFeed";


        } else {

            message = " " + feed.getFeedName() + "is Existing ";

            redirectAttributes.addFlashAttribute("deta", message);
            redirectAttributes.addFlashAttribute("message", "failed");

            return "redirect:/inventoryManager/addFeed";


        }

    }


    @RequestMapping(value = "saveUpdate", method = RequestMethod.POST)

    public String saveFeedUpdate(@ModelAttribute("feed") Feed feed, RedirectAttributes redirectAttributes) {
        String message;
        Boolean existbyID = feedService.findbyId(feed.getId());
        Boolean existbyName = feedService.findbyFeedname(feed.getFeedName());

        Feed feed1 = feedService.FeedTypeById(feed.getId());
//
//				if(feedService.FeedTypeById(feed.getId())){
//
//				}


        if (existbyName == false) {

            feedService.saveFeed(feed);

            message = " Feed " + feed.getFeedName() + " Successfully Edited";
            redirectAttributes.addFlashAttribute("data", message);
            redirectAttributes.addFlashAttribute("message", "success");
            return "redirect:/inventoryManager/feedsData";

        }
        if (existbyName == true) {

            if(feed.getFeedName().equalsIgnoreCase(feed1.getFeedName()) ){
                feedService.saveFeed(feed);
                message = " Feed " + feed.getFeedName() + " Successfully Edited";
                redirectAttributes.addFlashAttribute("data", message);
                redirectAttributes.addFlashAttribute("message", "success");
                return "redirect:/inventoryManager/feedsData";

            }
//			else if(feed.getFeedQuality()==feed1.getFeedQuality()||feed.getUnitPrice()==feed1.getUnitPrice()){
//
//				message = " "+feed.getFeedName() + "attributes not changed ";
//
//				redirectAttributes.addFlashAttribute("deta", message);
//				redirectAttributes.addFlashAttribute("message", "failed");
//
//				return "redirect:/feeds/viewFeeds";
//
//			}
            else {
                message = " " + feed.getFeedName() + " is existing";

                redirectAttributes.addFlashAttribute("deta", message);
                redirectAttributes.addFlashAttribute("message", "failed");

                return "redirect:/feeds/viewFeeds";

//				feedService.saveFeed(feed);
//
//				message=" Feed "+feed.getFeedName()+" Successfully Edited";
//				redirectAttributes.addFlashAttribute("data",message);
//				redirectAttributes.addFlashAttribute("message","success" );
//				return "redirect:/feeds/viewFeeds";

            }


        }
        return "redirect:/inventoryManager/feedsData";
    }

}



