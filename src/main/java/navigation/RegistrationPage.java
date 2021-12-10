package navigation;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    WebDriver driver;

    protected static Faker faker = new Faker();

    private static final String UNIQUE_EMAIL = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(10000) + "@test.com";
    private static final String UNIQUE_FIRST_NAME = faker.name().firstName();
    private static final String UNIQUE_LAST_NAME = faker.name().lastName();
    private static final String UNIQUE_PASSWORD = faker.name().firstName() + faker.random().nextInt(4);
    private static final String UNIQUE_ADDRESS = faker.address().streetAddress();
    private static final String UNIQUE_CITY = faker.address().cityName();
    private static final String UNIQUE_POSTCODE = String.valueOf(faker.number().digits(5));
    private static final String UNIQUE_MOBILE_PHONE = String.valueOf(faker.number().digits(11));
    private static final String UNIQUE_ALIAS_ADDRESS = faker.address().secondaryAddress();

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;
    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;
    @FindBy(id = "passwd")
    private WebElement customerPassword;
    @FindBy(id = "firstname")
    private WebElement customerFirstNameAddress;
    @FindBy(id = "lastname")
    private WebElement customerLastNameAddress;
    @FindBy(id = "address1")
    private WebElement customerAddress;
    @FindBy(id = "city")
    private WebElement customerCityAddress;
    @FindBy(id = "id_state")
    private WebElement customerStateAddress;
    @FindBy(id = "postcode")
    private WebElement customerPostcodeAddress;
    @FindBy(id = "id_country")
    private WebElement customerCountryAddress;
    @FindBy(id = "phone_mobile")
    private WebElement customerMobilePhoneAddress;
    @FindBy(id = "alias")
    private WebElement customerAliasAddress;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public void fillYourPersonalInformationFields() {
        customerFirstName.sendKeys(UNIQUE_FIRST_NAME);
        customerLastName.sendKeys(UNIQUE_LAST_NAME);
        customerPassword.sendKeys(UNIQUE_PASSWORD);
    }
    public void fillYourAddressFields() {
        customerFirstNameAddress.sendKeys(UNIQUE_FIRST_NAME);
        customerLastNameAddress.sendKeys(UNIQUE_LAST_NAME);
        customerAddress.sendKeys(UNIQUE_ADDRESS);
        customerCityAddress.sendKeys(UNIQUE_CITY);
        Select state = new Select(customerStateAddress);
        state.selectByValue("1");
        customerPostcodeAddress.sendKeys(UNIQUE_POSTCODE);
        customerMobilePhoneAddress.sendKeys(UNIQUE_MOBILE_PHONE);
        customerAliasAddress.sendKeys(UNIQUE_ALIAS_ADDRESS);
    }
    public void clickSignInAndFillCreateAccountFieldAndSubmit() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickSingIn();
        loginPage.createAccount(UNIQUE_EMAIL);
    }
    public void clickRegisterButton() {
        registerButton.click();
    }
}
