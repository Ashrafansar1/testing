package star;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HeaderLinksTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set up WebDriver for Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://starfurniture.com/?srsltid=AfmBOorhEGP9pcLJ5x1tM8rXzCF2LUi6812bU8fsXbPbu77BWKTt8ore"); // Replace with your website's URL
    }

    @Test
    public void verifyHeaderLinksRedirection() {
        // Find the link by link text and click it
        driver.findElement(By.linkText("Gallery Link 1")).click();
        
        // Wait for the page to load
        try {
            Thread.sleep(2000);  // Simple wait, consider WebDriverWait for better reliability
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify the URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://yourwebsite.com/gallery1"); // Replace with expected URL

        // Navigate back to the homepage
        driver.navigate().back();
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
