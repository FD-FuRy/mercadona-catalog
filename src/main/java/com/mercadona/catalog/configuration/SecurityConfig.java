package com.mercadona.catalog.configuration;

import com.mercadona.catalog.repository.UserRoleRepository;
import com.mercadona.catalog.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private CustomUserDetailsService customUserDetailsService;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService,
                          UserRoleRepository userRoleRepository) {
        this.customUserDetailsService = customUserDetailsService;
        this.userRoleRepository = userRoleRepository;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                        .requestMatchers("/admin/**", "/api/product/**", "/api/category/**", "/api/promotion/**").hasAuthority("ADMIN")
                        .requestMatchers("/swagger-ui/**", "/api-mercadona_docs/**", "/swagger.html", "/v3/api-docs/**").authenticated()
                        .requestMatchers("/", "/get/**", "/register", "/register**", "/login", "/api/user/**", "/pictures/**", "/scripts/**", "/styles/**", "/error/**").permitAll()
                .and()
                .formLogin(
                        form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/?connexion_success")
                        .loginProcessingUrl("/login")
                        .failureUrl("/login?error")
                        .permitAll()
                )
                .logout(
                        logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/?disconnected")
                        .permitAll()
                );
        return http.build();
    }

    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }




}
