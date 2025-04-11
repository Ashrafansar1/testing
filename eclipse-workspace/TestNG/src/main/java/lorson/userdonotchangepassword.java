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

public class userdonotchangepassword {
	public class Testcase {

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
	        public void userdonotchanngepassword() {
	        	 driver.get("https://mcstg-shop.larsonjuhl.com/en-US/customer/account/login/");
	        	 // Find elements
	        	// Click on "Forgot Password?" link
	        	 WebElement forgotPasswordLink = driver.findElement(By.xpath("//span[text()='Forgot Password?']"));
	        	 forgotPasswordLink.click();

	        	 // Wait for 1 second (1000 milliseconds)
	        	 try {
	        	     Thread.sleep(2000); // Sleep for 1 second
	        	 } catch (InterruptedException e) {
	        	     e.printStackTrace();
	        	 }

	        	 WebElement gobackbutton=driver.findElement(By.className("back-login-form"));
	        	 gobackbutton.click();
	        	 try {
	        	     Thread.sleep(2000); // Sleep for 1 second
	        	 } catch (InterruptedException e) {
	        	     e.printStackTrace();
	        	 }
	        	 
	        }
	    }

}
