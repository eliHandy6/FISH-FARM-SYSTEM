package com.example.fishFarm.repositories;

import com.example.fishFarm.models.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  SpeciesRepository extends  JpaRepository<Species, Integer> {


    Boolean existsByspeciesName(String speciesName);

    Boolean existsByName(String name);

    Boolean existsByGeneNameAndSpeciesName(String gname,String sname);

    List<Species> findByGeneNameAndSpeciesName(String gname,String sname);
}
