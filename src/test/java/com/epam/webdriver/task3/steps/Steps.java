package com.epam.webdriver.task3.steps;

import com.epam.webdriver.task3.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Siarhei_Chyhir on 1/14/2016.
 */
public class Steps {

    private WebDriver driver;

    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void closeDriver()
    {
        driver.quit();
    }

    public HomePage loginEBay(String username, String password)
    {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        LoginPage loginPage = startPage.singIn();
        HomePage homePage = loginPage.login(username, password);
        return homePage;
    }

    public ProductListPage searchProduct(String productName, HomePage homePage){
        ProductListPage productListPage = homePage.productSearch(productName);
        return productListPage;
    }

}
