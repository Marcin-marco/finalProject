package navigation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    WebDriver driver;

    private static final String EXISTING_USER_EMAIL = "NPniasdhuu@niepodam.pl";
    private static final String EXISTING_USER_PASSWORD = "Pass12!";

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Proceed to checkout")
    private WebElement checkoutButton;
    @FindBy(className = "cart_quantity_delete")
    private WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"cart_title\"]/text()")
    private WebElement cartTitle;
    @FindBy(id = "cgv")
    private WebElement checkboxTermsButton;
    @FindBy(className = "fancybox-error")
    private WebElement deliveryAlert;
    @FindBy(className = "cheque")
    private WebElement payByBankCheckButton;
    @FindBy(className = "page-subheading")
    private WebElement choosePaymentTitle;
    @FindBy(className = "page-heading")
    private WebElement informationAboutOrder;
    @FindBy(css = "#cart_navigation > button")
    private WebElement confirmOrderButton;
    @FindBy(name = "processAddress")
    private WebElement confirmAddressButton;
    @FindBy(name = "processCarrier")
    private WebElement confirmShippingButton;


    public void jsExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)");
    }
    public void clickCheckoutButton() {
        jsExecutor();
        checkoutButton.click();
    }
    public void clickConfirmAddressButton() {
        jsExecutor();
        confirmAddressButton.click();
    }
    public void clickConfirmShippingButton() {
        jsExecutor();
        confirmShippingButton.click();
    }
    public void clickCheckboxTermsButtonAndSubmit() {
        checkboxTermsButton.click();
        clickConfirmShippingButton();
    }
    public void clickPayByBankButtonAndConfirmOrder() {
        payByBankCheckButton.click();
        jsExecutor();
        confirmOrderButton.click();
    }
    public boolean isDeliveryAlertOnOrderPage() {
        return deliveryAlert.isDisplayed();
    }
    public String isOrderComplete() {
        return informationAboutOrder.getText();
    }
}
