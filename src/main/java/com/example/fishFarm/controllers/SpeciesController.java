package com.example.fishFarm.controllers;

import java.sql.SQLOutput;
import java.util.List;

import com.example.fishFarm.models.PondType;
import com.example.fishFarm.models.Species;
import com.example.fishFarm.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("species")
public class SpeciesController {
	
	@Autowired
	SpeciesService speciesService ;
	
	@RequestMapping("viewSpecies")
	
		public String  viewSpecies(Model model) {
		model.addAttribute("speciesList", speciesService.findAllSpecies());
		return "viewSpecies";
	
	}
	
	@RequestMapping("addSpecies")
	public String addSpecies(Model model) {
		
		Species species= new Species();
		model.addAttribute("species",species);
		return "addSpecies";
		
	}
	

	@RequestMapping("delete/{id}")
	public String DeleteSpecies(@PathVariable(name="id") int id,RedirectAttributes redirectAttributes) {
		speciesService.deleteSpecies(id);
		String message = "Fish Species  has been deleted  ";

		redirectAttributes.addFlashAttribute("data", message);
		redirectAttributes.addFlashAttribute("message", "success");
		return "redirect:/species/viewSpecies";

	}

	@RequestMapping("edit/{id}")

	public ModelAndView editSpecies(@PathVariable(name="id")int id){

		ModelAndView mav=new ModelAndView("editSpecies");
		Species species=speciesService.findSpeciesById(id);

		mav.addObject("species",species);
		return mav;
	}

	@RequestMapping(value = "saveUpdate", method = RequestMethod.POST)
	public String saveUpdate(@ModelAttribute("species") Species species, RedirectAttributes redirAttrs) {

		String message;


		Boolean existinSpeciesTable=speciesService.existInSpeciesTable(species.getGeneName(),species.getSpeciesName());

		List<Species> speciesList=speciesService.findByGeneandSpecies(species.getGeneName(),species.getSpeciesName());


			if(speciesList.size()>0){

				message = "Fish Species " + species.getGeneName() + " " + species.getSpeciesName() + " " + "is Existing";

				redirAttrs.addFlashAttribute("data", message);
				redirAttrs.addFlashAttribute("message", "failed");

				return "redirect:/species/viewSpecies";

			}

			else{

				speciesService.saveSpecies(species);
				message = "id " + species.getId() + " " + "Successfully Edited";
				redirAttrs.addFlashAttribute("data", message);
				redirAttrs.addFlashAttribute("message", "success");

				return "redirect:/species/viewSpecies";
			}







//		Boolean ifExistBoolean=speciesService.existBySpeciesName(species.getSpeciesName());
//
//		Species species1=speciesService.findSpeciesById(species.getId());


//		if(species1.getGeneName().equals(species.getGeneName() )) {
//
//			if (species1.getSpeciesName().equals(species.getSpeciesName())) {
//				message = "Fish Species " + species.getGeneName() + " " + species.getSpeciesName() + " " + "is Existing";
//
//				redirAttrs.addFlashAttribute("data", message);
//				redirAttrs.addFlashAttribute("message", "failed");
//
//				return "redirect:/species/viewSpecies";
//
//			} else {
//
//				speciesService.saveSpecies(species);
//				message = "id " + species.getId() + " " + "Successfully Edited";
//				redirAttrs.addFlashAttribute("data", message);
//				redirAttrs.addFlashAttribute("message", "success");
//
//				return "redirect:/species/viewSpecies";
//			}
//		}
//		else {
//////			speciesService.saveSpecies(species);
////			message = "id " + species.getId() + " " + "Successfully Edited";
////			redirAttrs.addFlashAttribute("data", message);
////			redirAttrs.addFlashAttribute("message", "success");
//
//			return "redirect:/species/save";
//
//		}


	}

	@RequestMapping(value="save",method = RequestMethod.POST)

	public  String saveSpecies(@ModelAttribute("species")Species species, RedirectAttributes attrdir){

		List<Species> speciesList=speciesService.findByGeneandSpecies(species.getGeneName(),species.getSpeciesName());
		Boolean answer=speciesService.existBySpeciesName(species.getSpeciesName());
		Boolean foundById=speciesService.existById(species.getId());

		String message;
//
//		System.out.println(foundById);


		if(foundById==true){

			message="ID "+species.getId()+" "+ "is Already Used ";

			attrdir.addFlashAttribute("data",message);
			attrdir.addFlashAttribute("message","failed");

			return "redirect:/species/addSpecies";
		}
		else if(speciesList.size()>0){

			message = "Fish Species " + species.getGeneName() + " " + species.getSpeciesName() + " " + "is Existing";

			attrdir.addFlashAttribute("data", message);
			attrdir.addFlashAttribute("message", "failed");

			return "redirect:/species/addSpecies";

		}

		else if(answer==true){

			message="species "+species.getSpeciesName()+" "+ "is Already existing ";

			attrdir.addFlashAttribute("data",message);
			attrdir.addFlashAttribute("message","failed");

			return "redirect:/species/addSpecies";

		}
		else
		{
			speciesService.saveSpecies(species);
			message=species.getGeneName()+" "+species.getSpeciesName()+" "+ "Successfully Saved";
			attrdir.addFlashAttribute("data",message);
			attrdir.addFlashAttribute("message","success" );

			return "redirect:/species/addSpecies";
		}


	}

	
	
}


