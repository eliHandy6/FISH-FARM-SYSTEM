package com.example.fishFarm.repositories;

import com.example.fishFarm.models.Pond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PondRepository extends JpaRepository<Pond, Integer> {


    Boolean existsByPondNumber(int number);

    Boolean existsById(int id);

    List<Pond> findByStockingStatus(boolean status);
    List<Pond> findByFeedingStatus(boolean status);
    List<Pond> findByParamStatus(boolean status);
    List<Pond> findByMedicationStatus(boolean status);

     List<Pond> findByStockingStatusAndParamStatus(boolean stockingstatus,boolean paramStatus);

     List<Pond> findByStockingStatusAndFeedingStatus(boolean stockingstatus,boolean feedingStatus);
    List<Pond> findByStockingStatusAndMedicationStatus(boolean stockingstatus,boolean feedingStatus);

//    @Query("SELECT p.pondNumber,p.pondArea,p.avarageDepth ,t.pondType FROM  Pond p JOIN p.pondType t")
//    public String getPondsData();

}
