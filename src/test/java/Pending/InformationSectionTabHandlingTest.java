package Pending;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

public class InformationSectionTabHandlingTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // Navigate to DemoWebShop
        driver.get("http://demowebshop.tricentis.com");
        String mainWindow = driver.getWindowHandle();
        System.out.println("Main Window Handle: " + mainWindow);

        // Open Sitemap tab
        driver.findElement(By.xpath("//a[text()='Sitemap']")).click();
        Thread.sleep(1000);

        // Open Shipping & Returns tab
        driver.findElement(By.xpath("//a[text()='Shipping & Returns']")).click();
        Thread.sleep(1000);

        // Open Privacy Notice tab
        driver.findElement(By.xpath("//a[text()='Privacy Notice']")).click();
        Thread.sleep(1000);

        // Open Conditions of Use tab
        driver.findElement(By.xpath("//a[text()='Conditions of Use']")).click();
        Thread.sleep(1000);

        // Open About us tab
        driver.findElement(By.xpath("//a[text()='About us']")).click();
        Thread.sleep(1000);

        // Open Contact us tab
        driver.findElement(By.xpath("//a[text()='Contact us']")).click();
        Thread.sleep(1000);

        // Get all window handles
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();

        // Iterate through the windows
        while (iterator.hasNext()) {
            String windowHandle = iterator.next();
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to Window: " + driver.getTitle());
                Thread.sleep(1000);
            }
        }

        // Switch back to the main window
        driver.switchTo().window(mainWindow);
        System.out.println("Switched back to Main Window: " + driver.getTitle());

        // Close all windows
        driver.quit();
    }
}
