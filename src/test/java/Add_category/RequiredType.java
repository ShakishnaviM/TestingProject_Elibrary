package Add_category;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RequiredType {

    ChromeDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://localhost/E_library/Library_Management_admin_PHP/admin/");

        // Log in to the admin panel
        driver.findElement(By.id("inputEmail")).sendKeys("admin@library.com");
        driver.findElement(By.id("inputPassword")).sendKeys("Admin@123#$");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
    }

    @BeforeMethod
    public void navigateToAddCategory() throws InterruptedException {
        // Navigate to Add Category page
        driver.findElement(By.xpath("//span[text()='Manage Category']")).click();
        driver.findElement(By.xpath("//a[text()='Add Category']")).click();
        Thread.sleep(1000);  // Wait for the page to load
    }

    // Add category with empty category name
    @Test
    public void TC1() throws InterruptedException {
        driver.findElement(By.id("category_name")).clear();  // Clear any existing input
        driver.findElement(By.id("category_name")).sendKeys("5678");  // Leave it empty

        driver.findElement(By.id("status")).click();
        driver.findElement(By.xpath("//option[@value='1']")).click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }

   
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
