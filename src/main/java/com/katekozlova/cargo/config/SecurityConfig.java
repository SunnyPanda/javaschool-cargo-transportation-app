package com.katekozlova.cargo.config;

import com.katekozlova.cargo.security.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AppUserDetailsService appUserDetailsService;

    @Autowired
    public SecurityConfig(AppUserDetailsService appUserDetailsService) {
        this.appUserDetailsService = appUserDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(appUserDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
//        System.out.println("user|" + new BCryptPasswordEncoder(11).encode("user"));
//        System.out.println("driver|" + new BCryptPasswordEncoder(11).encode("driver"));
        return new BCryptPasswordEncoder(11);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/**", "/static/**");
    }
}
