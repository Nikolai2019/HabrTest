package com.example.habrtest.pages;

import com.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

//url = https://www.habr.com/
public class MainHabrPage {
    WebDriver driver;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainHabrPage.class));

    public MainHabrPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ("//*[contains(text(),'Техническая поддержка')]"))
    public WebElement supportButton;
    @FindBy(css = "svg[class=\"tm-svg-img tm-header__icon\"]")
    private WebElement mainLogo;
    @FindBy(css = "svg[class='tm-svg-img tm-header__icon tm-header__icon_dropdown']")
    private WebElement openListButton;
    @FindBy(css = "div[class='tm-our-projects__label']")
    private WebElement allServicesHabrText;
    @FindBy(css = "a[class='tm-header__become-author-btn']")
    private WebElement howToBeAuthorButton;
    @FindBy(linkText = "Поиск")
    private WebElement searchButton;
    @FindBy(css = "svg[class='tm-svg-img icon_dropdown-arrow']")
    private WebElement allListButton;
    @FindBy(css = "svg[class='tm-svg-img icon_dropdown-arrow icon_dropdown-arrow-rotated']")
    private WebElement allList;
    @FindBy(css = "span[class='tm-svg-icon__wrapper tm-rss-button__icon']>svg>title")
    private WebElement rssTitle;
    @FindBy(css = "svg[class='tm-svg-img tm-pagination__arrow tm-pagination__arrow_prev']")
    private WebElement forwardButton;
    @FindBy(css = "svg[class='tm-svg-img tm-pagination__arrow tm-pagination__arrow_next']")
    private WebElement backButton;
    @FindBy(xpath = ("//*[contains(text(),'Лучшие блоги')]"))
    private WebElement bestBlocks;

    public void supportButtonClick() {
        supportButton.click();
        LOG.info("Нажали на кнопку \"Техническая поддержка\"");
    }

    public void scrollTo(WebElement scrollElement, int x, int y) {
        WheelInput.ScrollOrigin scroll = WheelInput.ScrollOrigin.fromElement(scrollElement);
        new Actions(driver).scrollFromOrigin(scroll, x, y).perform();
        LOG.infoWithScreenshot("Скролл до " + scrollElement.getText());
    }

    public void mainLogoClick() {
        mainLogo.click();
        LOG.info("Нажали на логотип");
    }

    //просто пусть будет
    public void switchToStoreTab(int num) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(num - 1));
        LOG.infoWithScreenshot("Перешли на вкладку №" + (num));
    }
    public void openListButtonClick(){
        openListButton.click();
        LOG.infoWithScreenshot("Нажали на стрелку");
    }
    public boolean isAllServicesHabrEnabled(){
        return allServicesHabrText.isEnabled();
    }
    public void howToBeAuthorButtonClick(){
        howToBeAuthorButton.click();
        LOG.infoWithScreenshot("Нажали на кнопку \"Как стать автором\"");
    }
    public void searchButtonClick(){
        searchButton.click();
        LOG.infoWithScreenshot("Нажали на лупу");
    }
    public void allListButtonClick(){
        allListButton.click();
        LOG.infoWithScreenshot("Нажали на \"Все подряд\"");
    }
    public boolean isAllListEnabled(){
        return allList.isEnabled();
    }
    public boolean isRssTitleEnabled(){
        return rssTitle.isEnabled();
    }
    public void forwardButtonClick(){
        scrollTo(forwardButton, 0, 100);
        forwardButton.click();
        LOG.info("Нажали на \"Сюда\"");
    }
    public void backButtonClick(){
        scrollTo(backButton, 0, 100);
        backButton.click();
        LOG.infoWithScreenshot("Нажали на \"Туда\"");
    }
    public boolean isBestBlocksEnabled(){
        scrollTo(bestBlocks, 0, 100);
        return bestBlocks.isEnabled();
    }
}
