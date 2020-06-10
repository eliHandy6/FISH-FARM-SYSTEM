package com.example.fishFarm.repositories;

import com.example.fishFarm.models.PondOwnership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PondOwnershipRepository extends JpaRepository<PondOwnership, Integer> {

}
