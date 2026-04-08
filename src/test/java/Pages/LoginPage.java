package Pages;


import com.microsoft.playwright.Page;


public class LoginPage {
Page page;
String usernameinput ="#user-name";
String passewordinput="#password";
String loginbutton="#login-button";
String messageerreur="#login_button_container > div > form > div.error-message-container.error > h3";
String menu="#react-burger-menu-btn";
String logout="#logout_sidebar_link";




public  LoginPage(Page page){
    this.page =page;
}
public void enterusername(String username){
    page.fill(usernameinput,username);

}
public void enterpassword(String passeword){
    page.fill(passewordinput,passeword);
}
public void Clicklogin(){
    page.click(loginbutton);
}
public String  getmessageerreur(){
   return page.textContent(messageerreur);

}
public void clickmenu(){
page.click(menu);
}
public void clicklogout(){
    page.click(logout);
}


}


