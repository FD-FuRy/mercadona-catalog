package com.mercadona.catalog.services.impl;

import com.mercadona.catalog.dataTransferObject.RegisterUserDto;
import com.mercadona.catalog.pojo.User;
import com.mercadona.catalog.pojo.UserRole;
import com.mercadona.catalog.repository.UserRepository;
import com.mercadona.catalog.repository.UserRoleRepository;
import com.mercadona.catalog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    };

    @Override
    public User getUserById(Long userId) {
        Optional<User> userByIdOptional = userRepository.findById(userId);
        return  userByIdOptional.orElse(null);
    };

    @Override
    public User getUserByName(String userName) {
        Optional<User> userByNameOptional =  userRepository.findByUserName(userName);
        return userByNameOptional.orElse(null);
    };

    @Override
    public User getUserByEmail(String email) {
        Optional<User> userByEmailOptional =  userRepository.findByEmail(email);
        return userByEmailOptional.orElse(null);
    };

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    };

    @Override
    public void createUser(RegisterUserDto registerUserDto) {
        User user = new User();
        user.setUserName(registerUserDto.getUserName());
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(registerUserDto.getPassword());
        UserRole role = userRoleRepository.findByRoleName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

}
