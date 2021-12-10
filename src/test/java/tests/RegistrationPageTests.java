package tests;

import base.TestBase;
import navigation.LoginPage;
import navigation.RegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrationPageTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Test
    void shouldRegisterProperly() {
        registrationPage.clickSignInAndFillCreateAccountFieldAndSubmit();
        registrationPage.fillYourPersonalInformationFields();
        registrationPage.fillYourAddressFields();
        registrationPage.clickRegisterButton();
        Assertions.assertTrue(loginPage.isOnMyAccountPage());
    }
    @Test
    void shouldNotRegisterProperly() {
        registrationPage.clickSignInAndFillCreateAccountFieldAndSubmit();
        registrationPage.fillYourPersonalInformationFields();
        registrationPage.clickRegisterButton();
        Assertions.assertFalse(loginPage.isOnMyAccountPage());
    }

}
