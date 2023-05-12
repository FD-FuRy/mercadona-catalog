package com.mercadona.catalog.security;

import com.mercadona.catalog.pojo.Users;
import com.mercadona.catalog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findFirstByUserName(username);
        if (users != null) {
            User authUser = new User(
                   users.getEmail(),
                   users.getPassword(),
                   users.getRoles().stream().map((roles) -> new SimpleGrantedAuthority(roles.getRoleName()))
                           .collect(Collectors.toList())
            );
            return authUser;
        }   else {
            throw new UsernameNotFoundException("Nom ou Password invalide!");
        }
    }
}
