package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baseclass {
        public WebDriver driver;

        @BeforeMethod
        public void setUp() {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demowebshop.tricentis.com");
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }
