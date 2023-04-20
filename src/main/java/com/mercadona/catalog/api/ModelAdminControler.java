package com.mercadona.catalog.api;

import com.mercadona.catalog.services.ProductCategoryService;
import com.mercadona.catalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/")
public class ModelAdminControler {

    // MAP du ModelAndView de la page d'accueil du panneau administrateur:
    @GetMapping
    public ModelAndView getAdminPage() {
        ModelAndView getAdminLandingPage = new ModelAndView();
        getAdminLandingPage.setViewName("pages/admin.html");
        return getAdminLandingPage;
    }

}
