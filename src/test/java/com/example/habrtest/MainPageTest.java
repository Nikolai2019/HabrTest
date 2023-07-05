package com.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        driver.get("https://www.habr.com/");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void changeLogTest() {

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
    public void supportHeaderTest(){
        WebElement supportButton = driver.findElement(By.xpath("//*[contains(text(),'Техническая поддержка')]"));
        supportButton.click();

        WebElement mainSupportText = driver.findElement(By.xpath("//h1[contains(text(),'Техническая поддержка')]"));
        assertTrue(mainSupportText.isDisplayed(),"Секция отсутствует");
        System.out.println(mainSupportText);
    }

    @Test
    @DisplayName("Проверка наличия кнопки Отправить на форме обращения")
    @Order(3)
    public void sendButtonSupportTest(){
        WebElement supportButton = driver.findElement(By.xpath("//*[contains(text(),'Техническая поддержка')]"));
        supportButton.click();

        WebElement submitButton = driver.findElement(By.cssSelector("button[class='tm-form__submit base-button']"));
        assertTrue(submitButton.isDisplayed(),"Кнопка отсутствует");
        System.out.println(submitButton);
    }
}
