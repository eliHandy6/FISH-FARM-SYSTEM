package com.example.fishFarm.controllers;

import com.example.fishFarm.models.PondType;
import com.example.fishFarm.services.PondTypeService;
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
@RequestMapping("pondtype")

public class PondTypeController {

	@Autowired
	PondTypeService pondTypeService;


	@RequestMapping("viewPondTypes")
	public String viewPondTypes(Model model) {

		model.addAttribute("listOfPondTypes", pondTypeService.findAllPondType());

		return "viewPondTypes";
	}


	@RequestMapping("addNewPondType")
	public String addNewPondType(Model model) {
		PondType pondType = new PondType();
		model.addAttribute("pondType", pondType);
		return "addNewPondType";

	}

	@RequestMapping("delete/{id}")
	public String deletePondType(@PathVariable(name = "id") int id, RedirectAttributes redirAttrs) {


		pondTypeService.deletePondType(id);

		String message = "Pond Type has been deleted ";

		redirAttrs.addFlashAttribute("data", message);
		redirAttrs.addFlashAttribute("message", "success");

		return "redirect:/pondtype/viewPondTypes";
	}

	@RequestMapping("edit/{id}")

	public ModelAndView editPondTypes(@PathVariable(name = "id") int id) {

		ModelAndView mav = new ModelAndView("editPondType");
		PondType pondtype = pondTypeService.PondTypeById(id);

		mav.addObject("pondType", pondtype);
		return mav;
	}

	@RequestMapping(value = "saveUpdate", method = RequestMethod.POST)
	public String saveUpdate(@ModelAttribute("pondtype") PondType pondType, RedirectAttributes redirAttrs) {

		String message;

		List<PondType> PondByName = pondTypeService.findByname(pondType.getName());


		if(PondByName.isEmpty() ){

			pondTypeService.savePondOType(pondType);
			message="Pond Type is  Successfully Edited";
			redirAttrs.addFlashAttribute("data",message);
			redirAttrs.addFlashAttribute("message","success" );


			return "redirect:/pondtype/viewPondTypes";


		}
		else{

			message=pondType.getName()+" "+ "is Existing";

			redirAttrs.addFlashAttribute("deta",message);
			redirAttrs.addFlashAttribute("message","failed");

			return "redirect:/pondtype/viewPondTypes";
		}



	}


	@RequestMapping(value = "save", method = RequestMethod.POST)

	public String savePondType(@ModelAttribute("pondtype") PondType pondType ,RedirectAttributes redirAttrs) {

		String message;

		List <PondType> PondByName=pondTypeService.findByname(pondType.getName());

		Boolean id=pondTypeService.existsById(pondType.getId());


		if(id==true ){


			message="ID "+pondType.getId()+" "+ "is Already Used ";

			redirAttrs.addFlashAttribute("deta",message);
			redirAttrs.addFlashAttribute("message","failed");

			return "redirect:/pondtype/addNewPondType";
		}

		else if( PondByName.size()>0){

			message="Pond Name "+pondType.getName()+" "+ "is Existing ";

			redirAttrs.addFlashAttribute("deta",message);
			redirAttrs.addFlashAttribute("message","failed");

			return "redirect:/pondtype/addNewPondType";
		}
		else {

			pondTypeService.savePondOType(pondType);
			message=pondType.getName()+" "+ "Successfully Saved";
			redirAttrs.addFlashAttribute("data",message);
			redirAttrs.addFlashAttribute("message","success" );


			return "redirect:/pondtype/addNewPondType";

		}

//
//		if(PondByName.isEmpty() ){
//
//
//
//
//		}
//		else{
//
//
//
//			message=pondType.getName()+" "+ "is Existing";
//
//			redirAttrs.addFlashAttribute("deta",message);
//			redirAttrs.addFlashAttribute("message","failed");
//
//			return "redirect:/pondtype/addNewPondType";
//		}




	}
}
