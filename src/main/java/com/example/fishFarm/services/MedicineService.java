package com.example.fishFarm.services;

import com.example.fishFarm.models.Medicine;
import com.example.fishFarm.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicineService {

    @Autowired
    MedicineRepository medicineRepo;

    //return all medicines
    public List<Medicine> allmedicines(){
//        System.out.println("we are here");
//        System.out.println(medicineRepo.findAll());
        return medicineRepo.findAll();
    }

    //find medicine by id

    public Medicine getmedicinebyid(int id){
        return  medicineRepo.findById(id).get();
    }

    //save medicine to the database

    public void saveMedicine(Medicine medicine){
        medicineRepo.save(medicine);
    }

    //delete medicine by id

    public void deleteById(int id){
        medicineRepo.deleteById(id);
    }
    //existby Medicine name
    public Boolean existByMedicineName(String medicinename){
        return medicineRepo.existsByMedicineName(medicinename);
    }

}
