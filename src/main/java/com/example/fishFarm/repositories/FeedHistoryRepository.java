package com.example.fishFarm.repositories;

import com.example.fishFarm.models.FeedHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FeedHistoryRepository extends JpaRepository<FeedHistory, Integer>{



    List<FeedHistory> findByStatusOrderByIdDesc(boolean status);

    List<FeedHistory> findByPondPondNumberAndStatus(int number,boolean status);
}
