package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest  extends BaseTest{
    public LoginPage loginPage;
    public HomePage homePage;
    String username = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String lockedOutUser = "locked_out_user";
    String userError = "Epic sadface: Sorry, this user has been locked out.";
    String emptyPassword = "";
    String error =  "Epic sadface: Password is required";
    String emptyUsername = "";
    String container = "Epic sadface: Username is required";


    @Test
    public void succesfulLoginTC(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.Page();
        loginPage.login(username, password);
        homePage.succesfulLogin(homePageTitle);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void unsuccessfuLoginSuspendedUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Page();
        loginPage.login(lockedOutUser, password);
        loginPage.verifyUnsuccesfuLogin(userError);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void unsuccessfuLoginEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Page();
        loginPage.login(username, emptyPassword);
        loginPage.verifyUnsuccesfuLogin(error);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    @Test
    public void unsuccessfuLoginEmptyUsername(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.Page();
        loginPage.login(emptyUsername, password);
        loginPage.verifyUnsuccesfuLogin(container);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyLogout(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.Page();
        loginPage.login(username, password);
        homePage.succesfulLogin(homePageTitle);
        homePage.clickOnMenuButton();
        homePage.clickOnLogoutButton();
        loginPage.verifyLogout();
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }



}
