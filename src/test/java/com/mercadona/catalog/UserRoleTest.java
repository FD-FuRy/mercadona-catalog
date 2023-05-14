package com.mercadona.catalog;

import com.mercadona.catalog.pojo.UserRole;
import com.mercadona.catalog.pojo.Users;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRoleTest {

    //test de constructeur vide ( vérification de création d'objet "Role" (même si vide) ) :
    @Test
    public void testEmptyUserRoleConstructor() {
        UserRole userRole = new UserRole();
        assertNotNull(userRole);
    }

    //test de constructeur intermédiaire de "Role" ( sans ID ) :
    @Test
    public void testNoEmptyUserRoleConstructor() {
        UserRole userRole = new UserRole("Nom de Role Test", null);
        assertNotNull(userRole);
    }

    //test du constructeur complet de "Role" ( avec ID désigné ) :
    @Test
    public void testCompleteUserRoleConstructor() {
        UserRole userRole = new UserRole(5L, "Nom de Role Test", null);
        assertNotNull(userRole);
    }

    //test des Setters et des Getters dans une construction d'objet "Role" :
    @Test
    public void testUserRoleSettersAndgetters() {
        UserRole userRole = new UserRole();
        Users users = new Users("Nom Utilisateur", null, "MDP_de_test", null);
        List<Users> usersList = new ArrayList<>();
        usersList.add(users);
        userRole.setRoleId(4L);
        userRole.setRoleName("Nom de Role TEST");
        userRole.setUsers(usersList);
        assertTrue( (userRole.getRoleId() == 4) && (userRole.getRoleName().equals("Nom de Role TEST")) && (userRole.getUsers() != null) );

    }


}
