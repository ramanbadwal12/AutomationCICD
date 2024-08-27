package SGS.SportsGearSwag;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SavedCart {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://sportsgearswag.com");

        // My Account page
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();

        // Login
        driver.findElement(By.id("inputEmailAddress")).sendKeys("rammybadwal@gmail.com");
        driver.findElement(By.id("inputPassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
        
        // Go to Saved Cart
        driver.findElement(By.xpath("//h5[normalize-space()='Saved Cart']")).click();
        Thread.sleep(2000);
        
        // Locate the section containing links
        WebElement section = driver.findElement(By.cssSelector(".customer-saved-designs.mb-5.mt-4"));

        // Find and check links within the specified section
        checkLinksInSection(section, driver);

        // Close the browser
        driver.quit();
    }

    public static void checkLinksInSection(WebElement section, WebDriver driver) {
        // Find all the links within the section
        List<WebElement> links = section.findElements(By.tagName("a"));

        System.out.println("Total links found in the section: " + links.size());

        // Iterate through each link and check if it's empty or broken
        for (WebElement link : links) {
            String url = link.getAttribute("href");

            // Check if the link is empty or starts with "javascript:"
            if (url == null || url.isEmpty() || url.toLowerCase().startsWith("javascript:")) {
                System.out.println("Skipping link: " + url);
                continue; // Skip to the next link
            }

            try {
                // Create a HttpURLConnection for the URL
                @SuppressWarnings("deprecation")
				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.setInstanceFollowRedirects(false);

                // Get the HTTP response code
                int statusCode = connection.getResponseCode();

                // Print out the status code along with the URL
                System.out.println("URL: " + url + " | Status Code: " + statusCode);

                // Check if the link is broken (status code 404 or higher)
                if (statusCode >= 300 && statusCode < 400) {
                    System.out.println("Broken link found: " + url);
                }

                connection.disconnect();
            } catch (Exception e) {
                System.out.println("Exception occurred while checking link: " + url);
                e.printStackTrace();
            }
        }
    }
}
