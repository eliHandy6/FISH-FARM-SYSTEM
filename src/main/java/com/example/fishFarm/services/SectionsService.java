package com.example.fishFarm.services;

import com.example.fishFarm.models.FarmSection;
import com.example.fishFarm.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SectionsService {

    @Autowired
    SectionRepository sectionRepository;


    public List<FarmSection> getAllSections(){
        return  sectionRepository.findAll();
    }



}
