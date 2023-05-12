package com.mercadona.catalog.repository;

import com.mercadona.catalog.pojo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    Optional<Users> findByUserName(String userName);

    Users findFirstByUserName(String username);
}
