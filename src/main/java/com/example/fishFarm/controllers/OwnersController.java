package com.example.fishFarm.controllers;

import com.example.fishFarm.models.Owner;
import com.example.fishFarm.models.PondType;
import com.example.fishFarm.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.*;

@Controller
@RequestMapping("owners")
public class OwnersController {
	@Autowired
	 OwnerService ownerService;
	
	@RequestMapping("viewOwners")
	public String ViewOwners(Model model) {
		
		List<Owner> listOwners=ownerService.findAllPondOwners();
		model.addAttribute("owners", listOwners);
		return "viewOwners";
		
	}
	
	@RequestMapping("addOwner")
	public String addOwner(Model model) {
		Owner owner= new Owner();
		model.addAttribute("owner", owner);
		return "addOwner";
	}

	@RequestMapping("delete/{id}")
	public   String deleteOwner(@PathVariable(name = "id") int id,RedirectAttributes redirectAttributes){
		String message = "Owner has been deleted  ";

		redirectAttributes.addFlashAttribute("data", message);
		redirectAttributes.addFlashAttribute("message", "success");
		ownerService.deleteOwner(id);
		return "redirect:/owners/viewOwners";
	}

	@RequestMapping("edit/{id}")
	public ModelAndView editOwner(@PathVariable(name="id")int id){

		ModelAndView mav=new ModelAndView("EditOwner");
		Owner owner=ownerService.findOwnerById(id);
		mav.addObject("owner",owner);
		return mav;
	}

	@RequestMapping(value="saveUpdate",method = RequestMethod.POST)
	public  String saveUpdatedOwner(@ModelAttribute("owner")Owner owner, RedirectAttributes redirectAttributes) {
		Boolean existBbyId = ownerService.existById(owner.getIdNo());

		Boolean existByEmail = ownerService.existByEmail(owner.getEmail());

		Boolean existbyBothEmailandId = ownerService.existbyPhoneandEmail(owner.getEmail(), owner.getPhoneno());

		Boolean existbyPhoneNo = ownerService.existbyPhoneNo(owner.getPhoneno());

		Boolean existbyBothfnameandLname = ownerService.existByFnameLname(owner.getFname(), owner.getLname());
		String message;
//
//		 if(existbyBothEmailandId==true){
//
//			message="Email "+owner.getEmail()+" OR PhoneNo "+owner.getPhoneno()+ "is Existing ";
//
//			redirectAttributes.addFlashAttribute("deta",message);
//			redirectAttributes.addFlashAttribute("message","failed");
//
//			return "redirect:/owners/viewOwners";
//		}

		if (existbyBothfnameandLname == true) {


			if (existByEmail == true && existbyPhoneNo == false) {

				ownerService.savePondOwner(owner);
				message = owner.getIdNo() + " " + "Successfully Edited";
				redirectAttributes.addFlashAttribute("data", message);
				redirectAttributes.addFlashAttribute("message", "success");

				return "redirect:/owners/viewOwners";

			} else if (existByEmail == false && existbyPhoneNo == true) {

				ownerService.savePondOwner(owner);
				message = owner.getIdNo() + " " + "Successfully Edited";
				redirectAttributes.addFlashAttribute("data", message);
				redirectAttributes.addFlashAttribute("message", "success");

				return "redirect:/owners/viewOwners";

			} else if (existByEmail == false && existbyPhoneNo == false) {

				ownerService.savePondOwner(owner);
				message = owner.getIdNo() + " " + "Successfully Edited";
				redirectAttributes.addFlashAttribute("data", message);
				redirectAttributes.addFlashAttribute("message", "success");

				return "redirect:/owners/viewOwners";
			} else if(existBbyId==true) {

				message = "ID " + owner.getIdNo() + "is Existing ";

				redirectAttributes.addFlashAttribute("deta", message);
				redirectAttributes.addFlashAttribute("message", "failed");




			}
			else if(existBbyId==false){

				ownerService.savePondOwner(owner);
				message = owner.getIdNo() + " " + "Successfully Edited";
				redirectAttributes.addFlashAttribute("data", message);
				redirectAttributes.addFlashAttribute("message", "success");

			}
			else{

				message = "Email " + owner.getEmail() + " OR PhoneNo " + owner.getPhoneno() + "is Existing ";

				redirectAttributes.addFlashAttribute("deta", message);
				redirectAttributes.addFlashAttribute("message", "failed");
			}
		}
		else {
			ownerService.savePondOwner(owner);
			message = owner.getIdNo() + " " + "Successfully Edited";
			redirectAttributes.addFlashAttribute("data", message);
			redirectAttributes.addFlashAttribute("message", "success");

			return "redirect:/owners/viewOwners";

		}


		return "redirect:/owners/viewOwners";

//		else if(existbyPhoneNo==true){
//
//			message="Phone Number "+owner.getPhoneno()+" "+ "is Existing ";
//
//			redirectAttributes.addFlashAttribute("deta",message);
//			redirectAttributes.addFlashAttribute("message","failed");
//
//			return "redirect:/owners/addOwner";
//
//		}
//		else{
//			ownerService.savePondOwner(owner);
//			message=owner.getIdNo()+" "+ "Successfully Saved";
//			redirectAttributes.addFlashAttribute("data",message);
//			redirectAttributes.addFlashAttribute("message","success" );
//
//			return "redirect:/owners/viewOwners";
//		}

	}


		@RequestMapping(value="save",method = RequestMethod.POST)
	public  String saveOwner(@ModelAttribute("owner")Owner owner, RedirectAttributes redirectAttributes){
		Boolean existBbyId=ownerService.existById(owner.getIdNo());
		Boolean existByEmail=ownerService.existByEmail(owner.getEmail());
		Boolean existbyPhoneNo=ownerService.existbyPhoneNo(owner.getPhoneno());

		String message;

		if(existBbyId==true){

			message="ID "+owner.getIdNo()+" "+ "is Already Used ";

			redirectAttributes.addFlashAttribute("deta",message);
			redirectAttributes.addFlashAttribute("message","failed");

			return "redirect:/owners/addOwner";
		}
		else if (existByEmail==true){

			message="Email "+owner.getEmail()+" "+ "is Existing ";

			redirectAttributes.addFlashAttribute("deta",message);
			redirectAttributes.addFlashAttribute("message","failed");

			return "redirect:/owners/addOwner";
		}
		else if(existbyPhoneNo==true){

			message="Phone Number "+owner.getPhoneno()+" "+ "is Existing ";

			redirectAttributes.addFlashAttribute("deta",message);
			redirectAttributes.addFlashAttribute("message","failed");

			return "redirect:/owners/addOwner";

		}
		else{
			ownerService.savePondOwner(owner);
			message=owner.getIdNo()+" "+ "Successfully Saved";
			redirectAttributes.addFlashAttribute("data",message);
			redirectAttributes.addFlashAttribute("message","success" );

			return "redirect:/owners/addOwner";
		}

	}

}
