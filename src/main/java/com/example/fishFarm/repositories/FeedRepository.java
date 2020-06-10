package com.example.fishFarm.repositories;

import com.example.fishFarm.models.Feed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FeedRepository extends JpaRepository<Feed, Integer> {

    Boolean existsByFeedNameOrId(String feedname, String id);


    Boolean existsByFeedName(String feedname);

    Boolean existsById(String id);


     void deleteById(String id);
}
