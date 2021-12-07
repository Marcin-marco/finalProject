package tests;

import base.TestBase;
import navigation.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage(driver);
    private static final String EXISTING_USER_EMAIL = "NPniasdhuu@niepodam.pl";
    private static final String EXISTING_USER_PASSWORD = "Pass12!";
    private static final String NOT_EXISTING_USER_EMAIL = "NPniasdhuu@niepodam.pl";
    private static final String NOT_EXISTING_USER_PASSWORD = "Pass1232@";
    private static final String INVALID_USER_EMAIL = "<NPniasdhuu> @  niepodam.pl";

    @Test
    void shouldLoginProperly() {
        loginPage.clickSingIn();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }
    @Test
    void shouldNotLoginProperly() {
        loginPage.clickSingIn();
        loginPage.login(NOT_EXISTING_USER_EMAIL, NOT_EXISTING_USER_PASSWORD );
        Assertions.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
    @Test
    void shouldNotLoginWithoutEmail() {
        loginPage.clickSingIn();
        loginPage.enterUserPassword(EXISTING_USER_PASSWORD);
        loginPage.clickSubmitButton();
        Assertions.assertEquals("An email address required.",driver.findElement(By.xpath("//*[@id=\"center_column\"]//li")).getText());
    }
    @Test
    void shouldNotLoginWithoutPassword() {
        loginPage.clickSingIn();
        loginPage.enterUserEmail(EXISTING_USER_EMAIL);
        loginPage.clickSubmitButton();
        Assertions.assertEquals("Password is required.",driver.findElement(By.xpath("//*[@id=\"center_column\"]//li")).getText());
    }
    @Test
    void shouldNotLoginWithInvalidEmail() {
        loginPage.clickSingIn();
        loginPage.login(INVALID_USER_EMAIL, EXISTING_USER_PASSWORD);
        Assertions.assertEquals("Invalid email address.",driver.findElement(By.xpath("//*[@id=\"center_column\"]//li")).getText());
    }
    @Test
    void shouldLogoutProperly() {
        loginPage.clickSingIn();
        loginPage.login(EXISTING_USER_EMAIL, EXISTING_USER_PASSWORD);
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
        loginPage.clickSignOut();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=authentication&back=my-account"));
    }
}
