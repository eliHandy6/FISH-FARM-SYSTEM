package com.example.fishFarm.repositories;

import com.example.fishFarm.models.DailyPondRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyPondRecordsRepository extends JpaRepository<DailyPondRecords, Integer>{

    List<DailyPondRecords> findByStatusOrderByIdAsc(boolean status);

    List<DailyPondRecords> findByPondPondNumberAndStatus(int pondnumber,boolean status);

}
