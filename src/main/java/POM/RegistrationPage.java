package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    //https://stellarburgers.nomoreparties.site/register

//    @FindBy(how = How.XPATH, using = ".//div/input[@class='Имя']")
//    private SelenideElement nameField;

    @FindBy(how = How.CLASS_NAME, using = "input__placeholder")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = ".//div/input[@placeholder='Email']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = ".//div/input[@placeholder='Пароль]")
    private SelenideElement passwordField;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement registrationButton;

    public void registrationNewUser(String name, String email, String password){
        nameField.click();
        nameField.shouldBe(Condition.exist).setValue(name);
    }

    public RegistrationPage clickToTheRegistrationButton(){
        $(byText("Зарегистрироваться")).click();
        return this;
    }




}
