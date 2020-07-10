package com.example.fishFarm.services;

import com.example.fishFarm.models.SeedStock;
import com.example.fishFarm.repositories.SeedingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import  java.util.List;

@Service
public class SeedingService {

    @Autowired
    SeedingRepository seedingRepository;

    public List<SeedStock> getallStockingData(){
        return seedingRepository.findAll();
    }


    //save data to seedstock table\

    public void saveStockData(SeedStock seedStock){
        seedingRepository.save(seedStock);
    }

    //obtain single data from the seedstock table


    public SeedStock getBySeedStockId(int id){
        return seedingRepository.findById(id).get();
    }

    public void DeletebyId(int id){
        seedingRepository.deleteById(id);
    }


    public  Boolean exiting(int pond,int  species){
       return  seedingRepository.existsByPondAndVarietyStock(pond,species);

    }
}
