package com.epam.webdriver.task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by _Chyhir on 1/11/2016.
 */
public class CartPage extends Page{

    @FindBy(xpath= "//i[@id='gh-cart-i']")
    private WebElement buttonCartNavigation;

    @FindBy(xpath= "//a[@class='action actionLink'][@aria-label='Remove']")
    private WebElement buttonCartRemoveEng;

    @FindBy(xpath= "//a[@class='action actionLink'][@aria-label='Удалить']")
    private WebElement buttonCartRemoveRu;

    @FindBy(xpath= "//i[@id='gh-cart-n']")
    private List<WebElement> allProductsInCart;

    @FindBy(xpath= "//a[@id='gh-ug'][@class='gh-ua gh-control'][@role='button']")
    private WebElement buttonAccountControl;

    @FindBy(xpath= "//li[@id='gh-uo']/a[contains(@href,'signin.ebay.com')]")
    private WebElement linkAccountSignOut;


    public CartPage(WebDriver driver){
        super(driver);//this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public int getProductCount(){
        return allProductsInCart.size();
    }

    public CartPage navigateToCart(){
        buttonCartNavigation.click();
        return new CartPage(getDriver());
    }

    public void removeProductFromCart(){
        if (isElementPresent(By.xpath("//a[@class='action actionLink'][@aria-label='Remove']")))
            buttonCartRemoveEng.click();
        else if(isElementPresent(By.xpath("//a[@class='action actionLink'][@aria-label='Удалить']")))
            buttonCartRemoveRu.click();
    }

    public CartPage selectAccountControl(){
        buttonAccountControl.click();
        return new CartPage(getDriver());
    }

    public StartPage signOutFromEBay(){
        linkAccountSignOut.click();
        return new StartPage(getDriver());
    }
}
