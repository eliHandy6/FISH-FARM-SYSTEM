package com.example.fishFarm.services;

import java.util.List;

import com.example.fishFarm.models.Feed;
import com.example.fishFarm.repositories.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service

public class FeedService {
	
	@Autowired 
	
	private FeedRepository feedRepo;
	
	public List<Feed> findAllFeeds(){
		return feedRepo.findAll();
	}
	
	public void saveFeed(Feed feed) {
		feedRepo.save(feed);
	}
	

	public Feed FeedTypeById(int id)
	{
		return feedRepo.findById(id).get();
	}
	
	public void deleteFeed(int id) {
		
		feedRepo.deleteById(id);
		
	}
	
	public int countNumberFeeds(){
		return (int) feedRepo.count();
		
	}

	public Boolean findbynameorid(String id,String name){
		return feedRepo.existsByFeedNameOrId(id,name);
	}

	public  Boolean findbyFeedname(String feedname){
		return feedRepo.existsByFeedName(feedname);

	}

	public Boolean findbyId(int id){
		return feedRepo.existsById(id);
	}


}
