package com.example.habrtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//url = https://habr.com/ru/feedback/
public class FeedbackPage {
    WebDriver driver;
    public FeedbackPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Техническая поддержка')]")
    private WebElement mainTitle;
    @FindBy(css = "button[class='tm-form__submit base-button']")
    private WebElement submitButton;

    public boolean isMainTitleEnabled(){
        return mainTitle.isEnabled();
    }
    public boolean isSubmitButtonEnabled(){
        return submitButton.isEnabled();
    }
}
