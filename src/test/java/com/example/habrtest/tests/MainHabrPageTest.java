package com.example.habrtest.tests;

import com.example.habrtest.AllureLogger;
import com.example.habrtest.pages.FeedbackPage;
import com.example.habrtest.pages.MainHabrPage;
import com.example.habrtest.pages.SearchPage;
import com.example.habrtest.pages.StartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHabrPageTest extends BaseTest {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainHabrPage.class));
    private MainHabrPage MainHabrPage;
    private FeedbackPage FeedbackPage;
    private StartPage StartPage;
    private SearchPage SearchPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.habr.com/");
        MainHabrPage = new MainHabrPage(getDriver());
        FeedbackPage = new FeedbackPage(getDriver());
        StartPage = new StartPage(getDriver());
        SearchPage = new SearchPage(getDriver());
    }

    @Test
    @DisplayName("Проверка заголовка \"Техническая поддержка\"")
    public void supportHeaderTest() {
        MainHabrPage.scrollTo(MainHabrPage.supportButton, 0, 100);
        MainHabrPage.supportButtonClick();
        Assertions.assertTrue(FeedbackPage.isMainTitleEnabled(), "Заголовок \"Техническая поддержка\" отсутствует");
        LOG.infoWithScreenshot("Заголовок \"Техническая поддержка\" присутствует");
    }

    @Test
    @DisplayName("Проверка наличия кнопки \"Отправить\" на форме обращения")
    public void sendButtonSupportTest() {
        MainHabrPage.scrollTo(MainHabrPage.supportButton, 0, 100);
        MainHabrPage.supportButtonClick();
        Assertions.assertTrue(FeedbackPage.isSubmitButtonEnabled(), "Кнопка \"Отправить\" отсутствует");
        LOG.infoWithScreenshot("Кнопка \"Отправить\" присутствует");
    }

    @Test
    @DisplayName("При клике на логотип открывается главная страница сайта")
    public void mainLogoCheck() {
        MainHabrPage.mainLogoClick();
        assertEquals("https://habr.com/ru/articles/", getDriver().getCurrentUrl(), "Открылась другая страница");
    }

    @Test
    @DisplayName("При нажатии на стрелочку рядом с логотипом откроется меню \"Все сервисы Хабра\"")
    public void openListMenuTest() {
        MainHabrPage.openListButtonClick();
        assertTrue(MainHabrPage.isAllServicesHabrEnabled(),"Раздел \"Все сервисы Хабра\" не появился");
        LOG.infoWithScreenshot("Раздел \"Все сервисы Хабра\" появился");
    }
    @Test
    @DisplayName("При нажатии на \"Как стать автором\" открывается страница с h1=\"Как стать автором\"")
    public void howToBeAuthorUrlPageTest(){
        MainHabrPage.howToBeAuthorButtonClick();
        assertTrue(StartPage.isH1BlockEnabled(),"Раздел не появился");
        LOG.infoWithScreenshot("Появился раздел \"Как стать автором\"");
    }
    @Test
    @DisplayName("При нажатии на лупу открывается страница, на которой есть раздел \"Минуточку внимания\"")
    public void minutesBlockCheck(){
        MainHabrPage.searchButtonClick();
        assertTrue(SearchPage.isMinutesWaitingBlockEnabled(),"Раздел не появился");
    }
    @Test
    @DisplayName("При нажатии на \"Все подряд\" открывается фильтр\n")
    public void allListTest(){
        MainHabrPage.allListButtonClick();
        assertTrue(MainHabrPage.isAllListEnabled(),"Раздел \"Все подряд\" не появился");
        LOG.infoWithScreenshot("Фильтр \"Все подряд\" открылся");
    }
    @Test
    @DisplayName("На странице есть title \"Скопировать ссылку на RSS\"")
    public void rssTitleTest(){
        assertTrue(MainHabrPage.isRssTitleEnabled(),"RSS title не доступен");
        LOG.infoWithScreenshot("RSS title");
    }
    @Test
    @DisplayName("В футере \"Сюда\" не кликабельна")
    public void forwardButtonIsNotClickableTest(){
        MainHabrPage.forwardButtonClick();
        assertEquals("https://habr.com/ru/articles/",getDriver().getCurrentUrl(),"Некорректное поведение кнопки Сюда");
    }
    @Test
    @DisplayName("В футере \"Туда\" кликабельна")
    public void backButtonIsClickableTest(){
        MainHabrPage.backButtonClick();
        assertEquals("https://habr.com/ru/articles/page2/",getDriver().getCurrentUrl(),"Некорректное поведение кнопки Сюда");
    }

    @Test
    @DisplayName("Существует раздел \"Лучшие блоги\"")
    public void bestBlocksTest(){
        assertTrue(MainHabrPage.isBestBlocksEnabled(),"Раздел \"Лучшие блоги\" не доступен");
        LOG.infoWithScreenshot("\"Лучшие блоги\"");
    }
}
