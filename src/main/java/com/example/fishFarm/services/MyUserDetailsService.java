package com.example.fishFarm.services;

import com.example.fishFarm.models.SystemUser;
import  com.example.fishFarm.repositories.SystemUserRepository;

import com.example.fishFarm.models.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    SystemUserRepository systemUserRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Optional<SystemUser> systemUser= systemUserRepository.findByUsername(userName);

       systemUser.orElseThrow(()->new UsernameNotFoundException("Not Found: "+userName));
       return  systemUser.map(MyUserDetails::new).get();

    }
}
