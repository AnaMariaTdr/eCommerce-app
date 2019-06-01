package com.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    //Create User - Ionut/dummy
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("Ionut").password("dummy")
            .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
            .antMatchers("/", "/*product*/**").access("hasRole('USER')").and() // tot ce este pe product, este accesibil pe 'user'
            .formLogin();
        
   //  /*product*/** orice url care confutine product 
    }
    
    // this is a dependecy 
    // authentication privider -- ii dai tu providerul 
    
}
