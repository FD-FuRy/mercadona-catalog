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
public class UsersTest {

    //test de constructeur vide ( vérification de création d'objet "Users" (même si vide) ) :
    @Test
    public void testEmptyUsersConstructor() {
        Users users = new Users();
        assertNotNull(users);
    }

    //test de constructeur intermédiaire de "Users" ( sans ID ) :
    @Test
    public void testNoEmptyUsersConstructor() {
        Users users = new Users("nom utilisateur test" , "email@test.fr", "password test", null);
        assertNotNull(users);
    }

    //test de constructeur complet de "Users" ( avec ID désigné ) :
    @Test
    public void testCompleteUsersConstructor() {
        List<UserRole> userRoles = new ArrayList<>();
        Users users = new Users(7L,"nom utilisateur test" , "email@test.fr", "password test", userRoles);
        assertNotNull(users);
    }

    //test des Setters et des Getters dans une construction d'objet "Users" :
    @Test
    public void testUsersSettersAndGetters() {
        Users users = new Users();
        UserRole userRole = new UserRole(6L, "Role Test", null);
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        users.setUserId(5L);
        users.setUserName("Nom utilisateur Test");
        users.setEmail("user-email@test.fr");
        users.setPassword("MDP_test");
        users.setRoles(userRoles);
        assertTrue( (users.getUserId() == 5) && (users.getUserName().equals("Nom utilisateur Test")) && (users.getEmail().equals("user-email@test.fr")) && (users.getPassword().equals("MDP_test")) && (users.getRoles() != null) );
    }


}
