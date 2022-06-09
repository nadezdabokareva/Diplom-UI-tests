import POM.LoginPage;
import POM.MainPage;
import POM.PersonalAccountPage;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

@Story("Тесты в личном кабинете в Яндексе")
public class PersonalAccountTestsInYandexBrowser {

    private MainPage mainPage;
    private PersonalAccountPage personalAccountPage;
    private LoginPage loginPage;

    @Before
    @DisplayName("Создание логопассов, авторизация")
    public void setUp() {
        String email = "lesnoiolen666@gmail.com";
        String password = "123456";

        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\Diplom_3\\Webdriver\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickToTheEnterButton();

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginANewUser(email, password);

        mainPage.goToThePersonalAccount();
    }

    @After
    @DisplayName("Очищение кеша")
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест перехода к разделу конструктора (Yandex)")
    public void goToConstructorTestYandex() {
        assertTrue(mainPage.goToTheConstructor());
    }

    @Test
    @DisplayName("Тест перехода через логотип (Yandex)")
    public void goToStellarBurgerLogoTest() {
        assertTrue(mainPage.goToTheLogoButton());
    }

    @Test
    @DisplayName("Тест выхода из аккаунта (Yandex)")
    public void exitFromAccountTestYandex() {
        personalAccountPage = open("https://stellarburgers.nomoreparties.site/account", PersonalAccountPage.class);
        personalAccountPage.exitFromAccount();
        assertTrue(loginPage.getTitleFromTheLoginPage());
    }

    @Test
    @DisplayName("Тест входа в аккаунт (Yandex)")
    public void enterToAccountTestYandex() {
        personalAccountPage = open("https://stellarburgers.nomoreparties.site/account", PersonalAccountPage.class);
        assertTrue(personalAccountPage.getTextFromPersonalProfile());
    }

}
