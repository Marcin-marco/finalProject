package navigation;

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
    private WebElement userEmailInput;
    @FindBy(id = "passwd")
    private WebElement userPasswordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;
    @FindBy(className = "login")
    private WebElement signInButton;
    @FindBy(className = "logout")
    private WebElement signOutButton;

    public void clickSingIn() {
        signInButton.click();
    }
    public void enterUserEmail(String userEmail) {
        userEmailInput.sendKeys(userEmail);
    }
    public void enterUserPassword(String userPassword) {
        userPasswordInput.sendKeys(userPassword);
    }
    public void typeUserPersonalData(String userEmail, String password) {
        userEmailInput.sendKeys(userEmail);
        userPasswordInput.sendKeys(password);
    }
    public void login(String userEmail, String password) {
        typeUserPersonalData(userEmail, password);
        submitButton.click();
    }
    public void clickSubmitButton() {
        submitButton.click();
    }
    public void clickSignOut() {
        signOutButton.click();
    }


}
