import Base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginwEmptyCred extends Baseclass {


    @Test
    public void LogInvalidCredentials() {
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.cssSelector("input.button-1.login-button")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("div.message-error"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed for empty credentials");
    }

}




