import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.python.modules._hashlib;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Categories {

    WebDriver driver;
    String baseUrl = "http://demowebshop.tricentis.com/";

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(baseUrl);
    }

    @Test (priority = 1)
    public void testBooks() {
        WebElement books = driver.findElement(By.linkText("Books"));
        books.click();
        driver.navigate().back();
    }

    @Test(priority = 2)
    public void testComputers() {
        WebElement computer = driver.findElement(By.linkText("COMPUTERS"));
        computer.click();
        driver.navigate().back();
    }

    @Test (priority = 3)
    public void testElectronics() {
        WebElement Electronics = driver.findElement(By.linkText("ELECTRONICS"));
        Electronics.click();
        driver.navigate().back();

    }

    @Test (priority = 4)
    public void testApparel() {
        WebElement Apparel = driver.findElement(By.linkText("APPAREL & SHOES"));
        Apparel.click();
        driver.navigate().back();
    }

    @Test(priority = 5)
    public void testDownloads() {
        WebElement downloads = driver.findElement(By.linkText("DIGITAL DOWNLOADS"));
        downloads.click();
        driver.navigate().back();
    }
    @Test (priority = 6)
    public void testJewelery() {
        WebElement jwelery = driver.findElement(By.linkText("JEWELRY"));
        jwelery.click();
        driver.navigate().back();
    }

    @Test (priority = 7)
    public void testGiftcard() {
        WebElement giftcard = driver.findElement(By.linkText("GIFT CARDS"));
        driver.navigate().back();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
