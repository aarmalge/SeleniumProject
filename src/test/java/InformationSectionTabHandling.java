import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class InformationSectionTabHandling {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Navigate to DemoWebShop
            driver.get("http://demowebshop.tricentis.com");
            String mainWindow = driver.getWindowHandle();
            System.out.println("Main Window Handle: " + mainWindow);

            // Open Sitemap tab
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sitemap']"))).click();

            // Open Shipping & Returns tab
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Shipping & Returns']"))).click();

            // Open Privacy Notice tab
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Privacy Notice']"))).click();

            // Open Conditions of Use tab
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Conditions of Use']"))).click();

            // Open About us tab
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='About us']"))).click();

            // Open Contact us tab
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Contact us']"))).click();

            // Wait a moment for all windows/tabs to open
            Thread.sleep(2000);  // brief pause to ensure all tabs open

            // Get all window handles
            Set<String> allWindows = driver.getWindowHandles();

            // Iterate through windows except main
            for (String windowHandle : allWindows) {
                if (!windowHandle.equals(mainWindow)) {
                    driver.switchTo().window(windowHandle);
                    // Wait for page title to load completely
                    wait.until(ExpectedConditions.titleIs(driver.getTitle()));
                    System.out.println("Switched to Window: " + driver.getTitle());
                }
            }

            // Switch back to main window
            driver.switchTo().window(mainWindow);
            System.out.println("Switched back to Main Window: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close all windows
            driver.quit();
        }
    }
}