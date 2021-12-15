package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_contact")
    private WebElement subjectSelect;
    @FindBy(id = "email")
    private WebElement emailBox;
    @FindBy(id = "id_order")
    private WebElement orderBox;
    @FindBy(id = "message")
    private WebElement messageArea;
    @FindBy(name = "submitMessage")
    private WebElement submitButton;
    @FindBy(className = "alert-success")
    private WebElement informationAlertSuccess;
    @FindBy(xpath = "//*[@id=\"center_column\"]//li")
    private WebElement informationAlertFail;

    public boolean isOnContactUsPage() {
        return driver.getCurrentUrl().contains("controller=contact");
    }

    public void clickAndChooseSubjectHeading() {
        Select select = new Select(subjectSelect);
        select.selectByValue("1");
    }

    public void fillEmailBoxAndMessageAreaAndClick(String userEmail, String userText) {
        emailBox.sendKeys(userEmail);
        messageArea.sendKeys(userText);
        submitButton.click();
    }

    public boolean isMessageSend() {
        if (informationAlertFail.isDisplayed()) {
            return true;
        } else {
            return informationAlertSuccess.isDisplayed();
        }
    }

}
