package com.mercadona.catalog.api;


import com.mercadona.catalog.dataTransferObject.RegisterUserDto;
import com.mercadona.catalog.pojo.User;
import com.mercadona.catalog.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( ApiRegistration.REST_PREFIX + ApiRegistration.REST_USER )
public class UserWS {

    @Autowired  //Instanciation d'un Bean par Spring: appel des méthodes UserService avec autoconfiguration
    private UserService userService;

    @Operation(operationId = "createUser", summary = "createUser  ( Enregistrer un nouvel Utilisateur )")
    @PostMapping ("/post")
    public String createUser(@Valid @ModelAttribute("user")RegisterUserDto registerUserDto,
                             BindingResult result, Model model) {
        User existingUserEmail = userService.getUserByEmail(registerUserDto.getEmail());
        if (existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()) {
            return "redirect:/user/register?fail";
        }
        User existingUserName = userService.getUserByName(registerUserDto.getUserName());
        if (existingUserName != null && existingUserName.getUserName() != null && !existingUserName.getUserName().isEmpty()) {
            return "redirect:/user/register?fail";
        }
        if (result.hasErrors()) {
            model.addAttribute("user", registerUserDto);
            return "/user/register";
        }
        userService.createUser(registerUserDto);
        return "redirect:/";

    };


}
