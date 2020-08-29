package com.example.fishFarm.controllers;


import com.example.fishFarm.models.SmtpMailSender;
import com.example.fishFarm.models.SystemUser;
import com.example.fishFarm.models.VarietyStock;
import com.example.fishFarm.services.SectionsService;
import com.example.fishFarm.services.SystemUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;

@Controller
@RequestMapping("admin")
public class UsersRegistrationControler {

    @Autowired
    SectionsService sectionsService;

    @Autowired
    SystemUsersService systemUsersService;

    @Autowired
    private SmtpMailSender smtpMailSender;




    @RequestMapping("viewallUsers")
    public String viewallUsers(Model model){
        model.addAttribute("SystemUsers",systemUsersService.findAllSystemUsers());

        return "viewSystemUsers";

    }


    @RequestMapping("edit/{id}")
    public ModelAndView editSystemUser(@PathVariable(name="id")int id){
        ModelAndView mav=new ModelAndView("editSystemUser");
        SystemUser user=systemUsersService.findById(id);

        mav.addObject("editUser",user);
        return mav;

    }
    @RequestMapping("addUser")
    public String addUser(Model model){
       SystemUser user=new SystemUser();
        model.addAttribute("user",user);
        model.addAttribute("sections",sectionsService.getAllSections());
        return "newUser";
    }





    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") SystemUser user, RedirectAttributes redirectAttributes) {

        String data;

        Boolean existByUsername = systemUsersService.exixtbyUname(user.getUsername());


        if (existByUsername == true) {

            data = "The Username " + user.getUsername() + "exists";
            redirectAttributes.addFlashAttribute("message", "failed");
            redirectAttributes.addFlashAttribute("data", data);

            return "redirect:";
        } else {

          //  String encodedPass=bCryptPasswordEncoder.encode(user.getPassword());

            systemUsersService.SaveUser(user);

          //  System.out.println(encodedPass);

            data = "The user " + user.getUsername() + "  is successfully saved and logins  sent to " + user.getEmail();
            redirectAttributes.addFlashAttribute("message", "success");
            redirectAttributes.addFlashAttribute("data", data);

//            try {
//                smtpMailSender.send(user.getEmail(),"Logins to the System with "+user.getSection().getSectionName(),"Congratulations!,\nYour username :" +
//                        user.getUsername()
//                +"\n Password : "+user.getPassword());
//
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }


            return "redirect:/admin/addUser";

        }

    }

}




