import Base.Baseclass;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class LogInvalidCred extends Baseclass {
    WebDriver driver;
    String url = "https://demowebshop.tricentis.com/login";



    @Test
    public void loginWithInvalidCredentials() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("Email")).sendKeys("invaliduser@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("wrongpass");
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();
        WebElement errorMessage = driver.findElement(By.cssSelector("div.message-error"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for invalid credentials");
        Thread.sleep(2000);
        TakesScreenshot screenshot= (TakesScreenshot) driver;
        File tempfile= screenshot.getScreenshotAs(OutputType.FILE);
        File destfile= new File("C:\\Projects\\New folder\\screenshots\\error.png");
        FileUtils.copyFile(tempfile,destfile);
    }}

