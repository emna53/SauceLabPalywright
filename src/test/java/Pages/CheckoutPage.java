package Pages;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Assertions;


import java.util.List;

public class CheckoutPage {


    Page page ;
    String buttoncheckout="#checkout";
    String Firstnameinput="#first-name";
    String Lastnameinput="#last-name";
    String postalcodeinput="#postal-code";
    String buttoncontinue="#continue";
    String buttonfinish="#finish";
    String message="#checkout_complete_container > h2";
    String messageerreur="#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3";
    String iteamprice="#checkout_summary_container > div > div.summary_info > div.summary_subtotal_label";
    String Taxe="#checkout_summary_container > div > div.summary_info > div.summary_tax_label";
    String Totalprice="#checkout_summary_container > div > div.summary_info > div.summary_total_label";
    String Prix=".inventory_item_price";
    public CheckoutPage(Page page){
            this.page=page;
        }




    public void  cliccheckout (){
     page.click(buttoncheckout);
}
    public void enterfirstname(String firstname){
    page.fill(Firstnameinput,firstname);
    }
    public void enterlastname(String lastname){
        page.fill(Lastnameinput,lastname);
    }
public void enterpostalcode(String postalcode){
        page.fill(postalcodeinput,postalcode);
}
public void clickcontunue(){
        page.click(buttoncontinue);
}

public void clickfinish(){
        page.click(buttonfinish);
}
    public String  getmessageconfiramtion() {
        return page.textContent(message);

    }
public String Failedmessage(){
        return page.textContent(messageerreur);
}

    public void verifcalcultotal(){

        List<String>prices=page.locator(Prix).allTextContents();
        double somme=prices.stream().mapToDouble(p->Double.parseDouble(p.replace("$","" ))).sum();

        double suptotal=Double.parseDouble(page.textContent(iteamprice).replace("Item total: $",""));
        double tax=Double.parseDouble(page.textContent(Taxe).replace("Tax: $",""));
        double total=Double.parseDouble(page.textContent(Totalprice).replace("Total: $",""));
        Assertions.assertEquals(somme,suptotal,"erreursuptotal");
        Assertions.assertEquals((suptotal+tax),total,"erreurtotal");
    }



        }



