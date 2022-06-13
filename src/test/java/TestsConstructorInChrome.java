import pom.MainPage;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

@Story("Тесты на работу с конструктором")
public class TestsConstructorInChrome {

    private MainPage mainPage;

    @Before
    @DisplayName("Открывается сайт")
    public void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
    }

    @After
    @DisplayName("Очищение кеша")
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест перехода к разделу начинок")
    public void goToTheFillingChapterTest() {
        assertTrue(mainPage.goToFillingChapter());
    }

    @Test
    @DisplayName("Тест перехода к разделу соусов")
    public void goToTheSauceChapterTest() {
        assertTrue(mainPage.goToSauceChapter());
    }

    @Test
    @DisplayName("Тест перехода к разделу булок")
    public void goToTheBreadChapterTest() {
        assertTrue(mainPage.goToBreadChapter());
    }

}
