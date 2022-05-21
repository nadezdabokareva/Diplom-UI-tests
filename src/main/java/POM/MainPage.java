package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
//    https://stellarburgers.nomoreparties.site/

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement enterToAccountButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__linkText__3q_va ml-2")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement createOrderButton;



    public MainPage clickToTheButton(){
        enterToAccountButton.shouldBe(Condition.exist).click();
        return this;
    }

    public MainPage getTextFromCreateOrderButton(){
        createOrderButton.getText();
        return this;
    }
}
