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

    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement registrationLinkButton;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement enterButton;

//    @FindBy(how = How.CLASS_NAME, using = "Auth_login__3hAey")
//    private SelenideElement loginPageTitle;

    public LoginPage clickToTheButton(){
        $(byText("Зарегистрироваться")).click();
        return this;
    }

    public boolean getTitleFromTheLoginPage(){
        $(byXpath("//h2[contains(text(),'Вход')]")).shouldHave(Condition.exactText("Вход"));
        return true;
    }

    public void loginANewUser(String emailForLogin, String passwordForLogin){
        $(byName("name")).shouldBe(Condition.exist).setValue(emailForLogin);
        $(byName("Пароль")).shouldBe(Condition.exist).setValue(passwordForLogin);
//        $(byXpath("//button[contains(text(),'Войти')]")).click();
        $(By.className("button_button__33qZ0")).click();
    }


}
