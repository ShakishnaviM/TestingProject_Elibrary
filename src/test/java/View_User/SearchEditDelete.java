package View_User;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchEditDelete {

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

    // Method to navigate to the "View user" page
    public void navigateToViewUser() throws InterruptedException {
        
        
        driver.findElement(By.xpath("//span[text()='Manage Users']")).click();
        driver.findElement(By.xpath("//a[text()='View Users']")).click();
        Thread.sleep(1000);  
    }

    @Test
    public void TC1_search() throws InterruptedException {
        // Navigate to View  user before performing the search in TC1
        navigateToViewUser();

        
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("vishaka");
        
        // Edit the user with ID=2
        driver.findElement(By.xpath("//a[@href='edit-user.php?id=2']")).click();
        Thread.sleep(3000);
    }

    @Test
    public void TC2_search() throws InterruptedException {
        
        navigateToViewUser();

        // Perform search action
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("vishaka");
        
        // View the user with ID=2
        driver.findElement(By.xpath("//a[@href='view-users.php?ids=2']")).click();
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
