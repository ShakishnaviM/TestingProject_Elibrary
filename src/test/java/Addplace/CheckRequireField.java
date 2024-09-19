package Addplace;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckRequireField {

    ChromeDriver driver;

    @BeforeTest 
    public void GetIn() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("http://localhost/E_library/Library_Management_admin_PHP/admin/");

        // Log in to the admin panel
        driver.findElement(By.id("inputEmail")).sendKeys("admin@library.com");
        driver.findElement(By.id("inputPassword")).sendKeys("Admin@123#$");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);

        // Navigate to Add place page
        driver.findElement(By.xpath("//span[text()='Manage Place']")).click();
        driver.findElement(By.xpath("//a[text()='Add Place']")).click();
        

        
    }

    //leave a space in the place name field
    
    @Test
    public void TC_1() throws InterruptedException{
                 
        driver.findElement(By.id("place_name")).sendKeys("");

        driver.findElement(By.id("status")).click();
        driver.findElement(By.xpath("//option[@value='1']")).click();

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000); // Wait for form submission


        
    }

    //Empty space in status field
    @Test
    public void TC_2() throws InterruptedException{
        driver.findElement(By.id("place_name")).sendKeys("Nuwara eliy");

        driver.findElement(By.id("status")).click();
        driver.findElement(By.xpath("//option[@value='']")).click();

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000); // Wait for form submission

        
    }

    
    @AfterTest
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }

}
    
}
