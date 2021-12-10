package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    protected WebDriver driver;
    private static final String EXISTING_USER_EMAIL = "NPniasdhuu@niepodam.pl";
    private static final String EXISTING_USER_PASSWORD = "Pass12!";

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "button-medium")
    private WebElement submitButton;
    @FindBy(className = "cart_quantity_delete")
    private WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"cart_title\"]/text()")
    private WebElement cartTitle;
    @FindBy(id = "id_address_delivery")
    private WebElement deliveryAddress;
    @FindBy(className = "delivery_option_logo")
    private WebElement deliveryLogo;
    @FindBy(id = "cgv")
    private WebElement checkboxTermsButton;
    @FindBy(className = "bankwire")
    private WebElement payByBankWireButton;
    @FindBy(className = "cheque")
    private WebElement payByBankCheckButton;
    @FindBy(className = "page-subheading")
    private WebElement choosePaymentTitle;
    @FindBy(className = "alert-success")
    private WebElement successAlert;

    public void clickSubmitButton() {
        submitButton.click();
    }
    public void clickDeleteButton() {
        deleteButton.click();
    }
}
