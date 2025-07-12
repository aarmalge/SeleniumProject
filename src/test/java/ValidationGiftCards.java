import Base.Baseclass;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class ValidationGiftCards  extends Baseclass {
@Test
    public static void dropdown(){
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/books");
          WebElement dd= driver.findElement(By.id("products-orderby"));
    Select select= new Select(dd);

    List<WebElement> options= select.getOptions();
       for (WebElement option: options){
           System.out.println(option.getText());
       }
select.selectByVisibleText("Price: Low to High");





    }

}
