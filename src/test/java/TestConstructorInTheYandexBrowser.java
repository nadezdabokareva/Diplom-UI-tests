import POM.MainPage;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

@Story("Тесты на работу с конструктором в Яндексе")
public class TestConstructorInTheYandexBrowser {
    private MainPage mainPage;

    @Before
    @DisplayName("Открывается сайт")
    public void setUp() {
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\Diplom_3\\Webdriver\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
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
    @DisplayName("Тест перехода к разделу начинок (Yandex)")
    public void goToTheFillingChapterTestYandex() {
        assertTrue(mainPage.goToFillingChapter());
    }

    @Test
    @DisplayName("Тест перехода к разделу соусов (Yandex)")
    public void goToTheSauceChapterTestYandex() {
        assertTrue(mainPage.goToSauceChapter());
    }

    @Test
    @DisplayName("Тест перехода к разделу булок (Yandex)")
    public void goToTheBreadChapterTestYandex() {
        assertTrue(mainPage.goToBreadChapter());
    }

}
