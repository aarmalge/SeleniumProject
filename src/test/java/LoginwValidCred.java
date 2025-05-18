import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginwValidCred {
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
    public void loginWithInvalidCredentials() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("Email")).sendKeys("rootuser@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("root123");
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();
        driver.findElement(By.xpath("//a[@href='/logout']")).click();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

