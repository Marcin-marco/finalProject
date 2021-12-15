package navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    @FindBy(id = "email_create")
    private WebElement emailToCreateAccount;
    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;
    @FindBy(className = "logout")
    private WebElement signOutButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]//li")
    private WebElement authenticationAlert;
    @FindBy(className = "page-heading")
    private WebElement loginPageHeader;



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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5, 1));
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        typeUserPersonalData(userEmail, password);
        submitButton.click();
    }
    public void clickSubmitButton() {
        submitButton.click();
    }
    public void clickSignOut() {
        signOutButton.click();
    }
    public void createAccount(String userEmail) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        emailToCreateAccount.sendKeys(userEmail);
        createAccountButton.click();
    }
    public String verifyTextAlert() {
        return authenticationAlert.getText();
    }
    public boolean isOnMyAccountPage() {
        return driver.getCurrentUrl().contains("controller=my-account");
    }
    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().contains("controller=authentication&back=my-account");
    }
    public boolean isDisplayedAuthenticationAlert() {
        return driver.findElement(By.className("alert-danger")).isDisplayed();
    }
    public String isAuthenticationTextDisplayed() {
        return loginPageHeader.getText();
    }



}
