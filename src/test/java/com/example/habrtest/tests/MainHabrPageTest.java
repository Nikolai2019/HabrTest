package com.example.habrtest.tests;

import com.example.habrtest.pages.FeedbackPage;
import com.example.habrtest.pages.MainHabrPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHabrPageTest extends BaseTest {
    private MainHabrPage MainHabrPage;
    private FeedbackPage FeedbackPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.habr.com/");
        MainHabrPage = new MainHabrPage(getDriver());
        FeedbackPage = new FeedbackPage(getDriver());
    }

    @Test
    @DisplayName("Проверка заголовка \"Техническая поддержка\"")
    public void supportHeaderTest(){
        MainHabrPage.scrollTo(MainHabrPage.supportButton, 0,100);
        MainHabrPage.supportButtonClick();
        Assertions.assertTrue(FeedbackPage.isMainTitkeEnabled(),"Title отсутствует");
    }
    @Test
    @DisplayName("Проверка наличия кнопки \"Отправить\" на форме обращения")
    public void sendButtonSupportTest(){
        MainHabrPage.scrollTo(MainHabrPage.supportButton, 0,100);
        MainHabrPage.supportButtonClick();
        Assertions.assertTrue(FeedbackPage.isSubmitButtonEnabled(),"Кнопка \"Отправить\" отсутствует");
    }
}
