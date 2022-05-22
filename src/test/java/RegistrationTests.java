import POM.LoginPage;
import POM.MainPage;
import POM.RegistrationPage;
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
    void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickToTheEnterButton();
    }

    @After
    void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test
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
