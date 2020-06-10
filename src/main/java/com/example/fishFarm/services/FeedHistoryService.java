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
	
	public void saveFeedHistory(FeedHistory feedHistory) {
		
//		Feed feedUsed=feedService.FeedTypeById(feedHistory.getFeed().getId());
//
//		feedHistory.setFeed(feedUsed);
//		feedUsed.setFeedQuality(feedUsed.getFeedQuality()-feedHistory.getQuanity());
//		feedHistoryRepo.save(feedHistory);
//		feedService.saveFeed(feedUsed);
		
		
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
	

}
