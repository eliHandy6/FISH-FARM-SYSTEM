package com.example.fishFarm.services;

import java.util.List;

import com.example.fishFarm.models.DailyPondRecords;
import com.example.fishFarm.repositories.DailyPondRecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DailyPondRecordsService {
	
	@Autowired
	private DailyPondRecordsRepository dailyPondRecordsRepo;

	public List<DailyPondRecords> findDailyRecordsByStatus(){
		return dailyPondRecordsRepo.findByStatusOrderByIdAsc(true);

	}

	public List<DailyPondRecords> generatePhysioByPondNumber(int pondnumber){
		return dailyPondRecordsRepo.findByPondPondNumberAndStatus(pondnumber,true);

	}
	public List<DailyPondRecords> findAllDailyRecords(){
		return dailyPondRecordsRepo.findAll();
	}
	
	public void saveRecords(DailyPondRecords dailyPondRecords) {
		dailyPondRecordsRepo.save(dailyPondRecords);
	}
	
	
	public DailyPondRecords RecordById(Integer id) {
		return dailyPondRecordsRepo.findById(id).get();
	}
	
	public void deleteRecord(Integer id) {
		
		dailyPondRecordsRepo.deleteById(id);
		
	}
	
	public int countRecords(){
		return (int) dailyPondRecordsRepo.count();
		
	}
	
	

}
