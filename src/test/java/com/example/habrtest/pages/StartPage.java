package com.example.habrtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//url = https://habr.com/ru/sandbox/start/
public class StartPage {
    WebDriver driver;
    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "h1[class='tm-section-name__text']")
    private WebElement h1Block;

    public boolean isH1BlockEnabled(){
        return h1Block.isEnabled();
    }
}
