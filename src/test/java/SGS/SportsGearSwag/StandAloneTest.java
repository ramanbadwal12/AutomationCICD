package SGS.SportsGearSwag;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {

		//Here we invoke the browser

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		        
		        // List of URLs to check
		        String[] urlsToCheck = {"https://www.sportsgearswag.com/", "https://www.sportsgearswag.com/basketball"};

		        for (String url : urlsToCheck) {
		            driver.get(url);

		            // === Option 1: Check all links on the entire page ===
		            System.out.println("Checking all links on the entire page: " + url);
		            List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='row justify-content-center']"));
		            checkLinks(allLinks);

		            // === Option 2: Check links within a particular section ===
		            // Locate the section by id, className, or any appropriate selector
		            // For example, checking a section with id="specific-section"
//		            WebElement section = driver.findElement(By.id("//div[@id='landing-product-blocks']")); // Adjust the locator as needed
//		            System.out.println("Checking links within a specific section: " + url);
//		            List<WebElement> sectionLinks = section.findElements(By.id("//div[@id='landing-product-blocks']"));
//		            checkLinks(sectionLinks);
		        }

		        // Close the browser
		        driver.quit();
		    }

		    // Method to check links and log if they are broken
		    public static void checkLinks(List<WebElement> links) {
		        for (WebElement link : links) {
		            String linkUrl = link.getAttribute("href");

		            if (linkUrl == null || linkUrl.isEmpty()) {
		                System.out.println("Link is either not configured or it is empty");
		                continue;
		            }

		            try {
		                // Check if the link is broken
		                HttpURLConnection httpURLConnection = (HttpURLConnection) (new URL(linkUrl).openConnection());
		                httpURLConnection.setRequestMethod("HEAD");
		                httpURLConnection.connect();

		                int responseCode = httpURLConnection.getResponseCode();

		                if (responseCode >= 400) {
		                    System.out.println(linkUrl + " is a broken link. Response code: " + responseCode);
		                } else {
		                    System.out.println(linkUrl + " is a valid link.");
		                }
		            } catch (IOException e) {
		                System.out.println(linkUrl + " is a broken link. Exception: " + e.getMessage());
		            }
		        }
		    }
		}
