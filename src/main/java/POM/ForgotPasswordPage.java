package POM;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {

    @Step("Проверка перехода на страницу авторизации")
    public ForgotPasswordPage goToTheEnterAccountButton() {
        $(byXpath("//a[contains(text(),'Войти')]")).shouldHave(Condition.exactText("Войти")).click();
        return this;
    }
}
