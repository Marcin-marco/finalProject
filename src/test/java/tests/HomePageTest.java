package tests;

import base.TestBase;
import navigation.ContactUsPage;
import navigation.HomePage;
import navigation.SearchResultsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageTest extends TestBase {
    HomePage homePage = new HomePage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);

    private static final String EXISTING_PRODUCT = "dress";
    private static final String NOT_EXISTING_PRODUCT = "red carpet";
    private static final String EMPTY_QUERY = "";
    private static final String SEARCHING_RESULT_NAME = "\"DRESS\"";
    private static final String SEARCHING_RESULT_INFO = "No results were found for your search \"red carpet\"";
    private static final String SHOPPING_CART_TEXT = "Cart (empty)";


    @Test
    void shouldContainLogoAndSearchBoxOnTheHomePageAndLoginPage() {
        Assertions.assertTrue(homePage.isWebLogoOnPage());
        Assertions.assertTrue(homePage.isSearchBoxOnPage());
        homePage.clickSingIn();
        Assertions.assertTrue(homePage.isWebLogoOnPage());
        Assertions.assertTrue(homePage.isSearchBoxOnPage());
    }

    @Test
    void shouldGetSearchResultsPageWhenClickSearchButton() {
        homePage.searchProductAndClickSearchButton(EXISTING_PRODUCT);
        Assertions.assertTrue(searchResultsPage.isSearchResultDisplayed());
        Assertions.assertTrue(searchResultsPage.isNumberOfResultsDisplayed());
    }

    @Test
    void shouldGetSearchResultsPageWhenClickEnterKey() {
        homePage.searchProductAndClickEnterKey(EXISTING_PRODUCT);
        Assertions.assertTrue(searchResultsPage.isSearchResultDisplayed());
        Assertions.assertTrue(searchResultsPage.isNumberOfResultsDisplayed());
    }

    @Test
    void shouldFindExistingProduct() {
        homePage.searchProductAndClickSearchButton(EXISTING_PRODUCT);
        Assertions.assertEquals(SEARCHING_RESULT_NAME, searchResultsPage.isSearchResultsNameCorrect());
        Assertions.assertTrue(searchResultsPage.isNumberOfResultsDisplayed());
    }

    @Test
    void shouldNotFindNotExistingProduct() {
        homePage.searchProductAndClickSearchButton(NOT_EXISTING_PRODUCT);
        Assertions.assertEquals(SEARCHING_RESULT_INFO, searchResultsPage.isSearchResultInfoCorrect());
    }

    @Test
    void shouldGetResultsPageWhenQueryIsEmpty() {
        homePage.searchProductAndClickSearchButton(EMPTY_QUERY);
        Assertions.assertTrue(searchResultsPage.isSearchResultInfoDisplayed());
    }

    @Test
    void shouldGetContactUsPage() {
        homePage.clickContactUs();
        Assertions.assertTrue(contactUsPage.isOnContactUsPage());
    }

    @Test
    void shouldAddProductToCartProperly() {
        homePage.clickOnSomeProduct();
        homePage.clickAddToCart();
        Assertions.assertTrue(homePage.isProductAddCorrect());
    }

    @Test
    void shouldRemoveAddedProductProperly() {
        homePage.clickOnSomeProduct();
        homePage.clickAddToCart();
        homePage.clickShoppingCartAndRemoveProduct();
        homePage.clickShoppingCart();
        Assertions.assertEquals(SHOPPING_CART_TEXT, homePage.isShoppingCartEmpty());
    }


}
