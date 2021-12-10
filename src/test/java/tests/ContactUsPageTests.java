package tests;

import base.TestBase;
import navigation.ContactUsPage;
import navigation.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactUsPageTests extends TestBase {
    ContactUsPage contactUsPage = new ContactUsPage(driver);
    HomePage homePage = new HomePage(driver);

    private static final String EXISTING_EMAIL = "NPniasdhuu@niepodam.pl";
    private static final String MESSAGE_TEXT = "Test";
    private static final String INFORMATION_ALERT_SUCCESS = "Your message has been successfully sent to our team.";
    private static final String INFORMATION_ALERT_FAIL = "Please select a subject from the list provided.";

    @Test
    void shouldSendAMessageProperly() {
        homePage.clickContactUs();
        Assertions.assertTrue(contactUsPage.isOnContactUsPage());
        contactUsPage.clickAndChooseSubjectHeading();
        contactUsPage.fillEmailBoxAndMessageAreaAndClick(EXISTING_EMAIL, MESSAGE_TEXT);
        Assertions.assertEquals(INFORMATION_ALERT_SUCCESS, contactUsPage.isMessageSend());
    }
    @Test
    void shouldNotSendAMessageProperly() {
        homePage.clickContactUs();
        Assertions.assertTrue(contactUsPage.isOnContactUsPage());
        contactUsPage.fillEmailBoxAndMessageAreaAndClick(EXISTING_EMAIL, MESSAGE_TEXT);
        Assertions.assertEquals(INFORMATION_ALERT_FAIL, contactUsPage.isMessageSend());
    }

}
