package View_place;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class searchEditDelete {

    
     ChromeDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://localhost/E_library/Library_Management_admin_PHP/admin/");
        driver.manage().window().maximize();

        // Log in to the admin panel
        driver.findElement(By.id("inputEmail")).sendKeys("admin@library.com");
        driver.findElement(By.id("inputPassword")).sendKeys("Admin@123#$");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
    }

    // Method to navigate to the "View place" page
    public void navigateToViewPlace() throws InterruptedException {
        
        
        driver.findElement(By.xpath("//span[text()='Manage Place']")).click();
        driver.findElement(By.xpath("//a[text()='View Place']")).click();
        Thread.sleep(1000);  
    }

    @Test
    public void TC1_search() throws InterruptedException {
        // Navigate to View View place before performing the search in TC1
        navigateToViewPlace();

        
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("12345");
        
        // Edit the place with ID=1
        driver.findElement(By.xpath("//a[@href='edit-place.php?id=1']")).click();
        Thread.sleep(3000);
    }

    @Test
    public void TC2_search() throws InterruptedException {
        
        navigateToViewPlace();

        // Perform search action
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("12345");
        
        // View the place with ID=1
        driver.findElement(By.xpath("//a[@href='view-place.php?ids=1']")).click();
        Thread.sleep(3000);
    }

    @AfterTest
    public void tearDown() {
        // Close the browser after all tests are done
        if (driver != null) {
            driver.quit();
        }
    }
    
}
