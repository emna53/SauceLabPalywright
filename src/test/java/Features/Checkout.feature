Feature: checkout des produits
  Background: Achat de produit
    Given l utilisateur dans la page home
    When il ajaute un produit au panier
    And il ajoute un deuxieme produit
    And il clique sur le panier
    And il clique sur le bouton checout

    Scenario:chekout avec des donnes valides
      When l utilisateur saisit le firstname "emna"
      And lutilisateur saisit le lastname "lih"
      And l ulitisateur saisit le postalcode "77680"
      And il clique sur le bouton continue
      And il clique sur le bouton finish
      Then  message de confirmation s affiche
  Scenario Outline: chekout avec des donnes invalides
    When l utilisateur saisit le firstname "<firstname>"
    And lutilisateur saisit le lastname "<lastname>"
    And l ulitisateur saisit le postalcode "<postalecode>"
    And il clique sur le bouton continue
    Then le message d erreur s affiche "<messagederreur>"

    Examples:
      |firstname | lastname | postalecode|messagederreur|
      |   |liheouel|77896|Error: First Name is required |
      |  emna ||77896|Error: Last Name is required|
      |  emna |liheouel||Error: Postal Code is required|
      |   |||Error: First Name is required|

  Scenario: verification prix total
    When l utilisateur saisit le firstname "emna"
    And lutilisateur saisit le lastname "lih"
    And l ulitisateur saisit le postalcode "77680"
    And il clique sur le bouton continue
    Then le prix total doit etre correct

