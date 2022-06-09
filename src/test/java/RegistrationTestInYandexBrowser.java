import POM.LoginPage;
import POM.MainPage;
import POM.RegistrationPage;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertTrue;

@Story("Тесты на регистрацию в Яндексе")
public class RegistrationTestInYandexBrowser {
    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    public String nameForRegistration;
    public String emailForRegistration;
    public String passwordForRegistration;

    @Before
    @DisplayName("Создание рандомных данных, вход на сайт")
    public void setUp() {
        nameForRegistration = RandomStringUtils.randomAlphabetic(10);
        emailForRegistration = RandomStringUtils.randomAlphabetic(10);
        passwordForRegistration = RandomStringUtils.randomAlphabetic(7);

        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\projects\\Diplom_3\\Webdriver\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickToTheEnterButton();
    }

    @After
    @DisplayName("Очищение кеша")
    public void tearDown() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }

    @Test
    @DisplayName("Тест успешной регистрации пользователя (Yandex)")
    public void successfulRegistrationTestYandex() {
        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickToTheRegistrationButton();
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.registrationNewUser(nameForRegistration, emailForRegistration, passwordForRegistration);

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);

        assertTrue(loginPage.getTitleFromTheLoginPage());
    }

    @Test
    @DisplayName("Тест провальной регистрации (из-за пароля < 6 символов) (Yandex)")
    public void unSuccessfulRegistrationTestYandex() {
        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickToTheRegistrationButton();
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.registrationNewUser(nameForRegistration, emailForRegistration, passwordForRegistration);

        assertTrue(registrationPage.showRegistrationErrorText());
    }
}
