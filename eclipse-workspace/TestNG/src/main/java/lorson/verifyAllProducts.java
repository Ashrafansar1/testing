package lorson;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class verifyAllProducts {

    WebDriver driver;
    WebDriverWait wait;
    private final String productPageUrl = "https://mcstg-shop.larsonjuhl.com/en-US/moulding/wood-moulding.html"; 

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void login() {
        driver.get("https://mcstg-shop.larsonjuhl.com/en-US/customer/account/login/");

        driver.findElement(By.id("email")).sendKeys("shahilsharma@sourcemash.com");
        driver.findElement(By.id("pass")).sendKeys("Test@123");
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();

       
    }

    @Test(priority = 2)
    public void goToProductPage() {
        driver.get(productPageUrl);
    }

    @Test(priority = 3)
    public void verifySingleProductDetails() {
        try {
            // Find product image
            WebElement productImage = driver.findElement(By.xpath("//img[@src=\"https://cdn.bazaarinsights.com/larsonjuhl/images/c_fit,w_270,h_270,cs_srgb/4d45a77aa2a101e65a467f4d4f4ee417.png\" and @class=\"product-image-photo\"]"));
            if (productImage.isDisplayed()) {
                System.out.println("✅ Product image is displayed.");
            } else {
                System.out.println("❌ Product image is NOT displayed.");
            }

            // Find product name
            WebElement productNameElement = driver.findElement(By.xpath("//a[@class='product-item-link' and @href='https://mcstg-shop.larsonjuhl.com/en-US/moulding/wood-moulding/academie-black-1-1-4-403239.html' and @title='']"));
            String productName = productNameElement.getText();
            System.out.println("🛍️ Name: " + productName);

            // Find product price
            WebElement productPriceElement = driver.findElement(By.xpath("//span[@class='prices' and @title='']"));
            String productPrice = productPriceElement.getText();
            System.out.println("💲 Price: " + productPrice);

            // Optional: Verify compare checkbox (if present on the single product page)
            List<WebElement> compareCheckbox = driver.findElements(By.xpath("//label[@class='label custom-control-label on' and @for='customCheck46317' and @title='Compare']"));
            if (compareCheckbox.isEmpty()) {
                System.out.println("☑️ Compare checkbox is present.");
            } else {
                System.out.println("🚫 Compare checkbox NOT found.");
            }

        } catch (NoSuchElementException e) {
            System.err.println("⚠️ Could not locate product details element: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("⚠️ An error occurred while verifying product details: " + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}