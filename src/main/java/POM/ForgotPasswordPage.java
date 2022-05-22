package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    //https://stellarburgers.nomoreparties.site/forgot-password

    @FindBy(how = How.XPATH, using = "Auth_link__1fOlj")
    private SelenideElement enterToAccountButtonWithChangePass;

    public ForgotPasswordPage goToTheEnterAccountButton() {
        $(byXpath("//a[contains(text(),'Войти')]")).shouldHave(Condition.exactText("Войти")).click();
        return this;
    }
}
