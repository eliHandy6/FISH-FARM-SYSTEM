package com.example.fishFarm.services;

import java.util.List;

import com.example.fishFarm.models.PondOwnership;
import com.example.fishFarm.repositories.PondOwnershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class PondOwnershipService {
	
	@Autowired
	private PondOwnershipRepository pondOwnershipRepo;
	
	
	public List<PondOwnership> findAllPondOwnership(){
		return pondOwnershipRepo.findAll();
	}
	
	public void savePondOwnership(PondOwnership pondOwnership) {
		pondOwnershipRepo.save(pondOwnership);
	}
	
	
	public PondOwnership PondOwnershipById(Integer id) {
		return pondOwnershipRepo.findById(id).get();
	}
	
	public void deletePondOwnership(Integer id) {
		
		pondOwnershipRepo.deleteById(id);
		
	}
	
	public int countNumberOfPondOwnership(){
		return (int) pondOwnershipRepo.count();
		
	}
	
	

}
