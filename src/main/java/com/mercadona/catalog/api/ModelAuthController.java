package com.mercadona.catalog.api;

import com.mercadona.catalog.dataTransferObject.RegisterUserDto;
import com.mercadona.catalog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ModelAuthController {

    @Autowired
    private UserService userService;

    // Map du ModelAndView du Formulaire d'inscription d'utilisateur:
    @GetMapping("/register")
    public ModelAndView getRegisterData() {
        ModelAndView getRegisterInformations = new ModelAndView();
        RegisterUserDto registerInformations = new RegisterUserDto();
        getRegisterInformations.setViewName("pages/register.html");
        getRegisterInformations.addObject("user", registerInformations);
        return getRegisterInformations;
    }

    // Map de la page de Connexion  (générée et gérée par Spring: login.html)
    @GetMapping("/login")
    public String LoginPage() {
        return "login";
    }

}
