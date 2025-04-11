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

public class useristhenewcostomarbecome {
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
        public void useristhenewcustomer() {
        	driver.get("https://mcstg-shop.larsonjuhl.com/en-US/customer/account/login/");
        	WebElement becomealorsonjulecustomer = driver.findElement(By.xpath("//span[text()='Become a Larson-Juhl customer']"));
        	becomealorsonjulecustomer.click();
    }
}
