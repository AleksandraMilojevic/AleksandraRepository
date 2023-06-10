package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    
    public HomePage (WebDriver driver){
        super(driver);
    }

    By homePageTitleBy = By.className("title");
    By numberItems = By.className("inventory_item");
    By menuButton = By.id("react-burger-menu-btn");
    By logoutButton = By.id("logout_sidebar_link");
    By addToCartButton1 = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton2 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By shoppingCartBadge = By.className("shopping_cart_badge");



    public HomePage succesfulLogin(String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }


    public HomePage numberProducts(int expectedNumber){
        int actualNumber = cItems(numberItems);
        assertItemsEquals(expectedNumber, actualNumber);
        return this;
    }

    public HomePage clickOnMenuButton(){
        click(menuButton);
        return this;
    }
    public HomePage clickOnLogoutButton(){
        click(logoutButton);
        return this;
    }

    public HomePage verifyProductsAddedToCart(){
        click(addToCartButton1);
        click(addToCartButton2);
        waitVisability(shoppingCartBadge);
        return this;
    }
    
}
