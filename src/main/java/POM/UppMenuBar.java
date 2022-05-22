package POM;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UppMenuBar {

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoButton;

    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__linkText__3q_va ml-2")
    private SelenideElement constructorButton;

    public UppMenuBar goToTheConstructor() {
        constructorButton.click();
        return this;
    }

}
