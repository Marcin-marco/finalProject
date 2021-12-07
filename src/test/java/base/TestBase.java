package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    protected static WebDriver driver;
    private static final String WEBSITE_NAME = "http://automationpractice.com/index.php";

    @BeforeAll
    static void warmUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(WEBSITE_NAME);
    }

    @AfterAll
    static void tearDown() {
        driver.close();
    }
}


