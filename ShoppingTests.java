package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class ShoppingTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    String username = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    int expectedNumber = 6;
    


@Test
public void  numberOfItems(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.Page();
    loginPage.login(username, password);
    homePage.succesfulLogin(homePageTitle);
    homePage.numberProducts(expectedNumber);
   
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifySuccesfulProductsAddToCart(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.Page();
    loginPage.login(username, password);
    homePage.succesfulLogin(homePageTitle);
    homePage.verifyProductsAddedToCart();

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

    
}
