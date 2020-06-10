package com.example.fishFarm.repositories;

import com.example.fishFarm.models.Pond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PondRepository extends JpaRepository<Pond, Integer> {


    public Boolean existsByPondNumber(int number);

    public  Boolean existsById(int id);


//    @Query("SELECT p.pondNumber,p.pondArea,p.avarageDepth ,t.pondType FROM  Pond p JOIN p.pondType t")
//    public String getPondsData();

}
