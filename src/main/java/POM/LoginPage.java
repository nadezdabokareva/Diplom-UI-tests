package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationLinkButton;

    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти')]")
    private SelenideElement enterToAccountButton;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement changePasswordButton;

    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Вход')]")
    private SelenideElement loginPageTitle;

    @Step("Нажать на кнопку регистрации")
    public LoginPage clickToTheRegistrationButton() {
        registrationLinkButton.click();
        return this;
    }

    @Step("Нажать на кнопку смены пароля")
    public LoginPage clickToTheChangePasswordButton() {
        changePasswordButton.click();
        return this;
    }

    @Step("Получить заглавие со страницы авторизации")
    public boolean getTitleFromTheLoginPage() {
        loginPageTitle.shouldHave(Condition.exactText("Вход"));
        return true;
    }

    @Step("Авторизовать нового пользователя")
    public void loginANewUser(String emailForLogin, String passwordForLogin){
        $(byName("name")).shouldBe(Condition.exist).setValue(emailForLogin);
        $(byName("Пароль")).shouldBe(Condition.exist).setValue(passwordForLogin);
        enterToAccountButton.click();
    }


}
