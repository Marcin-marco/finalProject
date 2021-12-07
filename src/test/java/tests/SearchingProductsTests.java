package tests;

import base.TestBase;
import navigation.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SearchingProductsTests extends TestBase {
    MainPage mainPage = new MainPage(driver);

    private static final String EXISTING_PRODUCT = "dress";
    private static final String NOT_EXISTING_PRODUCT = "red carpet";
    private static final String EMPTY_QUERY = "";

    @Test
    void shouldGetSearchResultsPageWhenClickSearchButton() {
        mainPage.searchProductAndClickSearchButton(EXISTING_PRODUCT);
        Assertions.assertTrue(driver.findElement(By.className("product-listing")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.className("heading-counter")).isDisplayed());
    }

    @Test
    void shouldGetSearchResultsPageWhenClickEnterKey() {
        mainPage.searchProductAndClickEnterKey(EXISTING_PRODUCT);
        Assertions.assertTrue(driver.findElement(By.className("product-listing")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.className("heading-counter")).isDisplayed());
    }
    @Test
    void shouldFindExistingProduct() {
        mainPage.searchProductAndClickSearchButton(EXISTING_PRODUCT);
        Assertions.assertEquals("\"DRESS\"", driver.findElement(By.className("lighter")).getText());
        Assertions.assertTrue(driver.findElement(By.className("heading-counter")).isDisplayed());
    }
    @Test
    void shouldNotFindNotExistingProduct() {
        mainPage.searchProductAndClickSearchButton(NOT_EXISTING_PRODUCT);
        Assertions.assertEquals("No results were found for your search \"red carpet\"", driver.findElement(By.className("alert-warning")).getText());
    }
    @Test
    void shouldGetResultsPageWhenQueryIsEmpty() {
        mainPage.searchProductAndClickSearchButton(EMPTY_QUERY);
        Assertions.assertTrue(driver.findElement(By.className("alert-warning")).isDisplayed());
    }
    @Test
    void shouldBeGridViewInSearchResultsPage() {
        mainPage.searchProductAndClickSearchButton(EXISTING_PRODUCT);
        Assertions.assertTrue(driver.findElement(By.id("grid")).isDisplayed());
    }
    @Test
    void shouldBeListViewInSearchResultsPage() {
        mainPage.searchProductAndClickSearchButton(EXISTING_PRODUCT);
        Assertions.assertTrue(driver.findElement(By.id("list")).isDisplayed());
    }

}
