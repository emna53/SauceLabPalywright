package Steps;

import Pages.LoginPage;
import Pages.ProduitPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;

public class PoduitStep {
    LoginPage loginPage =new LoginPage(Hook.page);
    ProduitPage produitPage= new ProduitPage(Hook.page);

    int compteuravant;
    @Given("l utilisateur dans la page home")
    public void l_utilisateur_dans_la_page_home() {
        Hook.page.navigate("https://www.saucedemo.com/");
        loginPage.enterusername("standard_user");
        loginPage.enterpassword("secret_sauce");
        loginPage.Clicklogin();
        compteuravant=produitPage.getnumberbadge();

    }
    @When("il ajaute un produit au panier")
    public void il_ajaute_un_produit_au_panier() {
        produitPage.addproduit();
    }
    @When("il clique sur le panier")
    public void il_clique_sur_le_panier() {
        produitPage.clickpanier();
    }
    @Then("le produit est ajoute avec succe au panier")
    public void le_produit_est_ajoute_avec_succe_au_panier() {
        produitPage.verfierajoutproduit();
    }

    @Then("notifcation s affiche sur le panier")
    public void notifcationSAfficheSurLePanier() {
      produitPage.verfiernotification();
    }

    @And("il ajoute un deuxieme produit")
    public void ilAjouteUnDeuxiemeProduit() {
produitPage.ajoutdeuximeproduit();
    }

   @Then("incrementation du panier")
 public void incrementationDuPanier() {
  int compteurapres=produitPage.getnumberbadge();   Assertions.assertEquals(compteuravant+2,compteurapres);
    }



    @And("il clique sur le bouton remove")
    public void ilCliqueSurLeBoutonRemove() {
        produitPage.supprimerproduit();
    }

    @Then("le produit est supprime avec succe")
    public void leProduitEstSupprimeAvecSucce() {
        produitPage.verifierproduitsupprimer();
    }

    @When("il choisit Z to A")
    public void ilChoisitZToA() {
        produitPage.filtre();
    }

    @Then("les produits sont filtres")
    public void lesProduitsSontFiltres() {
        produitPage.verfierfiltreZtoA();
    }


}
