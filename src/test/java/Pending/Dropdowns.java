package Pending;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class Dropdowns {
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
    public void testSortByDropdown() {
        List<WebElement> options = driver.findElements(By.xpath("//select[@id='products-orderby']"));

        for (WebElement option : options) {
            WebElement sortByDropdown = driver.findElement(By.id("products-orderby"));
            Select select = new Select(sortByDropdown);
            select.selectByVisibleText(option.getText());
            String selectedOption = select.getFirstSelectedOption().getText();
            System.out.println("Selected: " + selectedOption);
            Assert.assertEquals(selectedOption, option.getText(), "Dropdown selection failed for: " + option.getText());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
