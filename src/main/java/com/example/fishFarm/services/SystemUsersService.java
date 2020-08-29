package com.example.fishFarm.services;

import com.example.fishFarm.models.SystemUser;
import com.example.fishFarm.repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUsersService {

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<SystemUser> findAllSystemUsers(){
        return systemUserRepository.findAll();
    }

    public SystemUser findById(int id){
        return systemUserRepository.findById(id).get();
    }

    public void SaveUser( SystemUser systemUser){

        String encodedPass=bCryptPasswordEncoder.encode(systemUser.getPassword());
        systemUser.setPassword(bCryptPasswordEncoder.encode(systemUser.getPassword()));
        systemUserRepository.save(systemUser);
    }

    public  boolean exixtbyUname(String uname){
       return systemUserRepository.existsByUsername(uname);
    }



}
