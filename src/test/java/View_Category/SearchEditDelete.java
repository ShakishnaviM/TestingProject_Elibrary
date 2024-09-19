package View_Category;

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

    // Method to navigate to the "View category" page
    public void navigateToViewCategory() throws InterruptedException {
        
        driver.findElement(By.xpath("//span[text()='Manage Category']")).click();
        driver.findElement(By.xpath("//a[text()='View Category']")).click();
        Thread.sleep(1000);  // Wait for the page to load
    }

    @Test
    public void TC1_search() throws InterruptedException {
        // Navigate to View Book before performing the search in TC1
        navigateToViewCategory();

        // Perform search action
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("5678");
        
        // Edit the category with ID=1
        driver.findElement(By.xpath("//a[@href='edit-category.php?id=1']")).click();
        Thread.sleep(3000);
    }

    @Test
    public void TC2_search() throws InterruptedException {
        // Navigate to View category before performing the search in TC2
        navigateToViewCategory();

        // Perform search action
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("5678");
        
        // View the category with ID=1
        driver.findElement(By.xpath("//a[@href='view-category.php?ids=1']")).click();
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
