package com.example.fishFarm.services;

import com.example.fishFarm.models.Harvest;
import com.example.fishFarm.repositories.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestService {

    @Autowired
    private HarvestRepository harvestRepository;

    public Harvest saveHarvest(Harvest harvest){
        return  harvestRepository.save(harvest);
    }

    public List<Harvest> findAllByStatus(){
        return harvestRepository.findByStatus(true);
    }


    public List<Harvest> generateHarvestingDataByPondNumber(int pondnumber){
        return harvestRepository.findBySeedStockPondPondNumberAndStatus(pondnumber,true);
    }



}
