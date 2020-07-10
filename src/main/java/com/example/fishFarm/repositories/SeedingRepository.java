package com.example.fishFarm.repositories;

import com.example.fishFarm.models.SeedStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeedingRepository extends JpaRepository<SeedStock,Integer> {

    public  boolean existsByPondAndVarietyStock(int pondno,int variety);
}
