package com.example.fishFarm.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    /**
     *
     */
    @Qualifier("myUserDetailsService")
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()


                .antMatchers("/pond/**").access("hasRole('manager')")
                .antMatchers("/feeds/**").hasRole("manager")
                .antMatchers("/pondtype/**").hasRole("manager")
                .antMatchers("/species/**").hasRole("manager")
                .antMatchers("/managerVariety/**").hasRole("manager")


                .antMatchers("/inventoryManager/**").hasRole("inventory")
                .antMatchers("/inventoryManagerVariety/**").hasRole("inventory")
                .antMatchers("/inventoryManagerMedicines/**").hasRole("inventory")

                .antMatchers("/").permitAll()


                .and().formLogin()
                .loginPage("/login").permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
