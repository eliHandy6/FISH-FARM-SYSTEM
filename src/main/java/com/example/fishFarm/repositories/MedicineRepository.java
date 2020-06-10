package com.example.fishFarm.repositories;

import com.example.fishFarm.models.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Integer> {


    //adding new method to findexistance of medicine in the database

    Boolean existsByMedicineName(String name);

}
