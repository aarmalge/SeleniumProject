import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginwEmptyCred {
    WebDriver driver;
    String url = "https://demowebshop.tricentis.com/login";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @Test
    public void LogInvalidCred() {
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div.message-error"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for empty credentials");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}




