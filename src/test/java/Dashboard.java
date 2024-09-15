import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dashboard {
    ChromeDriver driver;

    @BeforeTest 
    public void GetIn() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("http://localhost/E_library/Library_Management_admin_PHP/admin/");

       
        driver.findElement(By.id("inputEmail")).sendKeys("admin@library.com");

        driver.findElement(By.id("inputPassword")).sendKeys("Admin@123#$");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);

        
    }

    @Test

    public void ClickManageBook() throws InterruptedException{
    
        driver.findElement(By.xpath("//span[text()='Manage Books']")).click();
        Thread.sleep(3000);
 
    }

    @Test

    public void ManageCategory() throws InterruptedException{
    
        driver.findElement(By.xpath("//span[text()='Manage Category']")).click();
        Thread.sleep(3000);
 
    }

    @Test

    public void BookissueRequest() throws InterruptedException{
    
        driver.findElement(By.xpath("//span[text()='Book Issue Requests']")).click();
        Thread.sleep(3000);
 
    }

    @Test

    public void ManagePlace() throws InterruptedException{
    
        driver.findElement(By.xpath("//span[text()='Manage Place']")).click();
        Thread.sleep(3000);
 
    }

    @Test

    public void ManageRequest() throws InterruptedException{
    
        driver.findElement(By.xpath("//span[text()='Manage Users']")).click();
        Thread.sleep(3000);
 
    }



    
    @AfterTest
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
    }

    
}
