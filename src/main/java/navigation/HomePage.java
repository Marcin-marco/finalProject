package navigation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "search_query")
    private WebElement searchBox;
    @FindBy(name = "submit_search")
    private WebElement searchButton;
    @FindBy(id = "contact-link")
    private WebElement contactUsButton;
    @FindBy(className = "login")
    private WebElement signInButton;
    private WebElement someProductLink;
    @FindBy(className = "shopping_cart")
    private WebElement shoppingCart;
    @FindBy(className = "cart-buttons")
    private WebElement shoppingCartCheckOutButton;
    @FindBy(xpath = "/html/head/link[1]")
    private WebElement webLogo;
    @FindBy(css = "#add_to_cart > button")
    private WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div/h2")
    private WebElement productAddInfo;
    @FindBy(className = "ajax_cart_block_remove_link")
    private WebElement removeProductButton;
    @FindBy(className = "cross")
    private WebElement closeWindowButton;
    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    private WebElement shoppingCartLink;


    public boolean isProductAddCorrect() {
        return productAddInfo.isDisplayed();
    }

    public boolean isWebLogoOnPage() {
        return webLogo.isDisplayed();
    }

    public boolean isSearchBoxOnPage() {
        return searchBox.isDisplayed();
    }

    public void searchProductAndClickEnterKey(String userQuery) {
        searchQuery(userQuery);
        clickEnterKey();
    }

    public void searchProductAndClickSearchButton(String userQuery) {
        searchQuery(userQuery);
        clickSearchButton();
    }

    public void searchQuery(String userQuery) {
        searchBox.sendKeys(userQuery);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickEnterKey() {
        searchBox.sendKeys(Keys.ENTER);
    }

    public void clickSingIn() {
        signInButton.click();
    }

    public void clickOnSomeProduct() {
        someProductLink.click();
    }

    public void clickContactUs() {
        contactUsButton.click();
    }

    public void clickShoppingCartAndRemoveProduct() throws InterruptedException {
        closeWindowButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartLink).build().perform();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(removeProductButton));
        removeProductButton.click();
        Thread.sleep(8000);
    }

    public void clickAddToCart() throws InterruptedException {
        Thread.sleep(10000);
        addToCartButton.click();
        Thread.sleep(10000);
    }
    public String isShoppingCartEmpty() {
        return shoppingCart.getText();
    }


}
