package com.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    //Create User - Ionut/dummy
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
        .withUser("Ionut").password("dummy").roles("USER", "ADMIN");
    }
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http
//          .csrf().disable()
//          .authorizeRequests()
//          .antMatchers("/admin/**").hasRole("ADMIN")
//          .antMatchers("/product*").hasRole("USER")
//          .antMatchers("/login*").permitAll()
//          .anyRequest().authenticated()
//          .and()
//          .formLogin()
//          .loginPage("/login.html")
//          .loginProcessingUrl("/perform_login")
//          .defaultSuccessUrl("/", true)
//          //.failureUrl("/login.html?error=true")
//          .and()
//          .logout()
//          .logoutUrl("/logout")
//          .deleteCookies("JSESSIONID");
//    
//    }
    @Bean
    public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
    		  .antMatchers("/login").permitAll()
              .antMatchers("/", "/*product*/**").access("hasRole('USER')")
    		  .and() // tot ce este pe product, este accesibil pe 'user'
              .formLogin();
    }
//        
//   //  /*product*/** orice url care contine product 
//    }
    
    // this is a dependecy 
    // authentication privider -- ii dai tu providerul 
    
}
