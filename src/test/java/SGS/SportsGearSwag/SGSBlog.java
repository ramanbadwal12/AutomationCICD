package SGS.SportsGearSwag;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SGSBlog {

	    public static void main(String[] args) throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://sportsgearswag.com/blogs");

	        // Check links in multiple sections
	        checkLinksInSection(driver, "(//div[@class='heading-section only-title'])[1]");
	        checkLinksInSection(driver, "(//div[contains(@class,'category-related-post-wrapper')])[1]"); // Add additional sections as needed

	        driver.quit();
	    }

	    private static void checkLinksInSection(ChromeDriver driver, String sectionSelector) {
	        WebElement section = driver.findElement(By.xpath(sectionSelector));
	        List<WebElement> links = section.findElements(By.tagName("a"));
	        System.out.println("Total links in section " + sectionSelector + ": " + links.size());

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
	                        System.out.println(url + " is a broken link in section " + sectionSelector + ".");
	                        brokenLinks.add(url);
	                    } else {
	                        System.out.println(url + " is a valid link in section " + sectionSelector + ".");
	                    }
	                } catch (Exception e) {
	                    System.out.println(url + " is a broken link in section " + sectionSelector + ".");
	                    brokenLinks.add(url);
	                }
	            }
	        }

	        // Print the list of broken links
	        if (!brokenLinks.isEmpty()) {
	            System.out.println("Broken links found in section " + sectionSelector + ":");
	            for (String brokenLink : brokenLinks) {
	                System.out.println(brokenLink);
	            }
	        } else {
	            System.out.println("No broken links found in section " + sectionSelector + ".");
	        }
	    }
	}
