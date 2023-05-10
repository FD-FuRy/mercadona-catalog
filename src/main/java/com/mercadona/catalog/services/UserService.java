package com.mercadona.catalog.services;

import com.mercadona.catalog.dataTransferObject.RegisterUserDto;
import com.mercadona.catalog.pojo.Users;

import java.util.List;

public interface UserService {

    List<Users> getAllUsers();

    Users getUserById(Long userId);

    Users getUserByName(String userName);

    Users getUserByEmail(String email);

    void deleteUser(Long userId);

    void createUser(RegisterUserDto registerUserDto);

}
