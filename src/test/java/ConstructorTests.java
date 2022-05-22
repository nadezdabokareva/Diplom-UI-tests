import POM.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.Assert.assertTrue;

public class ConstructorTests {

    private MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
    }

    @After
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test
    public void goToTheFillingChapterTest() {
        assertTrue(mainPage.goToFillingChapter());
    }

    @Test
    public void goToTheSauceChapterTest() {
        assertTrue(mainPage.goToSauceChapter());
    }

    @Test
    public void goToTheBreadChapterTest() {
        assertTrue(mainPage.goToBreadChapter());
    }

}
