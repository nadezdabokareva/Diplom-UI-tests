package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
//https://stellarburgers.nomoreparties.site/login

//    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
//    private SelenideElement registrationLinkButton;

//    public LoginPage clickToTheButton(){
//        registrationLinkButton.shouldBe(Condition.exist).click();
//        return this;
//    }

    public LoginPage clickToTheButton(){
        $(byText("Зарегистрироваться")).click();
        return this;
    }

}
