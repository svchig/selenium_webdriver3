package com.epam.webdriver.task3.tests;

import com.epam.webdriver.task3.pages.*;
import com.epam.webdriver.task3.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Siarhei_Chyhir on 1/4/2016.
 */
public class EBayTest {

    String productName = "knives";
    String locale;

    @Factory(dataProvider = "locales")
    public EBayTest(String locale){
        this.locale=locale;
    }

    @DataProvider(name ="locales", parallel = true)
    public Object[][] locales() {
        return new Object[][]{
                { "English" }, { "Русский" }
        };
    }

    private Steps steps;
    public static final String  USERNAME = "siarhei_chyhir@epam.com";
    public static final String PASSWORD = "Sergh13";

    private WebDriver driver;

    @BeforeMethod(description = "WebDriver init")
    public void prepare(){

        steps = new Steps();
        steps.initBrowser();
    }


    @Test(description = "eBay smoke test")
    public void eBaySmokeTest(){
        HomePage homePage = steps.loginEBay(USERNAME, PASSWORD);
        Assert.assertTrue(homePage.getPageTitle().contains("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay")
                , "eBay page is not opened");
        Assert.assertTrue(homePage.getCurrentURL().contains("ebay.com"), "eBay home page is not opened");
        Assert.assertTrue(homePage.getAccountName().contains("Siarhei"), "User did not login on eBay");
        homePage.selectLanguageMenuAndHold();
        homePage.setLanguageSetting(locale);

        ProductListPage productListPage = homePage.typeProductNameInSearchBoxAndExecute(productName);
        Assert.assertTrue(productListPage.getPageTitle().contains("knives")
                , "Search Result List with knives does not present on eBay");
        Assert.assertTrue(productListPage.searchProductsCount() > 0
                , "No products in Search Result List on eBay");

        ProductPage productPage = productListPage.selectProductFromList();
        Assert.assertTrue(productPage.getPageTitle().toUpperCase().contains("TAC FORCE ")
                , "The product page is not opened");

        CartPage cartPage = productPage.addProductToCart();
        Assert.assertTrue(cartPage.getCurrentURL().contains("cart.payments.ebay.com")
                , "The shopping cart page is not opened");


        cartPage.removeProductFromCart();
        cartPage.selectAccountControl();

        StartPage startPage = cartPage.signOutFromEBay();
        System.out.println(startPage.getPageTitle());
        Assert.assertTrue(startPage.getCurrentURL().contains("signin.ebay"), "Sighin eBay page is not opened");

    }

    @AfterMethod(description = "WebDriver clean up")
    public void cleanUp(){
        steps.closeDriver();
    }

}
