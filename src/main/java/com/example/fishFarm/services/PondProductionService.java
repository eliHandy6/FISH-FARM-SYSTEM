package com.example.fishFarm.services;

import java.util.List;

import com.example.fishFarm.models.PondProduction;
import com.example.fishFarm.repositories.PondProductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class PondProductionService {
	
	
	@Autowired
	private PondProductionRepository pondProductionRepo;
	
	
	public List<PondProduction> findAllPondProductions(){
		return pondProductionRepo.findAll();
	}
	
	public void savePondProductions(PondProduction  pondProduction) {
		pondProductionRepo.save(pondProduction);
	}
	
	
	public PondProduction findPondProductionrById(Integer id) {
		return pondProductionRepo.findById(id).get();
	}
	
	public void deleteProduction(Integer id) {
		
		pondProductionRepo.deleteById(id);
		
	}
	
	public int countNumberOfProduction() {
		return (int) pondProductionRepo.count();
		
	}
	
	

}
