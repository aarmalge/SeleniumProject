import Base.Baseclass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class WishList extends Baseclass{



    @Test
    public void Wishlist() {

        driver.findElement(By.xpath("//a[@href='/wishlist']")).click();

    }}