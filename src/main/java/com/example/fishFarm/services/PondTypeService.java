package com.example.fishFarm.services;

import java.util.List;


import com.example.fishFarm.models.PondType;
import com.example.fishFarm.repositories.PondTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class PondTypeService {
	
	
	@Autowired
	private PondTypeRepository pondTypeRepo;
	
	public List<PondType> findAllPondType(){
		return pondTypeRepo.findAll();
	}
	
	public void savePondOType(PondType pondType) {
		pondTypeRepo.save(pondType);
	}
	
	
	public PondType PondTypeById(Integer id) {
		return pondTypeRepo.findById(id).get();
	}

	public Boolean existsById(int id){
		return pondTypeRepo.existsById(id);
	}
	
	public void deletePondType(Integer id) {
		
		pondTypeRepo.deleteById(id);
		
	}
	
	public int countNumberOfPondTypes(){
		return (int) pondTypeRepo.count();
		
	}


	public List<PondType> findByname(String name){
		return pondTypeRepo.findByName(name);
	}



}
