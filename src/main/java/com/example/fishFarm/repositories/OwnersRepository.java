package com.example.fishFarm.repositories;

import com.example.fishFarm.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OwnersRepository extends JpaRepository<Owner, Integer> {

    Boolean existsByIdNo(int id);

    Boolean existsByEmail(String email);

    Boolean existsByPhoneno(String phoneno);

    Boolean existsByEmailOrPhoneno(String email,String phoneno);

    Boolean existsByFnameAndLname(String fname,String lname);


}
