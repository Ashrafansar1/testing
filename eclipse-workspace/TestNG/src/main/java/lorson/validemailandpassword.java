package lorson;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class validemailandpassword {
	WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
        @Test(priority = 1)
        public void validtestLogin1() {
            driver.get("https://mcstg-shop.larsonjuhl.com/en-US/customer/account/login/");
            // Find elements
            WebElement usernameField = driver.findElement(By.id("email"));
            WebElement passwordField = driver.findElement(By.id("pass"));
            WebElement loginButton = driver.findElement(By.xpath("//span[@title=''][text()='Sign In']"));
            // Perform actions
            usernameField.sendKeys("shahilsharma@sourcemash.com");
            passwordField.sendKeys("Test@123");
            loginButton.click();
        }
            @Test(priority = 1)
            public void testInvalidLogin() {
                // Invalid login test
                driver.get("https://mcstg-shop.larsonjuhl.com/en-US/customer/account/login/");

                // Find elements
                WebElement usernameField = driver.findElement(By.id("email"));
                WebElement passwordField = driver.findElement(By.id("pass"));
                WebElement loginButton = driver.findElement(By.xpath("//span[@title=''][text()='Sign In']"));

                // Perform actions with invalid credentials
                usernameField.sendKeys("invaliduser@sourcemash.com");
                passwordField.sendKeys("Invalid@123");
                loginButton.click();
        }
}
