package com.example.fishFarm.repositories;

import com.example.fishFarm.models.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser,Integer> {



    Optional<SystemUser> findByUsername(String username);

     boolean existsByUsernameOrEmail(String username,String email);


}
