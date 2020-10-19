package com.example.fishFarm.repositories;

import com.example.fishFarm.models.Pond;
import com.example.fishFarm.models.SeedStock;
import com.example.fishFarm.models.VarietyStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeedingRepository extends JpaRepository<SeedStock,Integer> {

    List<SeedStock> findByPondId(int id);

   boolean existsByPondAndVariety(Pond pondid, VarietyStock varietyID);



   @Query(value = "SELECT COUNT(*) from seed_stock where  status=1 and pond_id=?1",nativeQuery = true)
   int countTrue(int pondNumber);


//    @Query(value = "SELECT COUNT(*) from seed_stock where status=0 and pond_id=?1",nativeQuery = true)
  //  int countFalse(int pondNumber);


    @Query(value = "SELECT * from seed_stock where pond_id=?1",nativeQuery = true)
    List<SeedStock> existingPondSpecies(int pondID);

    @Query(value = "select count(*) from seed_stock where pond_id=?1",nativeQuery = true)
    int countpondSpecies(int pondID);

    @Query(value = "select * from seed_stock where status=0",nativeQuery = true)
    List<SeedStock> pending();


    @Query(value = "select * from seed_stock where status=1",nativeQuery = true)
    List<SeedStock> approved();

    @Query(value = "select * from seed_stock where rejected=1",nativeQuery = true)
    List<SeedStock> rejected();

}
