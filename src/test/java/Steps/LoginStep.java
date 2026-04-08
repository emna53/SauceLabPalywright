package Steps;

import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;


public class LoginStep {
LoginPage loginPage= new LoginPage(Hook.page);



    @Given("l utilisateur dans la page login")
    public void l_utilisateur_dans_la_page_login() {
Hook.page.navigate("https://www.saucedemo.com/");
    }
    @When("il saisit le nom d utilisateur {string}")
    public void il_saisit_le_nom_d_utilisateur(String username) {
        loginPage.enterusername(username);
    }
    @When("il saisit le mot de passe {string}")
    public void il_saisit_le_mot_de_passe(String passeword) {
        loginPage.enterpassword(passeword);
    }
    @When("il clique sur le bouton connexion")
    public void il_clique_sur_le_bouton_connexion() {
        loginPage.Clicklogin();
    }
    @Then("il est rediige vers la page home")
    public void il_est_rediige_vers_la_page_home() {
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",Hook.page.url());
    }


    @Then("un message d'erreur est affiché {string}")
    public void unMessageDErreurEstAffiché(String expectedmessage) {
        Assertions.assertEquals(expectedmessage,loginPage.getmessageerreur());
    }
    @When("l utilisateur clique sur le menu")
    public void l_utilisateur_clique_sur_le_menu() {
        loginPage.clickmenu();
    }
    @When("il clique sur logout")
    public void il_clique_sur_logout() {
       loginPage.clicklogout();
    }
    @Then("il est redirige vers la page login")
    public void il_est_redirige_vers_la_page_login() {
    Assertions.assertEquals("https://www.saucedemo.com/",Hook.page.url());
    }
}

