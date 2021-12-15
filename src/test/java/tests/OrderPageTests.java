package tests;

import base.TestBase;
import navigation.HomePage;
import navigation.LoginPage;
import navigation.OrderPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderPageTests extends TestBase {
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    OrderPage orderPage = new OrderPage(driver);
    private static final String EXISTING_USER_EMAIL = "NPniasdhuu@niepodam.pl";
    private static final String EXISTING_USER_PASSWORD = "Pass12!";
    private static final String ORDER_CONFIRMATION = "ORDER CONFIRMATION";
    private static final String PAGE_HEADER = "AUTHENTICATION";

    @Test
    void shouldMakeThePurchaseProperly() {
        homePage.clickOnSomeProduct();
        homePage.clickAddToCart();
        orderPage.clickCheckoutButton();
        orderPage.clickCheckoutButton();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        orderPage.clickConfirmAddressButton();
        orderPage.clickCheckboxTermsButtonAndSubmit();
        orderPage.clickPayByBankButtonAndConfirmOrder();
        Assertions.assertEquals(ORDER_CONFIRMATION, orderPage.isOrderComplete());
    }
    @Test
    void shouldNotMakeThePurchaseWithoutLogin() {
        homePage.clickOnSomeProduct();
        homePage.clickAddToCart();
        orderPage.clickCheckoutButton();
        orderPage.clickCheckoutButton();
        Assertions.assertEquals(PAGE_HEADER, loginPage.isAuthenticationTextDisplayed());
    }
    @Test
    void shouldNotMakeThePurchaseWithoutCheckedTermsOfService() {
        homePage.clickOnSomeProduct();
        homePage.clickAddToCart();
        orderPage.clickCheckoutButton();
        orderPage.clickCheckoutButton();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        orderPage.clickConfirmAddressButton();
        orderPage.clickConfirmShippingButton();
        Assertions.assertTrue(orderPage.isDeliveryAlertOnOrderPage());
    }
}
