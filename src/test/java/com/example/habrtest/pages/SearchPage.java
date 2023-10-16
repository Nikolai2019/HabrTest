package com.example.habrtest.pages;
//url = https://habr.com/ru/search/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "h2[class='tm-block__title tm-block__title']")
    private WebElement minutesWaitingBlock;

    public boolean isMinutesWaitingBlockEnabled(){
        return minutesWaitingBlock.isEnabled();
    }
}
