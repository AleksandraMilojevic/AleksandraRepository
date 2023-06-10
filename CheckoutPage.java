package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage (WebDriver driver){
        super(driver);
    }

    By addToCartButton1 = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton2 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By shoppingCartBadge = By.className("shopping_cart_badge");
    By cart = By.xpath("//*[@id='shopping_cart_container']/a");
    By checkout = By.id("checkout");
    By firstnameBy = By.id("first-name");
    By lastnameBy = By.id("last-name");
    By zipBy = By.id("postal-code");
    By continueBy = By.id("continue");
    By finishButton = By.xpath("//*[@id='finish']");
    By thankYouForYourOrder = By.className("complete-text");


    public CheckoutPage checkout(){
        click(addToCartButton1);
        click(addToCartButton2);
        waitVisability(shoppingCartBadge);
        click(cart);
        click(checkout);
        return this; 
    }

    public CheckoutPage personalInformation(String name, String lastName, String postalCode){
        writeText(firstnameBy, name);
        writeText(lastnameBy, lastName);
        writeText(zipBy, postalCode);
        click(continueBy);
        return this;
    }

    public boolean checkPrice(Integer total, Integer tax, Integer finalPrice ) {
        return total + tax == finalPrice;
    } 

    public CheckoutPage finish(){
        click(finishButton);
        waitVisability(thankYouForYourOrder);
        return this;
    }
}
