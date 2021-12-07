package navigation;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "email")
    WebElement userEmailInput;
    @FindBy(id = "passwd")
    WebElement userPasswordInput;
    @FindBy(id = "SubmitLogin")
    WebElement loginButton;

    public void enterUserEmail(String userEmail) {
        userEmailInput.sendKeys(userEmail);
    }
    public void enterUserPassword(String userPassword) {
        userPasswordInput.sendKeys(userPassword);
    }
    public void login() {
        loginButton.click();
    }


}
