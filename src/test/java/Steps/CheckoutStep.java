package Steps;

import Pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;


import static Steps.Hook.page;

public class CheckoutStep {
CheckoutPage checkoutPage=new CheckoutPage(page);


    @And("il clique sur le bouton checout")
    public void ilCliqueSurLeBoutonChecout() {
checkoutPage.cliccheckout();
    }
    @When("l utilisateur saisit le firstname {string}")
    public void l_utilisateur_saisit_le_firstname(String firstname) {
       checkoutPage.enterfirstname(firstname);
    }


    @And("lutilisateur saisit le lastname {string}")
    public void lutilisateurSaisitLeLastname(String lastname) {
       checkoutPage.enterlastname(lastname);
    }

    @When("l ulitisateur saisit le postalcode {string}")
    public void l_ulitisateur_saisit_le_postalcode(String postalcode) {
        checkoutPage.enterpostalcode(postalcode);
    }

    @When("il clique sur le bouton continue")
    public void il_clique_sur_le_bouton_continue() {
       checkoutPage.clickcontunue();
    }

    @When("il clique sur le bouton finish")
    public void il_clique_sur_le_bouton_finish() {
     checkoutPage.clickfinish();
    }

    @Then("message de confirmation s affiche")
    public void message_de_confirmation_s_affiche() {
      //checkoutPage.getmessageconfiramtion();

        Assertions.assertEquals("Thank you for your order!",checkoutPage.getmessageconfiramtion());
    }



    @Then("le message d erreur s affiche {string}")
    public void leMessageDErreurSAffiche(String expectedmessge) {
       Assertions.assertEquals(expectedmessge,checkoutPage.Failedmessage());
    }

    @Then("le prix total doit etre correct")
    public void lePrixTotalDoitEtreCorrect() {
        checkoutPage.verifcalcultotal();
    }
}
