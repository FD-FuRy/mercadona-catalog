// au chargement du doc, fonction de gestion de l'affichage des produits suivant la catégorie sélectionnée:
document.addEventListener('DOMContentLoaded', function () {
    // initialisation de la variable qui stocke la valeur du select catégories (0 pour "toutes les catégories")
    let adminCategorySelect = 0;
    // déclaration/initialisation d'une nouvelle requête XMLHTTP
    const adminCategoryHttpRequest = new XMLHttpRequest();
    // fonction qui gère la requête Http GET pour afficher les produits dans le html
    function displayAdminProductsByCategory() {
        adminCategoryHttpRequest.open("GET","/admin/product/get/"+adminCategorySelect);
        adminCategoryHttpRequest.send();
        adminCategoryHttpRequest.onload=()=>{
            if (adminCategoryHttpRequest.status === 200 && adminCategoryHttpRequest.readyState === 4){
                document.getElementById('getProductsAdminComponent').innerHTML = adminCategoryHttpRequest.response;
            } else return null;
        }
    }
    // sélection du champ du formulaire html select (de choix de catégorie)
    const adminSelectCategory = document.getElementById('adminCategorySelector');
    // appel de la fonction GET pour afficher les produits (par défaut: toutes les catégories)
    displayAdminProductsByCategory();
    // pose d'un écouteur de changement de la valeur sur ce select
    adminSelectCategory.addEventListener('change', function() {
        // au changement de valeur, on stocke l'ID de la catégorie choisie dans categorySelect
        adminCategorySelect = adminSelectCategory.value;
        // appel de la fonction GET pour afficher les produits (de la catégorie choisie)
        displayAdminProductsByCategory();
    })
    return adminCategorySelect;
});