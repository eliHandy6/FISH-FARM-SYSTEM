package com.example.fishFarm.repositories;

import com.example.fishFarm.models.Pond;
import com.example.fishFarm.models.SeedStock;
import com.example.fishFarm.models.VarietyStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SeedingRepository extends JpaRepository<SeedStock,Integer> {

   boolean existsByPondAndVariety(Pond pondid, VarietyStock varietyID);



   @Query(value = "SELECT COUNT(*) from seed_stock where  status=1 and pond_id=?1",nativeQuery = true)
   int countTrue(int pondNumber);


  @Query(value = "SELECT COUNT(*) from seed_stock where status=0 and pond_id=?1",nativeQuery = true)
  int countFalse(int pondNumber);
}
