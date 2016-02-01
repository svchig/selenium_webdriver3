package com.epam.webdriver.task3.tests;

import com.epam.webdriver.task3.pages.HomePage;
import com.epam.webdriver.task3.pages.ProductListPage;
import com.epam.webdriver.task3.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Siarhei_Chyhir on 1/14/2016.
 */
public class ActionTest {

    String locale = "Русский";
    String productName = "knives";

    private Steps steps;
    public static final String  USERNAME = "siarhei_chyhir@epam.com";
    public static final String PASSWORD = "Sergh13";

    private WebDriver driver;

    @BeforeMethod(description = "WebDriver init")
    public void prepare(){

        steps = new Steps();
        steps.initBrowser();
    }

    @Test(enabled = false)
    public void moveToSearchAndTypeProductTest(){
        HomePage homePage = steps.loginEBay(USERNAME, PASSWORD);
        Assert.assertTrue(homePage.getPageTitle().contains("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay")
                , "eBay page is not opened");
        Assert.assertTrue(homePage.getCurrentURL().contains("ebay.com"), "eBay home page is not opened");
        Assert.assertTrue(homePage.getAccountName().contains("Siarhei"), "User did not login on eBay");
        ProductListPage productListPage = homePage.typeProductNameInSearchBoxAndExecute(productName);
        productListPage.selectAcountControl();
        productListPage.signOutFromEBay();
    }

    @Test(enabled = false)
    public void clickAndHoldTest(){
        HomePage homePage = steps.loginEBay(USERNAME, PASSWORD);
        Assert.assertTrue(homePage.getPageTitle().contains("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay")
                , "eBay page is not opened");
        Assert.assertTrue(homePage.getCurrentURL().contains("ebay.com"), "eBay home page is not opened");
        Assert.assertTrue(homePage.getAccountName().contains("Siarhei"), "User did not login on eBay");
        homePage.selectLanguageMenuAndHold()
                .setLanguageSetting(locale)
                .selectAcountControl()
                .signOutFromEBay();
    }

    @Test(enabled = true)
    public void highlightBackGroundTest() throws IOException {
        HomePage homePage = steps.loginEBay(USERNAME, PASSWORD);
        Assert.assertTrue(homePage.getPageTitle().contains("Electronics, Cars, Fashion, Collectibles, Coupons and More | eBay")
                , "eBay page is not opened");
        Assert.assertTrue(homePage.getCurrentURL().contains("ebay.com"), "eBay home page is not opened");
        Assert.assertTrue(homePage.getAccountName().contains("Siarhei"), "User did not login on eBay");
        homePage.highlightLanguageMenu();
        homePage.selectAcountControl();
        homePage.signOutFromEBay();
    }

    @AfterMethod(description = "WebDriver clean up")
    public void cleanUp(){
        steps.closeDriver();
    }
}
