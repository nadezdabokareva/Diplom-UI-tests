import POM.ForgotPasswordPage;
import POM.LoginPage;
import POM.MainPage;
import POM.RegistrationPage;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.Assert.assertTrue;

@Story("Тесты на авторизацию")
public class LoginTestsInChrome {

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
    @DisplayName("Тест авторизации через кнопку входа")
    public void loginUserWithTheEnterToAccountButton() {
        mainPage.clickToTheEnterButton();

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginANewUser(emailForLogin, passwordForLogin);

        assertTrue(mainPage.getTitleFromTheCreateOrderButton());
    }

    @Test
    @DisplayName("Тест авторизации через личный кабинет")
    public void loginUserWithThePersonalAccountButton() {
        mainPage.goToThePersonalAccount();

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginANewUser(emailForLogin, passwordForLogin);

        assertTrue(mainPage.getTitleFromTheCreateOrderButton());
    }

    @Test
    @DisplayName("Тест авторизации через окно регистрации")
    public void loginUserWithTheRegistrationForm() {
        mainPage.clickToTheEnterButton();

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickToTheRegistrationButton();
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.clickToEnterToAccountButton();
        loginPage.loginANewUser(emailForLogin, passwordForLogin);

        assertTrue(mainPage.getTitleFromTheCreateOrderButton());
    }

    @Test
    @DisplayName("Тест авторизации через форму восстановления пароля")
    public void loginUserWithTheChangePasswordButton() {
        mainPage.clickToTheEnterButton();

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickToTheChangePasswordButton();

        forgotPasswordPage = open("https://stellarburgers.nomoreparties.site/forgot-password", ForgotPasswordPage.class);
        forgotPasswordPage.goToTheEnterAccountButton();

        loginPage.loginANewUser(emailForLogin, passwordForLogin);

        assertTrue(mainPage.getTitleFromTheCreateOrderButton());
    }

}
