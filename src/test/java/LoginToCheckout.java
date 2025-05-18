import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import helper.SikuliHelper;

import java.time.Duration;

public class LoginToCheckout {

    WebDriver driver;
    WebDriverWait wait;
    SikuliHelper sikuliHelper;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        sikuliHelper = new SikuliHelper();
    }

    @Test
    public void loginAndCheckoutTest() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/login");

        // Login
        driver.findElement(By.id("Email")).sendKeys("rootuser@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("root123");
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        Thread.sleep(2000);  // You can replace this with a better explicit wait if possible

        // Handle popup using SikuliHelper
        String okButtonImage = "src/main/resources/ok_button.png";
        sikuliHelper.clickOkButton(okButtonImage);

        // Select gift card
        driver.findElement(By.linkText("$25 Virtual Gift Card")).click();

        // Fill gift card details
        driver.findElement(By.id("giftcard_2_RecipientName")).sendKeys("giftcard");
        driver.findElement(By.id("giftcard_2_RecipientEmail")).sendKeys("giftcard@gmail.com");
        driver.findElement(By.id("giftcard_2_SenderName")).sendKeys("abcd");
        driver.findElement(By.id("giftcard_2_SenderEmail")).sendKeys("abcd@gmail.com");
        driver.findElement(By.id("giftcard_2_Message")).sendKeys("Happy Birthday");

        // Change quantity
        WebElement quantity = driver.findElement(By.id("addtocart_2_EnteredQuantity"));
        quantity.clear();
        quantity.sendKeys("3");

        // Add to cart
        driver.findElement(By.id("add-to-cart-button-2")).click();

        // Go to cart
        driver.findElement(By.xpath("//a[@href='/cart']")).click();

        // Accept terms and checkout
        driver.findElement(By.id("termsofservice")).click();

    }}