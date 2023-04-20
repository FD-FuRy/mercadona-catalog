package com.mercadona.catalog.api;

//  Création des méthodes (énumération de variables à appeler ici) pour structurer l'application et faciliter la connexion api.
//  (appeler ces variables dans les web services évite aussi d'écrire en dur dans les appels).
//  Si plus tard, évolution de l'appli il y a, il suffira de modifier les variables seulement ici (et pas dans tous les sercices appelants).
public interface ApiRegistration {

    String REST_PREFIX = "/api/";

    String REST_PRODUCT = "product/";

    String REST_CATEGORY = "category/";

    String REST_PROMOTION = "promotion/";

}
