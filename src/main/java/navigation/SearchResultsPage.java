package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "lighter")
    private WebElement searchResult;
    @FindBy(className = "heading-counter")
    private WebElement numberOfResultsText;
    @FindBy(className = "alert-warning")
    private WebElement noSearchResultsInfo;

    public boolean isSearchResultDisplayed() {
        return searchResult.isDisplayed();
    }
    public boolean isNumberOfResultsDisplayed() {
        return numberOfResultsText.isDisplayed();
    }
    public String isSearchResultsNameCorrect() {
        return searchResult.getText();
    }
    public String isSearchResultInfoCorrect() {
        return noSearchResultsInfo.getText();
    }
    public boolean isSearchResultInfoDisplayed() {
        return noSearchResultsInfo.isDisplayed();
    }

}
