 package Add_Book;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckRequiredFieldsForAddBook {

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

        // Navigate to Add Book page
        driver.findElement(By.xpath("//span[text()='Manage Books']")).click();
        driver.findElement(By.xpath("//a[text()='Add Book']")).click();
    }

    @Test(dataProvider = "bookData")
    public void testAddBook(String bookName, String category, String isbn, String author, String publisher,
                            String price, String quantity, String location, String availability) throws InterruptedException {
        // Clear and fill in the form fields
       
        driver.findElement(By.id("book_name")).sendKeys(bookName);
        
        driver.findElement(By.id("category_name")).sendKeys(category);
       
        driver.findElement(By.id("isbn")).sendKeys(isbn);
        driver.findElement(By.id("author_name")).clear();
        driver.findElement(By.id("author_name")).sendKeys(author);
        driver.findElement(By.id("publisher_name")).clear();
        driver.findElement(By.id("publisher_name")).sendKeys(publisher);
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys(price);
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys(quantity);
        driver.findElement(By.id("location_name")).sendKeys(location);
        driver.findElement(By.id("availability")).sendKeys(availability);

        // Submit the form
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000); // Wait for form submission

        // Navigate back to Add Book page for the next iteration
        driver.findElement(By.xpath("//span[text()='Manage Books']")).click();
        driver.findElement(By.xpath("//a[text()='Add Book']")).click();
    }

    @DataProvider(name = "bookData")
    public Object[][] provideBookData() {
        return new Object[][] {
            {"", "Novel", "6789", "J.K. Rowling", "Bloomsbury", "$20", "12", "Nuwara eliya", "Available"}, // Empty book name
            {"HarryPotter", "", "6789", "J.K. Rowling", "Bloomsbury", "$20", "12", "Nuwara eliya", "Available"}, // Empty category
            {"HarryPotter", "Novel", "", "J.K. Rowling", "Bloomsbury", "$20", "12", "Nuwara eliya", "Available"}, // Empty ISBN
            {"HarryPotter", "Novel", "6789", "", "Bloomsbury", "$20", "12", "Nuwara eliya", "Available"}, // Empty author
            {"HarryPotter", "Novel", "6789", "J.K. Rowling", "", "$20", "12", "Nuwara eliya", "Available"}, // Empty publisher
            {"HarryPotter", "Novel", "6789", "J.K. Rowling", "Bloomsbury", "", "12", "Nuwara eliya", "Available"}, // Empty price
            {"HarryPotter", "Novel", "6789", "J.K. Rowling", "Bloomsbury", "$20", "", "Nuwara eliya", "Available"}, // Empty quantity
            {"HarryPotter", "Novel", "6789", "J.K. Rowling", "Bloomsbury", "$20", "12", "", "Available"}, // Empty location
            {"HarryPotter", "Novel", "6789", "J.K. Rowling", "Bloomsbury", "$20", "12", "Nuwara eliya", ""}, // Empty availability
            {"HarryPotter", "Novel", "6789", "J.K. Rowling", "Bloomsbury", "$20", "12", "Nuwara eliya", "Available"} // Complete set
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
