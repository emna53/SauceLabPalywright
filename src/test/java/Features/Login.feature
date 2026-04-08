Feature: Verification de connection
  Background: Connection avec des donnes valides
    Given l utilisateur dans la page login
    When il saisit le nom d utilisateur "standard_user"
    And  il saisit le mot de passe "secret_sauce"
    And il clique sur le bouton connexion
    Then il est rediige vers la page home

    Scenario Outline: Tentative de connexion avec des donnes invalides
      Given l utilisateur dans la page login
      When il saisit le nom d utilisateur "<username>"
      And  il saisit le mot de passe "<passeword>"
      And il clique sur le bouton connexion
      Then un message d'erreur est affiché "<messageerreur>"
      Examples:
        | username | passeword | messageerreur |
        | standard_user| 12345| Epic sadface: Username and password do not match any user in this service |
        | emna | secret_sauce | Epic sadface: Username and password do not match any user in this service |
        |  | secret_sauce | Epic sadface: Username is required|
        | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
@logout
Scenario: deconnexion au site saucelab
When l utilisateur clique sur le menu
  And il clique sur logout
  Then il est redirige vers la page login