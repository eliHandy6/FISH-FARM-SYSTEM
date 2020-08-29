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

    public Boolean existbyId(int id){
        return medicineRepo.existsById(id);
    }

    //save medicine to the database

    public void saveMedicine(Medicine medicine){

        if(existbyId(medicine.getNumber())){
            Medicine medicine1= getmedicinebyid(medicine.getNumber());
            String created=medicine1.getCreatedAt();
            medicine.setCreatedAt(created);
            medicineRepo.save(medicine);

        }else{
            medicineRepo.save(medicine);
        }

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
