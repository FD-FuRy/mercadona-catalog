package com.mercadona.catalog.repository;

import com.mercadona.catalog.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRoleName(String roleName);
}
