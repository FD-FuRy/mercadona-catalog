package com.mercadona.catalog;

import com.mercadona.catalog.dataTransferObject.RegisterUserDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RegisterUserDtoTest {

    //test de constructeur vide ( vérification de création d'objet "RegisterUserDto" (même si vide) ) :
    @Test
    public void testEmptyRegisterUserDtoConstructor() {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        assertNotNull(registerUserDto);
    }

    //test de constructeur complet ( vérification de création d'objet "RegisterUserDto" (avec ID et autres champs renseignés) ) :
    @Test
    public void testCompleteRegisterUserDtoConstructor() {
        RegisterUserDto registerUserDto = new RegisterUserDto(4L, "Nom Utilisateur test", "test@email.fr", "MDP_test");
        assertNotNull(registerUserDto);
    }

    //test des Setters et des Getters dans une construction d'objet "RegisterUSerDto" :
    @Test
    public void testRegisterUserDtoSettersAndGetters() {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        registerUserDto.setUserId(3L);
        registerUserDto.setUserName("Test Nom");
        registerUserDto.setEmail("test2@email.fr");
        registerUserDto.setPassword("Test_MDP");
        assertTrue( (registerUserDto.getUserId() == 3) && (registerUserDto.getUserName().equals("Test Nom")) && (registerUserDto.getEmail().equals("test2@email.fr")) && (registerUserDto.getPassword().equals("Test_MDP")) );
    }

}
