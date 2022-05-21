import POM.LoginPage;
import POM.MainPage;
import POM.RegistrationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    private MainPage mainPage;
    private RegistrationPage registrationPage;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        mainPage = open("https://stellarburgers.nomoreparties.site/", MainPage.class);
        mainPage.clickToTheButton();}

    @Test
    public void successfulRegistrationTest() {
        String name = "Надя";
        String email = "nadezdabokareva910@gmail.com";
        String password = "123456";

        loginPage = open("https://stellarburgers.nomoreparties.site/login", LoginPage.class);
        loginPage.clickToTheButton();
        registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.registrationNewUser(name, email, password);

        assertEquals("Оформить заказ", mainPage.getTextFromCreateOrderButton());

    }

}
