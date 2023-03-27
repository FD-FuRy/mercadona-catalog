package com.mercadona.catalog.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// Fichier de configuration de Spring  (pour SpringFox Swagger)
@Configuration
public class SpringFoxConfig {
    // Création d'un Docket pour la documentation de l'application via Swagger2
    // Configuration du Bean et sélection de tous (any) les web services dans la doc
    // Donc création d'un design pathern (background de builder)
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}