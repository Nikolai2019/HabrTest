package com.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    @Disabled
    public void changeLogTest() {
        driver.get("https://www.habr.com/");
        WebElement userIcon = driver.findElement(By.cssSelector("svg[data-test-id='menu-toggle-guest']"));
        userIcon.click();

        WebElement rulesLink = driver.findElement(By.xpath("//*[contains(text(),'Правила сайта')]"));
        rulesLink.click();

        List<WebElement> changeLog = (driver.findElements(By.xpath("//*[contains(text(),'Changelog')]")));
        assertFalse(changeLog.isEmpty(), "CHANGELOG не найден");
    }

    @Test
    @DisplayName("Проверка заголовка Техническая поддержка")
    @Order(2)
    @Disabled
    public void supportHeaderTest(){
        driver.get("https://www.habr.com/");
        WebElement supportButton = driver.findElement(By.xpath("//*[contains(text(),'Техническая поддержка')]"));
        supportButton.click();

        WebElement mainSupportText = driver.findElement(By.xpath("//h1[contains(text(),'Техническая поддержка')]"));
        assertTrue(mainSupportText.isDisplayed(),"Секция отсутствует");
        System.out.println(mainSupportText);
    }

    @Test
    @DisplayName("Проверка наличия кнопки Отправить на форме обращения")
    @Order(3)
    @Disabled
    public void sendButtonSupportTest(){
        driver.get("https://www.habr.com/");
        WebElement supportButton = driver.findElement(By.xpath("//*[contains(text(),'Техническая поддержка')]"));
        supportButton.click();

        WebElement submitButton = driver.findElement(By.cssSelector("button[class='tm-form__submit base-button']"));
        assertTrue(submitButton.isDisplayed(),"Кнопка отсутствует");
        System.out.println(submitButton);
    }

    @Test
    @DisplayName("Visible After Button")
    @Order(4)
    public void visibleButtonTest(){
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(1));
        WebElement visibleButton = driver.findElement(By.cssSelector("#visibleAfter"));
        wait.until(ExpectedConditions.visibilityOf(visibleButton));
        assertTrue(visibleButton.isDisplayed(),"Кнопка не отображена");
    }

}
