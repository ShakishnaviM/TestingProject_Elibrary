import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    ChromeDriver driver;

    @Test // it is coming from the testNG
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/v4/");
        driver.findElement(By.name("uid")).sendKeys("mngr584051");

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("tAqAbEt");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Assert.assertEquals(); it is used to check whether used username and system loggedin username are same.
    }
}
