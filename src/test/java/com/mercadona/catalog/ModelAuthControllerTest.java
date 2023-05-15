package com.mercadona.catalog;

import com.mercadona.catalog.api.ModelAuthController;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ModelAuthControllerTest {

    @Mock
    private RegisterUserDtoTest registerUserDtoTest;

    @Mock
    private ModelAuthController modelController;

    @Autowired
    private ModelAuthController modelAuthController;

    //test de la vue chargée en retour à l'appel de la méthode getRegisterData() :
    @Test
    public void testGetRegisterData() {
        ModelAndView testModelAndView = modelAuthController.getRegisterData();
        assertEquals("pages/register.html", testModelAndView.getViewName() );
    }

    //test de la vue chargée en retour à l'appel de la méthode getRegisterData() :
    @Test
    public void testLoginPage() {
        String testModelAndView = modelAuthController.LoginPage();
        assertEquals("login", testModelAndView );
    }










}
