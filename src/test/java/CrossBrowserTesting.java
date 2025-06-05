import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CrossBrowserTesting {
    WebDriver driver;
    @Parameters("browser")
        @BeforeTest
                public void setup(String browser) {

            if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
            driver.get("https://demowebshop.tricentis.com/build-your-own-expensive-computer-2");



        }

        @Test
    public void elementlocating() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By locator = By.xpath("//label[contains(text(),'Image Viewer  [+5.00]')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        }

        @AfterClass
                public void after(){
        driver.quit();
    }}


