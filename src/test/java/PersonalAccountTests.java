import POM.LoginPage;
import POM.MainPage;
import POM.PersonalAccountPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.Assert.assertTrue;

public class PersonalAccountTests {

    private MainPage mainPage;
    private PersonalAccountPage personalAccountPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        String email = "lesnoiolen666@gmail.com";
        String password = "123456";

        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickToTheEnterButton();

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.loginANewUser(email, password);

        mainPage.goToThePersonalAccount();
    }

    @After
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест перехода к разделу конструктора")
    public void goToConstructorTest() {
        assertTrue(mainPage.goToTheConstructor());
    }

    @Test
    @DisplayName("Тест перехода через логотип")
    public void goToStellarBurgerLogoTest() {
        assertTrue(mainPage.goToTheLogoButton());
    }

    @Test
    @DisplayName("Тест выхода из аккаунта")
    public void exitFromAccountTest() {
        personalAccountPage = open("https://stellarburgers.nomoreparties.site/account", PersonalAccountPage.class);
        personalAccountPage.exitFromAccount();
        assertTrue(loginPage.getTitleFromTheLoginPage());
    }

    @Test
    @DisplayName("Тест входа в аккаунт")
    public void enterToAccountTest() {
        personalAccountPage = open("https://stellarburgers.nomoreparties.site/account", PersonalAccountPage.class);
        assertTrue(personalAccountPage.getTextFromPersonalProfile());
    }

}
