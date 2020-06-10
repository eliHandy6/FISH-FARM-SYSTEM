package com.example.fishFarm.services;

import com.example.fishFarm.models.VarietyStock;
import com.example.fishFarm.repositories.VarietyStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VarietyStockService {
    @Autowired
    VarietyStockRepository repository;


    public VarietyStock getbyID(int id){
        return repository.findById(id).get();
    }

    public List<VarietyStock> findAll(){
        return repository.findAll();
    }

    public void saveVarietyData(VarietyStock s){
        repository.save(s);
    }

    public void deleteVariety(int id){

        repository.deleteById(id);

    }

    public Boolean existbySpecies(int id){
       return repository.existsBySpeciesId(id);
    }

    public VarietyStock findbySpecies(int id){
        return repository.findBySpeciesId(id);
    }

    public Boolean existByID(int id){
        return repository.existsById(id);
    }
}
