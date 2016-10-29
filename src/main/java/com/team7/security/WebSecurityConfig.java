package com.team7.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

/**
 * Created by sd95 on 10/28/16.
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/",			// allow root to load index.html and start AngularJS app
                        "/app/**",   	// allow access to Single Page Application
                        "/images/**",   // allow Images
                        "/css/**",      // allow CSS
                        "/fonts/**",    // allow Fonts
                        "/test"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                .and()
                    .csrf()
                    .disable();

    }
}
