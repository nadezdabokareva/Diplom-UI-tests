package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
//https://stellarburgers.nomoreparties.site/login

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationLinkButton;

    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти')]")
    private SelenideElement enterToAccountButton;

    public LoginPage clickToTheRegistrationButton(){
        $(byText("Зарегистрироваться")).click();
        return this;
    }

    public boolean getTitleFromTheLoginPage(){
        enterToAccountButton.shouldHave(Condition.exactText("Вход"));
        return true;
    }

    public void loginANewUser(String emailForLogin, String passwordForLogin){
        $(byName("name")).shouldBe(Condition.exist).setValue(emailForLogin);
        $(byName("Пароль")).shouldBe(Condition.exist).setValue(passwordForLogin);
        enterToAccountButton.click();
    }


}
