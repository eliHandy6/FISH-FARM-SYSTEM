package com.example.fishFarm.repositories;

import com.example.fishFarm.models.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest,Integer> {
    List<Harvest> findByStatus(boolean status);
    List<Harvest> findBySeedStockPondPondNumberAndStatus(int pondnumber,boolean status);
}
