package navigation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "search_query")
    private WebElement searchTextArea;
    @FindBy(name = "submit_search")
    private WebElement searchButton;
    @FindBy(id = "grid")
    WebElement gridButton;
    @FindBy(id = "list")
    WebElement listButton;


    public void searchProductAndClickEnterKey(String userQuery) {
        searchQuery(userQuery);
        clickEnterKey();
    }
    public void searchProductAndClickSearchButton(String userQuery) {
        searchQuery(userQuery);
        clickSearchButton();
    }
    public void searchQuery(String userQuery) {
        searchTextArea.sendKeys(userQuery);
    }
    public void clickSearchButton() {
        searchButton.click();
    }
    public void clickEnterKey() {
        searchTextArea.sendKeys(Keys.ENTER);
    }
    public void changeToGridView() {
        gridButton.click();
    }
    public void changeToListView() {
        listButton.click();
    }

}
