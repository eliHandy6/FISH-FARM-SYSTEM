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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


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

//manager
                .antMatchers("/pond/**").permitAll()
                .antMatchers("/feeds/**").permitAll()
                .antMatchers("/pondtype/**").permitAll()
                .antMatchers("/species/**").permitAll()
                .antMatchers("/ManagerVariety/**").permitAll()
                .antMatchers("/farmmanager/**").permitAll()
                .antMatchers("/admin/**").permitAll()


//operations
                .antMatchers("/inventoryManager/**").permitAll()
                .antMatchers("/inventoryManagerVariety/**").permitAll()
                .antMatchers("/inventoryManagerMedicines/**").permitAll()
                .antMatchers("/operationManager/**").permitAll()
                .antMatchers("/operation/**").permitAll()
                .antMatchers("/OperationalMaanager/**").permitAll()
                .antMatchers("/operationMana/**").permitAll()
                .antMatchers("/operationManag/**").hasRole("operations")
                .antMatchers("/farm/**").permitAll()

                .antMatchers("/**").permitAll()



                .and().formLogin()
                .loginPage("/login").permitAll()

                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
