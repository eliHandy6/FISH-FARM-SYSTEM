package com.example.fishFarm.controllers;


import com.example.fishFarm.SMS.SMSNotification;
import com.example.fishFarm.models.FarmSection;
import com.example.fishFarm.models.SmtpMailSender;
import com.example.fishFarm.models.SystemUser;
import com.example.fishFarm.models.VarietyStock;
import com.example.fishFarm.passwordGenerator.PasswordGenerator;
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
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin")
public class UsersRegistrationControler {

    @Autowired
    SectionsService sectionsService;

    @Autowired
    SystemUsersService systemUsersService;

    @Autowired
    private SmtpMailSender smtpMailSender;

    @Autowired
    private SMSNotification smsNotification;

    @Autowired
    private PasswordGenerator passwordGenerator;






    @RequestMapping("viewallUsers")
    public String viewallUsers(Model model){
        List<SystemUser> SystemUsers = systemUsersService.findAllSystemUsers();
        model.addAttribute("SystemUsers",SystemUsers);

        return "viewSystemUsers";

    }

    @RequestMapping("edit/{id}")
    public ModelAndView editSystemUser(@PathVariable(name="id")int id,Model model){
        ModelAndView mav=new ModelAndView("editSystemUser");
        SystemUser user=systemUsersService.findById(id);
        mav.addObject("editUser",user);
        model.addAttribute("sections",sectionsService.getAllSections());
        return mav;

    }

    @RequestMapping("view/{id}")
    public ModelAndView viewUser(@PathVariable(name="id")int id){
        ModelAndView mav=new ModelAndView("user");
        SystemUser user=systemUsersService.findById(id);

//        FarmSection section = sectionsService.findById(user.getSection().getId());
//        String returnedsection=section.getSectionName();
//        section.setSectionName(returnedsection);
//        user.setSection(section);

        mav.addObject("user",user);
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
    public String saveUser(@ModelAttribute("user") SystemUser user, RedirectAttributes redirectAttributes) throws IOException {
        String password=user.getPassword();
        String data;

        Boolean existByUsername = systemUsersService.exixtbyUname(user.getUsername(),user.getEmail());


        if (existByUsername == true) {

            data = "The Username " + user.getUsername()+" or Email"+user.getEmail()+ " exists";
            redirectAttributes.addFlashAttribute("message", "failed");
            redirectAttributes.addFlashAttribute("data", data);

            return "redirect:/admin/addUser";
        } else {
            String generatedpassword= passwordGenerator.generatePassword(6);
            user.setPassword(generatedpassword);
            systemUsersService.SaveUser(user);

            data = "The user " + user.getUsername() + "  is successfully saved " + user.getEmail();
            redirectAttributes.addFlashAttribute("message", "success");
            redirectAttributes.addFlashAttribute("data", data);

                return "redirect:/admin/addUser";
            }


        }

    }






