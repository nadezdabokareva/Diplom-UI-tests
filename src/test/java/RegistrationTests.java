import POM.LoginPage;
import POM.MainPage;
import POM.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;


public class RegistrationTests {

    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickToTheEnterButton();
    }

    @After
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест успешной регистрации пользователя")
    public void successfulRegistrationTest() {
        String nameForRegistration = RandomStringUtils.randomAlphabetic(10);
        String emailForRegistration = RandomStringUtils.randomAlphabetic(10);
        String passwordForRegistration = RandomStringUtils.randomAlphabetic(7);

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickToTheRegistrationButton();
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.registrationNewUser(nameForRegistration, emailForRegistration, passwordForRegistration);

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);

        assertTrue(loginPage.getTitleFromTheLoginPage());
    }

    @Test
    @DisplayName("Тест провальной регистрации (из-за пароля < 6 символов)")
    public void unSuccessfulRegistrationTest() {
        String nameForRegistration = RandomStringUtils.randomAlphabetic(10);
        String emailForRegistration = RandomStringUtils.randomAlphabetic(10);
        String passwordForRegistration = RandomStringUtils.randomAlphabetic(5);

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickToTheRegistrationButton();
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.registrationNewUser(nameForRegistration, emailForRegistration, passwordForRegistration);

        assertTrue(registrationPage.showRegistrationErrorText());
    }

}
