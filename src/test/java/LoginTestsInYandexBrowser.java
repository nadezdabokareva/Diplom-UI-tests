import POM.ForgotPasswordPage;
import POM.LoginPage;
import POM.MainPage;
import POM.RegistrationPage;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

@Story("Тесты на авторизацию в Яндексе")
public class LoginTestsInYandexBrowser {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private ForgotPasswordPage forgotPasswordPage;

    public String emailForLogin;
    public String passwordForLogin;

    @Before
    @DisplayName("Создание логопассов, авторизация")
    public void setUp() {
        emailForLogin = "lesnoiolen666@gmail.com";
        passwordForLogin = "123456";

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
    @DisplayName("Тест авторизации через кнопку входа (Yandex)")
    public void loginUserWithTheEnterToAccountButtonYandex() {
        mainPage.clickToTheEnterButton();

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginANewUser(emailForLogin, passwordForLogin);

        assertTrue(mainPage.getTitleFromTheCreateOrderButton());
    }

    @Test
    @DisplayName("Тест авторизации через личный кабинет (Yandex)")
    public void loginUserWithThePersonalAccountButtonYandex() {
        mainPage.goToThePersonalAccount();

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginANewUser(emailForLogin, passwordForLogin);

        assertTrue(mainPage.getTitleFromTheCreateOrderButton());
    }

    @Test
    @DisplayName("Тест авторизации через окно регистрации (Yandex)")
    public void loginUserWithTheRegistrationFormYandex() {
        mainPage.clickToTheEnterButton();

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickToTheRegistrationButton();
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.clickToEnterToAccountButton();
        loginPage.loginANewUser(emailForLogin, passwordForLogin);

        assertTrue(mainPage.getTitleFromTheCreateOrderButton());
    }

    @Test
    @DisplayName("Тест авторизации через форму восстановления пароля (Yandex)")
    public void loginUserWithTheChangePasswordButtonYandex() {
        mainPage.clickToTheEnterButton();

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickToTheChangePasswordButton();

        forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);
        forgotPasswordPage.goToTheEnterAccountButton();

        loginPage.loginANewUser(emailForLogin, passwordForLogin);

        assertTrue(mainPage.getTitleFromTheCreateOrderButton());
    }

}
