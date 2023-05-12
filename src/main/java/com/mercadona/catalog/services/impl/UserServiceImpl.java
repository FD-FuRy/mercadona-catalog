package com.mercadona.catalog.services.impl;

import com.mercadona.catalog.dataTransferObject.RegisterUserDto;
import com.mercadona.catalog.pojo.Users;
import com.mercadona.catalog.pojo.UserRole;
import com.mercadona.catalog.repository.UserRepository;
import com.mercadona.catalog.repository.UserRoleRepository;
import com.mercadona.catalog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    };

    @Override
    public Users getUserById(Long userId) {
        Optional<Users> userByIdOptional = userRepository.findById(userId);
        return  userByIdOptional.orElse(null);
    };

    @Override
    public Users getUserByName(String userName) {
        Optional<Users> userByNameOptional =  userRepository.findByUserName(userName);
        return userByNameOptional.orElse(null);
    };

    @Override
    public Users getUserByEmail(String email) {
        Optional<Users> userByEmailOptional =  userRepository.findByEmail(email);
        return userByEmailOptional.orElse(null);
    };

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    };

    @Override
    public void createUser(RegisterUserDto registerUserDto) {
        Users users = new Users();
        users.setUserName(registerUserDto.getUserName());
        users.setEmail(registerUserDto.getEmail());
        users.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        UserRole role = userRoleRepository.findByRoleName("USER");
        users.setRoles(Arrays.asList(role));
        userRepository.save(users);
    }

}
