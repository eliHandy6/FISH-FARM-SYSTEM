package com.example.fishFarm.repositories;

import com.example.fishFarm.models.PondType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PondTypeRepository extends JpaRepository<PondType, Integer> {



   List<PondType> findByName(String name);

   List<PondType>findById(int id);

   Boolean existsById(int id);


}
