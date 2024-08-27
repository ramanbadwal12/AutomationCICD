package SGS.SportsGearSwag;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderHistory {

	 public static void main(String[] args) throws InterruptedException {
	    	
	    	WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.get("https://sportsgearswag.com");
			
			//My Account page	
			driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
			
			driver.findElement(By.xpath("//input[@id='inputEmailAddress']")).sendKeys("rammybadwal@gmail.com");
			driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("123456");
			driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
			driver.findElement(By.xpath("//h5[normalize-space()='Order History']")).click();
			Thread.sleep(2000);
			
			  WebElement section = driver.findElement(By.cssSelector(".customer-orders.mb-5.mt-4"));
			 

			  
			  //Find link on whole page
//	        List<WebElement> links = driver.findElements(By.tagName("a"));
			  
			  //Find link on particular section
			  List<WebElement> links = section.findElements(By.tagName("a"));
			 
	        System.out.println("Total links on the page: " + links.size());

	        List<String> brokenLinks = new ArrayList<>();
	        

	        // Check each link
	        for (WebElement link : links) {
	            String url = link.getAttribute("href");
	            if (url != null && !url.isEmpty()) {
	                try {
	                    @SuppressWarnings("deprecation")
						HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	                    connection.setRequestMethod("HEAD");
	                    connection.connect();
	                    int responseCode = connection.getResponseCode();
	                    if (responseCode >= 300) {
	                        System.out.println(url + " is a broken link.");
	                        brokenLinks.add(url);
	                    } else {
	                        System.out.println(url + " is a valid link.");
	                    }
	                } catch (Exception e) {
	                    System.out.println(url + " is a broken link.");
	                    brokenLinks.add(url);
	                }
	            }
	        }

	        // Print the list of broken links
	        if (!brokenLinks.isEmpty()) {
	            System.out.println("Broken links found:");
	            for (String brokenLink : brokenLinks) {
	                System.out.println(brokenLink);
	            }
	        } else {
	            System.out.println("No broken links found.");
	        }

	        driver.quit();
	    }
	}
