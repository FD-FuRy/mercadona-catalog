// au chargement du doc, fonction de gestion de l'affichage des produits suivant la catégorie sélectionnée:
document.addEventListener('DOMContentLoaded', function () {
    // initialisation de la variable qui stocke la valeur du select catégories (0 pour "toutes les catégories")
    let categorySelect = 0;
    // déclaration/initialisation d'une nouvelle requête XMLHHTP
    const categoryHttpRequest = new XMLHttpRequest();
    // fonction qui gère la requête Http GET pour afficher les produits dans le html
    function displayProductsByCategory() {
        categoryHttpRequest.open("GET","/get/"+categorySelect);
        categoryHttpRequest.send();
        categoryHttpRequest.onload=()=>{
            if (categoryHttpRequest.status === 200 && categoryHttpRequest.readyState === 4){
                document.getElementById('getProductsComponent').innerHTML = categoryHttpRequest.response;
            } else return null;
        }
    }
    // sélection du champ du formulaire html select (de choix de catégorie)
    const selectCategory = document.getElementById('categorySelector');
    // appel de la fonction GET pour afficher les produits (par défaut: toutes les catégories)
    displayProductsByCategory();
    // pose d'un écouteur de changement de la valeur sur ce select
    selectCategory.addEventListener('change', function() {
        // au changement de valeur, on stocke l'ID de la catégorie choisie dans categorySelect
        categorySelect = selectCategory.value;
        // appel de la fonction GET pour afficher les produits (de la catégorie choisie)
        displayProductsByCategory();
    })
});