package com.example.fishFarm.controllers;

import com.example.fishFarm.models.PondOwnership;
import com.example.fishFarm.models.PondType;
import com.example.fishFarm.services.OwnerService;
import com.example.fishFarm.services.PondOwnershipService;
import com.example.fishFarm.services.PondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.*;

@Controller
@RequestMapping("ownership")

public class PondOwnershipController {
	
	@Autowired
	private PondService pondService;
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	
	private PondOwnershipService pondOwnershipService;
	
	@RequestMapping("viewPondOwnership")
	
	public String viewPondOnwership(Model model) {
		List <PondOwnership> listPondOwnership=pondOwnershipService.findAllPondOwnership();
		model.addAttribute("listPondOwnership", listPondOwnership);
		
		return "viewPondOwnership";
	}
	@RequestMapping("addPondOwnership")
	public String addPondOwnership(Model model) {
		model.addAttribute("pondList",pondService.findAllPonds());
		model.addAttribute("ownersList",ownerService.findAllPondOwners());
		return "addPondOwnership";
	
	}

	public ModelAndView editPondOwnership(@PathVariable(name="id")int id){

		ModelAndView mav=new ModelAndView("edit_pond_ownership");
		PondOwnership pondOwnership=pondOwnershipService.PondOwnershipById(id);

		mav.addObject("pondOwnership",pondOwnership);
		return mav;
	}

	@RequestMapping(value="save",method = RequestMethod.POST)
	public  String savePondOwnership(@ModelAttribute("pondtype")PondOwnership pondOwnership){
		pondOwnershipService.savePondOwnership(pondOwnership);
		return "redirect:/ownership/viewPondOwnership";
	}




}
