package com.example.fishFarm.services;

import java.time.LocalDateTime;
import java.util.List;


import com.example.fishFarm.models.PondType;
import com.example.fishFarm.repositories.PondTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class PondTypeService {




	LocalDateTime now=LocalDateTime.now();


	 String todayTemp= now.toString().replace("T"," ");

	 String dateTime= todayTemp.substring(0,19);

	// String updateTime=todayTemp.substring(0,19);
	
	@Autowired
	private PondTypeRepository pondTypeRepo;
	
	public List<PondType> findAllPondType(){
		return pondTypeRepo.findAll();
	}

	public PondType findPondbyId(Integer id){
		return  pondTypeRepo.findById(id).get();
	}
	public void savePondOType(PondType pondType) {

		if (existsById(pondType.getId())){

			PondType  pondType1=findPondbyId(pondType.getId());

			String created=pondType1.getCreatedAt();

			pondType.setCreatedAt(created);
//			pondType.setUpdatedAt(dateTime);
			pondTypeRepo.save(pondType);
		}
		else {
//			pondType.setCreatedAt(dateTime);
//			pondType.setUpdatedAt(dateTime);
			pondTypeRepo.save(pondType);

		}
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
