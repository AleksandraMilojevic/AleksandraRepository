package tests;

import org.junit.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutTest  extends BaseTest{
    
    public LoginPage loginPage;
    public HomePage homePage;
    public CheckoutPage checkoutPage;
    String username = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String name = "Aleksandra";
    String lastName = "Milojevic";
    String postalCode = "18000";
    Integer total = (int) 45.98;
    Integer tax = (int) 3.68;
    Integer finalPrice = (int) 49.66;



    @Test
public void totalPrice(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    loginPage.Page();
    loginPage.login(username, password);
    homePage.succesfulLogin(homePageTitle);
    checkoutPage.checkout();
    checkoutPage.personalInformation(name, lastName, postalCode);
    checkoutPage.checkPrice(total, tax, finalPrice);
    
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    }


    @Test
public void successfulThankYouForYourOrder(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    loginPage.Page();
    loginPage.login(username, password);
    homePage.succesfulLogin(homePageTitle);
    checkoutPage.checkout();
    checkoutPage.personalInformation(name, lastName, postalCode);
    checkoutPage.checkPrice(total, tax, finalPrice);
    checkoutPage.finish();
    
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    }
}
