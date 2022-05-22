package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    //https://stellarburgers.nomoreparties.site/register

    @FindBy(how = How.CLASS_NAME, using = "input__error")
    private SelenideElement registrationErrorText;

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement enterToAccountButtonOnTheRegistrationForm;


    public void registrationNewUser(String nameForRegistration, String emailForRegistration, String passwordForRegistration){
        $(byName("name")).shouldBe(Condition.exist).setValue(nameForRegistration);
        $(byXpath("//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/fieldset[2]/div[1]/div[1]/input[1]"))
                .shouldBe(Condition.exist).setValue(emailForRegistration); //путь создан с помощью расширения ChroPath
        $(byName("Пароль")).shouldBe(Condition.exist).setValue(passwordForRegistration);
        $(byText("Зарегистрироваться")).click();
    }

    public boolean showRegistrationErrorText(){
        $(byClassName("input__error")).shouldHave(Condition.exactText("Некорректный пароль"));
        return true;
    }

    public RegistrationPage clickToEnterToAccountButton(){
        enterToAccountButtonOnTheRegistrationForm.shouldBe(Condition.visible).click();
        return this;
    }


}
