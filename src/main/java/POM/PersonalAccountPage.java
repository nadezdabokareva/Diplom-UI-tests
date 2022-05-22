package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PersonalAccountPage {
    //https://stellarburgers.nomoreparties.site/account/profile

    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'История заказов')]")
    private SelenideElement ordersHistory;

    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'В этом разделе вы можете изменить свои персональны')]")
    private SelenideElement personalAccountMessage;


    @FindBy(how = How.CLASS_NAME, using = "button_button__33qZ0")
    private SelenideElement saveAccountButton;

    public PersonalAccountPage goToTheOrdersHistory(){
        personalAccountMessage.shouldBe(Condition.exist).click();
        return this;
    }

    public boolean getTextFromPersonalAccountMessage(){
        personalAccountMessage.shouldBe(Condition.exist).shouldHave(Condition.exactText
                ("В этом разделе вы можете изменить свои персональные данные"));
        return true;
    }

    public boolean getTextFromPersonalProfile(){
        $(byXpath("//a[contains(text(),'Профиль')]")).shouldHave(Condition.exactText("Профиль"));
        return true;
    }




}
