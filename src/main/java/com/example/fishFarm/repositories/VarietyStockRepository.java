package com.example.fishFarm.repositories;

import com.example.fishFarm.models.VarietyStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarietyStockRepository extends JpaRepository<VarietyStock,Integer> {

    public Boolean existsBySpeciesId(int id);

    public VarietyStock findBySpeciesId(int id);

    public  Boolean existsById(int id);
}
