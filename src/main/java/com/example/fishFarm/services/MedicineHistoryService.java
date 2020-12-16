package com.example.fishFarm.services;

import com.example.fishFarm.models.MedicineHistory;
import com.example.fishFarm.repositories.MedicineHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineHistoryService {

    @Autowired
    MedicineHistoryRepository medicineHistoryRepository;

    //save
    public MedicineHistory createMedicineHistory(MedicineHistory medicineHistory){
        return medicineHistoryRepository.save(medicineHistory);
    }

    //findAll
    public List<MedicineHistory> findAllMedicineHistory(){
        return  medicineHistoryRepository.findAll();
    }
    //find medicine histoy
    public List<MedicineHistory> findAllBystatus(){
        return medicineHistoryRepository.findByStatusOrderByIdAsc(true);
    }

    public List<MedicineHistory> generateMedicationReport(int pondnumber){
        return medicineHistoryRepository.findByPondPondNumberAndStatus(pondnumber,true);
    }

}
