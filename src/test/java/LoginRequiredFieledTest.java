import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginRequiredFieledTest {
    ChromeDriver driver;

    @BeforeTest 
    public void GetIn(){
        driver = new ChromeDriver();
        driver.get("http://localhost/E_library/Library_Management_admin_PHP/admin/");
        

        
    }

    //providing incorrect user name and correct password
    
    @Test
    public void TC_1() throws InterruptedException{
        driver.findElement(By.id("inputEmail")).clear();
        driver.findElement(By.id("inputPassword")).clear();          
        driver.findElement(By.id("inputEmail")).sendKeys("admin@libraryll.com");

        driver.findElement(By.id("inputPassword")).sendKeys("Admin@123#$");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(3000);
    }

    //providing correct user name and incorrect password
    @Test
    public void TC_2() throws InterruptedException{
        driver.findElement(By.id("inputEmail")).clear();
        driver.findElement(By.id("inputPassword")).clear();
        driver.findElement(By.id("inputEmail")).sendKeys("admin@library.com");

        driver.findElement(By.id("inputPassword")).sendKeys("Admin@123#$$$");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
    }

    //providing correct user name and incorrect password

    @Test
    public void TC_3() throws InterruptedException{
        driver.findElement(By.id("inputEmail")).clear();
        driver.findElement(By.id("inputPassword")).clear();
        driver.findElement(By.id("inputEmail")).sendKeys("admin@librarylib.com");

        driver.findElement(By.id("inputPassword")).sendKeys("Admin@123#$$$");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
    }

    //Leaving space in username fieled
@Test
public void TC_5() throws InterruptedException{
    driver.findElement(By.id("inputEmail")).clear();
        driver.findElement(By.id("inputPassword")).clear();
    driver.findElement(By.id("inputEmail")).sendKeys("");

    driver.findElement(By.id("inputPassword")).sendKeys("Admin@123#$");

    driver.findElement(By.xpath("//input[@type='submit']")).click();
    Thread.sleep(3000);
}
    
//Leaving space in username fieled
    @Test
    public void TC_6() throws InterruptedException{
        driver.findElement(By.id("inputEmail")).clear();
        driver.findElement(By.id("inputPassword")).clear();
        driver.findElement(By.id("inputEmail")).sendKeys("admin@library.com");

        driver.findElement(By.id("inputPassword")).sendKeys("");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
    }

    //Enter correct user name and password
      @Test
    public void TC_7() throws InterruptedException{
        driver.findElement(By.id("inputEmail")).clear();
        driver.findElement(By.id("inputPassword")).clear();
        driver.findElement(By.id("inputEmail")).sendKeys("admin@library.com");

        driver.findElement(By.id("inputPassword")).sendKeys("Admin@123#$");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
    }
       

    @AfterTest
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}



    
    

}
