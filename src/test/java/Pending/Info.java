package Pending;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Info {
    WebDriver driver;
    String url = "https://demowebshop.tricentis.com/books";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @Test
    public void verifyInformationLinks() {
        String[] expectedLinks = {"Sitemap", "Shipping & Returns", "Privacy Notice", "Conditions of Use", "About Us", "Contact Us"};
        List<WebElement> infoLinks = driver.findElements(By.cssSelector("div.footer-menu li a"));

        for (int i = 0; i < expectedLinks.length; i++) {
            WebElement link = infoLinks.get(i);
            String linkText = link.getText();
            String href = link.getAttribute("href");
            System.out.println("Testing link: " + linkText + " | URL: " + href);
            Assert.assertEquals(linkText, expectedLinks[i], "Link text does not match: " + linkText);
            link.click();
            Assert.assertTrue(driver.getTitle().length() > 0, "Page title is empty for: " + linkText);
            driver.navigate().back();
            infoLinks = driver.findElements(By.cssSelector("div.footer-menu li a"));
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
