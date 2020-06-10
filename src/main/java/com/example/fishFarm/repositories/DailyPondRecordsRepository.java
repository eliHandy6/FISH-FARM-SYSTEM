package com.example.fishFarm.repositories;

import com.example.fishFarm.models.DailyPondRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyPondRecordsRepository extends JpaRepository<DailyPondRecords, Integer>{

}
