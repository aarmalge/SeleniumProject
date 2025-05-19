import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class VerifyDropdowns {
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
    public void testPositionOption() throws InterruptedException {
        selectDropdownOptionByIndex(0);
    }

    @Test
    public void testNameOption() throws InterruptedException {
        selectDropdownOptionByIndex(1);

    }

    @Test
    public void testPriceLowToHighOption() throws InterruptedException {
        selectDropdownOptionByIndex(2);

    }

    @Test
    public void testPriceHighToLowOption() throws InterruptedException {
        selectDropdownOptionByIndex(3);

    }

    @Test
    public void testCreatedOnOption() throws InterruptedException {
        selectDropdownOptionByIndex(4);

    }

    @Test
    public void testProductRatingOption() throws InterruptedException {
        selectDropdownOptionByIndex(5);

    }

    private void selectDropdownOptionByIndex(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement sortByDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products-orderby")));
        Select select = new Select(sortByDropdown);
        List<WebElement> options = select.getOptions();

        if (index < options.size()) {
            String optionText = options.get(index).getText();
            select.selectByVisibleText(optionText);
            String selectedOption = select.getFirstSelectedOption().getText();
            System.out.println("Selected: " + selectedOption);
            Assert.assertEquals(selectedOption, optionText, "Dropdown selection failed for: " + optionText);
        } else {
            System.out.println("Invalid index: " + index);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
