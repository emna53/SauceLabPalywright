package Pages;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProduitPage {
    Page page ;
    String produit="#item_4_title_link > div";
    String addtocart="#add-to-cart-sauce-labs-backpack";
    String panier="#shopping_cart_container > a";
    String Produitajoute="#item_4_title_link > div";
    String notificationicone="#shopping_cart_container > a > span";
    String addtocart2="#add-to-cart-sauce-labs-bike-light";
    String remove="#remove-sauce-labs-backpack";
    String productname="#item_4_title_link > div";
    String filtre="#header_container > div.header_secondary_container > div > span > select";
    String productnames="#item_4_title_link > div";



    public ProduitPage(Page page){
        this.page=page;
    }

public void addproduit(){
        page.click(addtocart);
}
public void clickpanier(){
        page.click(panier);
}
public void verfierajoutproduit(){
    //Assertions.assertEquals(page.textContent(produit),page.textContent(Produitajoute));
    Assertions.assertTrue(page.locator(Produitajoute).isVisible());
}
 public void ajoutdeuximeproduit(){
        page.click(addtocart2);
 }


public void verfiernotification(){
        Assertions.assertTrue(page.locator(notificationicone).isVisible());
}
 public int getnumberbadge() {

 if (page.locator(notificationicone).count()==0)
     return 0;
 return Integer.parseInt(page.textContent(notificationicone));
 }
 public void supprimerproduit(){
        page.click(remove);
 }
public void  verifierproduitsupprimer(){
        Assertions.assertEquals(0,page.locator(productname).count());
}
 public void filtre (){
        page.selectOption(filtre,"za");
 }
public void verfierfiltreZtoA(){
    List<String>actuelnames=page.locator(productnames).allTextContents();
    List<String>expectnames=new ArrayList<>(actuelnames);
    expectnames.sort(Collections.reverseOrder());
    Assertions.assertEquals(expectnames,actuelnames);
}
}
