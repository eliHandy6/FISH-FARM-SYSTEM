package com.example.fishFarm.repositories;

import com.example.fishFarm.models.MedicineHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineHistoryRepository extends JpaRepository<MedicineHistory,Integer> {

    List<MedicineHistory> findByStatusOrderByIdAsc(boolean status);

    List<MedicineHistory> findByPondPondNumberAndStatus(int pondnumber,boolean status);
}
