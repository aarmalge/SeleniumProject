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

public class WishList {
    WebDriver driver;
    String url = "https://demowebshop.tricentis.com/";

    @BeforeClass
    public void setUp() {driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @Test
    public void Wishlist() {

        driver.findElement(By.xpath("//a[@href='/wishlist']"));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }}