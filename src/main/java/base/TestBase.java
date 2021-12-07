package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    private static final String WEBSITE_NAME = "http://automationpractice.com/index.php";

    @BeforeAll
    static void warmUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(WEBSITE_NAME);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterAll
    static void tearDown() {
        driver.close();
    }
}


