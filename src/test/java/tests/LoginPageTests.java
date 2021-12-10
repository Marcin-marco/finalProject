package tests;

import base.TestBase;
import navigation.HomePage;
import navigation.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTests extends TestBase {

    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    private static final String EXISTING_USER_EMAIL = "NPniasdhuu@niepodam.pl";
    private static final String EXISTING_USER_PASSWORD = "Pass12!";
    private static final String NOT_EXISTING_USER_EMAIL = "NPniasdhuu@niepodam.pl";
    private static final String NOT_EXISTING_USER_PASSWORD = "Pass1232@";
    private static final String INVALID_USER_EMAIL = "<NPniasdhuu> @  niepodam.pl";
    private static final String EMAIL_REQUIRED_ALERT = "An email address required.";
    private static final String PASSWORD_REQUIRED_ALERT = "Password is required.";
    private static final String INVALID_USER_EMAIL_ALERT = "Invalid email address.";

    @Test
    void shouldLoginProperly() {
        homePage.clickSingIn();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        Assertions.assertTrue(loginPage.isOnMyAccountPage());
    }

    @Test
    void shouldNotLoginProperly() {
        homePage.clickSingIn();
        loginPage.login(NOT_EXISTING_USER_EMAIL, NOT_EXISTING_USER_PASSWORD);
        Assertions.assertTrue(loginPage.isDisplayedAuthenticationAlert());
    }

    @Test
    void shouldNotLoginWithoutEmail() {
        homePage.clickSingIn();
        loginPage.enterUserPassword(EXISTING_USER_PASSWORD);
        loginPage.clickSubmitButton();
        Assertions.assertEquals(EMAIL_REQUIRED_ALERT, loginPage.verifyTextAlert());
    }

    @Test
    void shouldNotLoginWithoutPassword() {
        homePage.clickSingIn();
        loginPage.enterUserEmail(EXISTING_USER_EMAIL);
        loginPage.clickSubmitButton();
        Assertions.assertEquals(PASSWORD_REQUIRED_ALERT, loginPage.verifyTextAlert());
    }

    @Test
    void shouldNotLoginWithInvalidEmail() {
        homePage.clickSingIn();
        loginPage.login(INVALID_USER_EMAIL, EXISTING_USER_PASSWORD);
        Assertions.assertEquals(INVALID_USER_EMAIL_ALERT, loginPage.verifyTextAlert());
    }

    @Test
    void shouldLogoutProperly() {
        homePage.clickSingIn();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        Assertions.assertTrue(loginPage.isOnMyAccountPage());
        loginPage.clickSignOut();
        Assertions.assertTrue(loginPage.isOnLoginPage());
    }
}
