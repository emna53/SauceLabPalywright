Feature: Achat produit
  Scenario: ajouter des produits au panier avec succee
    Given l utilisateur dans la page home
    When il ajaute un produit au panier
    And  il clique sur le panier
    Then le produit est ajoute avec succe au panier

    Scenario: notification d ajout produit
      Given l utilisateur dans la page home
      When il ajaute un produit au panier
      Then notifcation s affiche sur le panier


      Scenario: Verifier l incrementation du panier
        Given l utilisateur dans la page home
        When il ajaute un produit au panier
        And il ajoute un deuxieme produit
        Then incrementation du panier
   Scenario: supprimer un produit de panier
   Given  l utilisateur dans la page home
   When il ajaute un produit au panier
   And il clique sur le panier
   And il clique sur le bouton remove
   Then le produit est supprime avec succe

     Scenario: tester tri de produit Z to A
       Given l utilisateur dans la page home
       When il choisit Z to A
       Then  les produits sont filtres
