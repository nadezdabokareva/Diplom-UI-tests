import POM.LoginPage;
import POM.MainPage;
import POM.PersonalAccountPage;
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

//    @Test
//    public void goToAccountTest() {
//
//        try {
//            personalAccountPage.goToTheOrdersHistory();
//            assertTrue(personalAccountPage.getTextFromPersonalProfile());
//        } catch (Exception e) {
//            System.out.println(("тест не сработал"));
//        }
//    }

    @Test
    public void goToConstructorTest() {
        assertTrue(mainPage.goToTheConstructor());
    }
}
