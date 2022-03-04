package com.targsoft.employeeapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String username;
    private final String password;
    private final String role;

    public SecurityConfig(final @Value("${user.username}") String username,
                          final @Value("${user.password}") String password,
                          final @Value("${user.role}") String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    protected void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                    .authorizeRequests().anyRequest().authenticated()
                    .and().httpBasic();
    }

    @Override
    public void configure(final AuthenticationManagerBuilder authentication) throws Exception {
        authentication.inMemoryAuthentication()
                      .withUser(username)
                      .password(passwordEncoder().encode(password))
                      .authorities(role);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
