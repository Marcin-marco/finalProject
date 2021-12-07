package tests;

import base.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import navigation.LoginPage;

public class LoginTests extends TestBase {

    LoginPage loginPage = new LoginPage(driver);
    private static final String EXISTING_USER_EMAIL = "NPniasdhuu@niepodam.pl";
    private static final String EXISTING_USER_PASSWORD = "Pass12!";
    private static final String NOT_EXISTING_USER_EMAIL = "NPniasdhuu@niepodam.pl";;
    private static final String NOT_EXISTING_USER_PASSWORD = "Pass1232@";
    private static final String INVALID_USER_EMAIL = "<NPniasdhuu> @  niepodam.pl";

    @Test
    void shouldLoginProperly() {
        driver.findElement(By.className("header_user_info")).click();
        loginPage.enterUserEmail(EXISTING_USER_EMAIL);
        loginPage.enterUserPassword(EXISTING_USER_PASSWORD);
        loginPage.login();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
    }
    @Test
    void shouldNotLoginProperly() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.findElement(By.className("header_user_info")).click();
        loginPage.enterUserEmail(NOT_EXISTING_USER_EMAIL);
        loginPage.enterUserPassword(NOT_EXISTING_USER_PASSWORD);
        loginPage.login();
        Assertions.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
    @Test
    void shouldNotLoginWithoutEmail() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.findElement(By.className("header_user_info")).click();
        loginPage.enterUserPassword(EXISTING_USER_PASSWORD);
        loginPage.login();
        Assertions.assertEquals("An email address required.",driver.findElement(By.xpath("//*[@id=\"center_column\"]//li")).getText());
    }
    @Test
    void shouldNotLoginWithoutPassword() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.findElement(By.className("header_user_info")).click();
        loginPage.enterUserEmail(EXISTING_USER_EMAIL);
        loginPage.login();
        Assertions.assertEquals("Password is required.",driver.findElement(By.xpath("//*[@id=\"center_column\"]//li")).getText());
    }
    @Test
    void shouldNotLoginWithInvalidEmail() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.findElement(By.className("header_user_info")).click();
        loginPage.enterUserEmail(INVALID_USER_EMAIL);
        loginPage.enterUserPassword(EXISTING_USER_PASSWORD);
        loginPage.login();
        Assertions.assertEquals("Invalid email address.",driver.findElement(By.xpath("//*[@id=\"center_column\"]//li")).getText());
    }
}
