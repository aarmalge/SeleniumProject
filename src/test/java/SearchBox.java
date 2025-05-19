import org.openqa.selenium.Alert;
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

public class SearchBox {
    WebDriver driver;
    String url = "https://demowebshop.tricentis.com/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @Test
    public void testSearchBox() {
        String searchKeyword = "book";

        // Enter keyword in search box
        WebElement searchBox = driver.findElement(By.id("small-searchterms"));
        searchBox.clear();
        searchBox.sendKeys("book");

    }

    @Test
    public void testEmpty() {

        // Enter keyword in search box
        WebElement searchBox = driver.findElement(By.id("small-searchterms"));
        searchBox.clear();
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();

        Alert alert = driver.switchTo().alert();
        alert.getText();
        System.out.println(alert.getText());
        alert.accept();

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
