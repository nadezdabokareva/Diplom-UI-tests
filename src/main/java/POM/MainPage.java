package POM;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Булки')]")
    private SelenideElement breadButton;

//    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Булки')]")
//    private SelenideElement breadTitle;

    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Соусы')]")
    private SelenideElement sauceButton;

//    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Соусы')]")
//    private SelenideElement sauceTitle;

    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Начинки')]")
    private SelenideElement fillingButton;

//    @FindBy(how = How.XPATH, using = ".//h2[contains(text(),'Начинки')]")
//    private SelenideElement fillingTitle;

    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Соус традиционный галактический')]")
    private SelenideElement sauceGalacticTitle;

    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Краторная булка N-200i')]")
    private SelenideElement kratorBreadTitle;

    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Говяжий метеорит (отбивная)')]")
    private SelenideElement meteoritFillingTitle;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoButton;

    @FindBy(how = How.XPATH, using = ".//p[contains(text(),'Конструктор')]")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = ".//h1[contains(text(),'Соберите бургер')]")
    private SelenideElement constructorTitle;

    @FindBy(how = How.XPATH, using = ".//span[contains(text(),'Перетяните булочку сюда (верх)')]")
    private SelenideElement chooseBreadSlider;

    public boolean goToTheConstructor() {
        constructorButton.click();
        constructorTitle.shouldHave(Condition.exactText("Соберите бургер"));
        return true;
    }

    public boolean goToTheLogoButton() {
        logoButton.click();
        chooseBreadSlider.shouldHave(Condition.exactText("Перетяните булочку сюда (верх)"));
        return true;
    }

    public MainPage clickToTheEnterButton () {
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

    public boolean goToFillingChapter(){
        fillingButton.click();
        meteoritFillingTitle.shouldBe(Condition.visible);
        return true;
    }

    public boolean goToSauceChapter(){
        sauceButton.click();
        sauceGalacticTitle.shouldBe(Condition.visible);
        return true;
    }

    public boolean goToBreadChapter(){
        breadButton.click();
        kratorBreadTitle.shouldBe(Condition.visible);
        return true;
    }



}
