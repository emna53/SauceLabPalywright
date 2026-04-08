package Steps;

import Pages.LoginPage;
import Utils.VisualValidation;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.jupiter.api.Assertions;

import java.nio.file.Paths;

public class VisualStep {

    Page page =Hook.page;


    LoginPage loginPage =new LoginPage(page);
    /*@Given("l utilisateur dans la page homee")

    public void l_utilisateur_dans_la_page_homee() {

        Hook.page.navigate("https://www.saucedemo.com/");
        loginPage.enterusername("standard_user");
        loginPage.enterpassword("secret_sauce");
        loginPage.Clicklogin();


    }*/






    @Then("icone de panier doit graphiquement conforme")
    public void iconedepanierdoitgraphiquementconforme() {
        String screenshotPath = "target/actual_cart.png";
        String referencePath = "src/test/resources/cart_icon_ref.png";

        // ✅ CORRECTION : On cible uniquement l'élément du panier
        // Cela va recadrer l'image automatiquement sur l'icône
        page.locator(".shopping_cart_link").screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get(screenshotPath)));

        // Comparaison avec OpenCV
        boolean isFound = VisualValidation.isElementPresent(screenshotPath, referencePath, 0.9);

        Assertions.assertTrue(isFound,"L'icône du panier est graphiquement différente !");

    }
}
