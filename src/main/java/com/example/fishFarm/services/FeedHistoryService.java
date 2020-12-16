package com.example.fishFarm.services;

import java.util.List;

import com.example.fishFarm.models.Feed;
import com.example.fishFarm.models.FeedHistory;
import com.example.fishFarm.repositories.FeedHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class FeedHistoryService {
	
	@Autowired
	private FeedHistoryRepository feedHistoryRepo;
	@Autowired
	private FeedService feedService;
	
	
	public List<FeedHistory> findAllFeedHistory(){
		return feedHistoryRepo.findAll();
	}

	public List<FeedHistory> generatePondFeedingHistory(int pondnumber){
		return feedHistoryRepo.findByPondPondNumberAndStatus(pondnumber,true);
	}
	
	public void saveFeedHistory(FeedHistory feedHistory) {
		feedHistoryRepo.save(feedHistory);
	}
	
	
	public FeedHistory FeedHistoryTypeById(Integer id) {
		return feedHistoryRepo.findById(id).get();
	}
	
	public void deleteFeedHistory(Integer id) {
		
		feedHistoryRepo.deleteById(id);
		
	}
	
	public int countNumberFeedHistory(){
		return (int) feedHistoryRepo.count();
		
	}

	public List<FeedHistory> findAllbyStatus(){
		return feedHistoryRepo.findByStatusOrderByIdDesc(true);
	}
	

}
