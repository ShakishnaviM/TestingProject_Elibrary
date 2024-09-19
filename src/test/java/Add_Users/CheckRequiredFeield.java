package Add_Users;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckRequiredFeield {
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

        // Navigate to Add Users page
        driver.findElement(By.xpath("//span[text()='Manage Users']")).click();
        driver.findElement(By.xpath("//a[text()='Add Users']")).click();
    }

    @Test(dataProvider = "UserData")
    public void testAddUser(String UserName, String Email, String Password, String Role, String Status) throws InterruptedException {
        
        driver.findElement(By.id("user_name")).sendKeys(UserName);
    
        driver.findElement(By.id("emailid")).sendKeys(Email);
       
        driver.findElement(By.id("pwd")).sendKeys(Password);
       
         // Conditionally select Role
         if (!Role.isEmpty()) {
            Select roleDropdown = new Select(driver.findElement(By.id("role")));
            roleDropdown.selectByIndex(1);
        }
        
        // Conditionally select Status
        if (!Status.isEmpty()) {
            Select statusDropdown = new Select(driver.findElement(By.id("status")));
            statusDropdown.selectByIndex(1);
        }

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000); // Wait for form submission

        // Navigate back to Add Users page for the next iteration
        driver.findElement(By.xpath("//span[text()='Manage Users']")).click();
        driver.findElement(By.xpath("//a[text()='Add Users']")).click();
    }

    @DataProvider(name = "UserData")
    public Object[][] provideUserData() {
        return new Object[][] {
            {"", "V@gmail.com", "12345", "1", "1"}, // Empty User name
            {"vishaka", "", "12345", "1", "1"}, // Empty Email  
            {"vishaka", "V@gmail.com", "", "1", "1"}, // Empty password 
            {"vishaka", "V@gmail.com", "12345", "", "1  "}, // Empty Role
            {"vishaka", "V@gmail.com", "12345", "1", ""}, // Empty Status
            {"Vishaka", "V@gmail.com", "12345", "1", "1"}, // Valid data for comparison
        };
    }

    @AfterTest
    public void tearDown() {
        // Close the browser after test
        if (driver != null) {
            driver.quit();
        }
    }
}
