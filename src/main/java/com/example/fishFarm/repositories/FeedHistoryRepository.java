package com.example.fishFarm.repositories;

import com.example.fishFarm.models.FeedHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FeedHistoryRepository extends JpaRepository<FeedHistory, Integer>{

}
