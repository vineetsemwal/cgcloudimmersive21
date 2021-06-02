package com.cg.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
         http.csrf().disable().httpBasic()
                .and()
                 .authorizeRequests()
                 .antMatchers("/p/**").permitAll()
                 .antMatchers("/").permitAll()
                 .antMatchers("/c/**").hasAnyRole("CUSTOMER", "ADMIN")
                 .antMatchers("/a/**").hasAnyRole("ADMIN")
                 .and()
                 .formLogin().permitAll().defaultSuccessUrl("/success")
                 .and()
                 .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                 .and()
                 .logout().clearAuthentication(true).deleteCookies("JSESSIONID")
                 .invalidateHttpSession(true);



    }




    @Bean
    PasswordEncoder encoder(){
        PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
        return encoder;
    }

}
