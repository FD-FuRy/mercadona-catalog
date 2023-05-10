package com.mercadona.catalog.services;

import com.mercadona.catalog.dataTransferObject.RegisterUserDto;
import com.mercadona.catalog.pojo.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long userId);

    User getUserByName(String userName);

    User getUserByEmail(String email);

    void deleteUser(Long userId);

    void createUser(RegisterUserDto registerUserDto);

}
