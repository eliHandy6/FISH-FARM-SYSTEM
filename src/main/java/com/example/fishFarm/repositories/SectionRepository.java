package com.example.fishFarm.repositories;

import com.example.fishFarm.models.FarmSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<FarmSection,Integer> {

}
