package com.example.fishFarm.repositories;

import com.example.fishFarm.models.Pond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PondRepository extends JpaRepository<Pond, Integer> {


    Boolean existsByPondNumber(int number);

    Boolean existsById(int id);


//    @Query("SELECT p.pondNumber,p.pondArea,p.avarageDepth ,t.pondType FROM  Pond p JOIN p.pondType t")
//    public String getPondsData();

}
