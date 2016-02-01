package com.epam.webdriver.task3.core;

import org.openqa.selenium.WebDriver;

/**
 * Created by siarhei_chyhir on 2/1/2016.
 */
public abstract class WebDriverCreator {
    protected WebDriver driver;

    public abstract WebDriver factoryMethod();
}
