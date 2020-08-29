package com.example.fishFarm.services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.fishFarm.models.Pond;
import com.example.fishFarm.repositories.PondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PondService {


	LocalDateTime now=LocalDateTime.now();


	String todayTemp= now.toString().replace("T"," ");

	String dateTime= todayTemp.substring(0,19);
	
	@Autowired
	private PondRepository pondRepo;
	
	public List<Pond> findAllPonds()
	{
		return pondRepo.findAll();
	}
	
	public void savePond(Pond pond)
	{

		if(existbyId(pond.getId())){

			Pond pond1=findPondById(pond.getId());
			String created=pond1.getCreatedAt();

			pond.setCreatedAt(created);
			//pond.setUpdatedAt(dateTime);
			pondRepo.save(pond);

		}
		else{
			//pond.setCreatedAt(dateTime);
			//pond.setUpdatedAt(dateTime);
			pondRepo.save(pond);
		}

	}
	
	
	public Pond findPondById(Integer id) {
		return pondRepo.findById(id).get();
	}
	
	public void deletePond(Integer id) {
		
		pondRepo.deleteById(id);
		
	}
	
	public int countNumberofPonds() {
		return (int) pondRepo.count();
		
	}

	public Boolean existbyPondNumber(int id){
		return pondRepo.existsByPondNumber(id);
	}
	public Boolean existbyId(int id){
		return pondRepo.existsById(id);
	}
	

}
