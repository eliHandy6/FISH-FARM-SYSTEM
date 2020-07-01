package com.example.fishFarm.repositories;

import com.example.fishFarm.models.VarietyStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarietyStockRepository extends JpaRepository<VarietyStock,Integer> {

    Boolean existsBySpeciesId(int id);

    VarietyStock findBySpeciesId(int id);

    Boolean existsById(int id);
}
