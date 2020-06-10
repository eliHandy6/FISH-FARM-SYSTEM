package com.example.fishFarm.services;

import java.util.List;

import com.example.fishFarm.models.Species;
import com.example.fishFarm.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpeciesService {
	
	@Autowired
	private SpeciesRepository speciesRepo;
	
	public List<Species> findAllSpecies(){
		return speciesRepo.findAll();
	}
	
	public void saveSpecies(Species species) {
		speciesRepo.save(species);
	}
	
	
	public Species findSpeciesById(Integer id) {
		return speciesRepo.findById(id).get();
	}
	
	public void deleteSpecies(Integer id) {
		
		speciesRepo.deleteById(id);
		
	}
	
	public int countNumberofSpecies() {
		return (int) speciesRepo.count();
		
	}

	public Boolean existBySpeciesName(String name){
		return speciesRepo.existsByspeciesName(name);
	}

	public Boolean existById(int id){
		return speciesRepo.existsById(id);
	}


	public  Boolean existInSpeciesTable(String gname,String sname){
		return speciesRepo.existsByGeneNameAndSpeciesName(gname, sname);
	}

	public  List<Species> findByGeneandSpecies(String gname,String sname){
		return speciesRepo.findByGeneNameAndSpeciesName(gname, sname);
	}
//	public void editSpecies( int id,Species species) {
//		for (int i = 0; i < speciesRepo.findAll().size(); i++) {
//			
//			Species s=speciesRepo.findAll().get(i);
//			
//			if(s.getId()==id) {
//				speciesRepo.findAll().set
//				
//			}
//			
//			
//		}
//	}
//	

	
	
	
	
	
}
