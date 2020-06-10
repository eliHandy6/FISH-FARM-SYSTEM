package com.example.fishFarm.repositories;

import com.example.fishFarm.models.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser,Integer> {


   // public  SystemUser findByEmail(String email);


}
