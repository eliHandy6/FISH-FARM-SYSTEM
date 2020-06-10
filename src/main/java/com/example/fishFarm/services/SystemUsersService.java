package com.example.fishFarm.services;

import com.example.fishFarm.models.SystemUser;
import com.example.fishFarm.repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUsersService {

    @Autowired
    SystemUserRepository systemUserRepository;


    public List<SystemUser> findAllSystemUsers(){
        return systemUserRepository.findAll();
    }

    public SystemUser findById(int id){
        return systemUserRepository.findById(id).get();
    }

    public void SaveUser( SystemUser systemUser){
        systemUserRepository.save(systemUser);
    }

//    public SystemUser findByEmail(String email){
//       return systemUserRepository.findByEmail(email);
//    }

}
