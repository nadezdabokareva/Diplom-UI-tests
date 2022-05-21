import POM.LoginPage;
import POM.MainPage;
import POM.PersonalCabinetPage;
import POM.RegistrationPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest {

    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;
    private PersonalCabinetPage personalCabinetPage;

    @BeforeEach
    void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickToTheButton();}

    @Test
    public void successfulRegistrationTest() {
        String nameForRegistration = RandomStringUtils.randomAlphabetic(10);
        String emailForRegistration = RandomStringUtils.randomAlphabetic(10);
        String passwordForRegistration = RandomStringUtils.randomAlphabetic(7);;

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickToTheButton();
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
        loginPage.clickToTheButton();
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.registrationNewUser(nameForRegistration, emailForRegistration, passwordForRegistration);

        assertTrue(registrationPage.showRegistrationErrorText());
    }

}
