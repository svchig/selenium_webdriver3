package com.epam.webdriver.task3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Siarhei_Chyhir on 1/11/2016.
 */
public class ProductPage extends Page {

    @FindBy(xpath= "//a[@id='isCartBtn_btn'][@role='button']")
    private WebElement buttonCart;

    @FindBy(xpath= "//i[@id='gh-cart-i']")
    private WebElement buttonCartNavigation;

    @FindBy(xpath= "//span[@id='atcLnk']/a")
    private WebElement linkToCart;

    public ProductPage(WebDriver driver){
        super(driver);//this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }

    public CartPage addProductToCart(){
        if (isElementPresent(By.xpath("//a[@id='isCartBtn_btn'][@role='button']")))
            buttonCart.click();
        else if(isElementPresent(By.xpath("//span[@id='atcLnk']/a")))
            linkToCart.click();
        return new CartPage(getDriver());
    }

    public CartPage navigateToCart(){
        buttonCartNavigation.click();
        return new CartPage(getDriver());
    }
}
