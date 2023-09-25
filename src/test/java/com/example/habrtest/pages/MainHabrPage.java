package com.example.habrtest.pages;

import com.example.habrtest.AllureLogger;
import com.example.habrtest.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

//url = https://www.habr.com/
public class MainHabrPage {
    WebDriver driver;
    Actions action = new Actions(BaseTest.getDriver());
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainHabrPage.class));
    public MainHabrPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = ("//*[contains(text(),'Техническая поддержка')]"))
    public WebElement supportButton;

    public void supportButtonClick(){
        supportButton.click();
        LOG.info("Нажали на кнопку \"Техническая поддержка\"");
    }
    public void scrollTo(WebElement scrollElement, int x, int y) {
        WheelInput.ScrollOrigin scroll = WheelInput.ScrollOrigin.fromElement(scrollElement);
        new Actions(driver).scrollFromOrigin(scroll, x, y).perform();
        LOG.infoWithScreenshot("Скролл до " + scrollElement.getText());
    }
}
