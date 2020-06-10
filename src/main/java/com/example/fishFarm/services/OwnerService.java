package com.example.fishFarm.services;

import java.util.List;

import com.example.fishFarm.models.Owner;
import com.example.fishFarm.repositories.OwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OwnerService {
	
	@Autowired
	private OwnersRepository ownerRepo;
	
	public List<Owner> findAllPondOwners(){
		return ownerRepo.findAll();
	}
	
	public void savePondOwner(Owner  owner) {
		ownerRepo.save(owner);
	}
	
	
	public Owner findOwnerById(Integer id) {
		return ownerRepo.findById(id).get();
	}
	
	public void deleteOwner(Integer id) {
		
		ownerRepo.deleteById(id);
		
	}
	
	public int countNumberofPonds() {
		return (int) ownerRepo.count();
		
	}

	public  Boolean existById(int id){
		return ownerRepo.existsByIdNo(id);

	}

	public Boolean existByEmail(String email){
		return ownerRepo.existsByEmail(email);
	}

	public Boolean existbyPhoneNo(String phoneno){
		return ownerRepo.existsByPhoneno(phoneno);
	}

	public Boolean existbyPhoneandEmail(String email,String phone){

		return ownerRepo.existsByEmailOrPhoneno(email,phone);

	}


	public Boolean existByFnameLname(String fname,String lname){
		return ownerRepo.existsByFnameAndLname(fname,lname);
	}

	
	
	
	

}
