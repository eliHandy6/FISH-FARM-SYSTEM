package com.example.fishFarm.repositories;

import com.example.fishFarm.models.PondProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PondProductionRepository extends JpaRepository<PondProduction, Integer> {

}
