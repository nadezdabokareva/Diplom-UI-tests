package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
//    https://stellarburgers.nomoreparties.site/

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement enterToAccountButton;

    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement createOrderButton;



    public MainPage clickToTheEnterButton(){
        enterToAccountButton.shouldBe(Condition.exist).click();
        return this;
    }

    public MainPage goToThePersonalAccount(){
        personalAccountButton.shouldBe(Condition.exist).click();
        return this;
    }

    public boolean getTitleFromTheCreateOrderButton(){
        $(byXpath("//button[contains(text(),'Оформить заказ')]")).shouldHave(Condition.exactText("Оформить заказ"));
        return true;
    }



}
