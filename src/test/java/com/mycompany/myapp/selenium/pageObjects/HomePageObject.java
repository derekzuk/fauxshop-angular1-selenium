package com.mycompany.myapp.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObject {

    private WebDriver driver;
    private static WebElement element;

    private static By mainnav = By.id("main-nav");
    private static By login = By.id("login");

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement mainnav(WebDriver driver){
        element = driver.findElement(mainnav);
        return element;
    }

    public WebElement login(WebDriver driver){
        element = driver.findElement(login);
        return element;
    }

    public boolean verifyMainnav() {
        String pageTitle = "STELLA SHOP";
        return mainnav(driver).getText().contains(pageTitle);
    }

}
