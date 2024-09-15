package View_Book;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchBar {

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

    // Method to navigate to the "View Book" page
    public void navigateToViewBook() throws InterruptedException {
        // Navigate to Manage Books and then View Book
        driver.findElement(By.xpath("//span[text()='Manage Books']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='View Book']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TC1_search() throws InterruptedException {
        // Navigate to View Book before performing the search in TC1
        navigateToViewBook();

        // Perform search action
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("sumal");
        
        // Edit the book with ID=1
        driver.findElement(By.xpath("//a[@href='edit-book.php?id=1']")).click();
        Thread.sleep(3000);
    }

    @Test
    public void TC2_search() throws InterruptedException {
        // Navigate to View Book before performing the search in TC2
        navigateToViewBook();

        // Perform search action
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("sumal");
        
        // View the book with ID=1
        driver.findElement(By.xpath("//a[@href='view-book.php?ids=1']")).click();
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
