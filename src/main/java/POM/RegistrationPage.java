package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Некорректный пароль')]")
    private SelenideElement registrationErrorText;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enterToAccountButtonOnTheRegistrationForm;

    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement registrationButton;

    @Step("Регистрация нового пользователя")
    public void registrationNewUser(String nameForRegistration, String emailForRegistration, String passwordForRegistration) {
        $(byName("name")).shouldBe(Condition.exist).setValue(nameForRegistration);
        $(byXpath("//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]"))
                .shouldBe(Condition.exist).setValue(emailForRegistration); //путь создан с помощью расширения ChroPath
        $(byName("Пароль")).shouldBe(Condition.exist).setValue(passwordForRegistration);
        registrationButton.click();
    }

    @Step("Взять текст от ошибочной регистрации")
    public boolean showRegistrationErrorText() {
        registrationErrorText.shouldHave(Condition.exactText("Некорректный пароль"));
        return true;
    }

    @Step("Нажать на кнопку входа в аккаунт")
    public RegistrationPage clickToEnterToAccountButton() {
        enterToAccountButtonOnTheRegistrationForm.shouldBe(Condition.visible).click();
        return this;
    }

}
