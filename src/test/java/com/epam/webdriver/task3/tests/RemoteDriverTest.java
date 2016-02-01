package com.epam.webdriver.task3.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Siarhei_Chyhir on 1/20/2016.
 */
public class RemoteDriverTest {
    private final String SO = "http://ebay.com";
    private final String HUB = "http://epbybrew0172:4444/wd/hub";

    @Test(threadPoolSize = 2, invocationCount = 4, timeOut = 30 * 1000)
    public void oneCanExecuteRemoteTest() throws MalformedURLException
    {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("firefox");
        //dc.setPlatform(Platform.WINDOWS);

        WebDriver driver = new RemoteWebDriver(new URL(HUB), dc);

        driver.get(SO);
        driver.findElement(By.id("gh-btn")).click();

    }
}
