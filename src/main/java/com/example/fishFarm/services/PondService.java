package com.example.fishFarm.services;

import java.time.LocalDateTime;
import java.util.List;

import com.example.fishFarm.models.Pond;
import com.example.fishFarm.models.SeedStock;
import com.example.fishFarm.repositories.PondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PondService {

	LocalDateTime now = LocalDateTime.now();


	String todayTemp = now.toString().replace("T", " ");

	String dateTime = todayTemp.substring(0, 19);

	@Autowired
	private PondRepository pondRepo;

	public List<Pond> findAllPonds() {
		return pondRepo.findAll();
	}

	public List<Pond> getUnstockockedFishPond() {
		return pondRepo.findByStockingStatus(false);
	}

	public List<Pond> getStockedFishPond() {
		return pondRepo.findByStockingStatus(true);
	}


	public List<Pond> getUnfeedPonds() {
		return pondRepo.findByStockingStatusAndFeedingStatus(true, false);
	}

	public List<Pond> getPondsWithUnrecordedPhysio() {
		return pondRepo.findByStockingStatusAndParamStatus(true, false);
	}

	public List<Pond> getHealthyPonds() {
		return pondRepo.findByStockingStatusAndMedicationStatus(true, false);
	}

	public void savePond(Pond pond) {

		if (existbyId(pond.getId())) {

			Pond pond1 = findPondById(pond.getId());
			String created = pond1.getCreatedAt();

			pond.setCreatedAt(created);
			//pond.setUpdatedAt(dateTime);
			pondRepo.save(pond);

		} else {
			//pond.setCreatedAt(dateTime);
			//pond.setUpdatedAt(dateTime);
			pondRepo.save(pond);
		}

	}


	public Pond findPondById(Integer id) {
		return pondRepo.findById(id).get();
	}

	public void deletePond(Integer id) {
		pondRepo.deleteById(id);

	}

	public int countNumberofPonds() {
		return (int) pondRepo.count();

	}


	public Boolean existbyPondNumber(int id) {
		return pondRepo.existsByPondNumber(id);
	}

	public Boolean existbyId(int id) {
		return pondRepo.existsById(id);
	}


	public void changeFeedingStatus() {
		List<Pond> feedponds = pondRepo.findByFeedingStatus(true);

		if(feedponds.size()<1){

		}else{
			for (Pond pond : feedponds) {
				System.out.println("hello");
				pond.setFeedingStatus(false);
				savePond(pond);
			}

		}

	}

	public void changeParamStatus() {
		List<Pond> paramPonds = pondRepo.findByParamStatus(true);
		if(paramPonds.size()<1){

		}else{
			for (Pond pond : paramPonds) {
				pond.setParamStatus(false);
				savePond(pond);
			}

		}

	}

	public void changeMedicationStatus() {
		List<Pond> medicinePond = pondRepo.findByMedicationStatus(true);
		if(medicinePond.size()<1){

		}
		else{
			for (Pond pond : medicinePond) {
				pond.setMedicationStatus(false);
				savePond(pond);
			}

		}

	}
}
