package com.example.habrtest.pages;

import com.example.habrtest.AllureLogger;
import com.example.habrtest.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class FeedbackPage {
    WebDriver driver;
    Actions action = new Actions(BaseTest.getDriver());
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(FeedbackPage.class));
    public FeedbackPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Техническая поддержка')]")
    private WebElement mainTitle;
    @FindBy(css = "button[class='tm-form__submit base-button']")
    private WebElement submitButton;

    public boolean isMainTitkeEnabled(){
        return mainTitle.isEnabled();
    }
    public boolean isSubmitButtonEnabled(){
        return submitButton.isEnabled();
    }
}
