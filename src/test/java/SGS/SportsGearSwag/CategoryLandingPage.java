package SGS.SportsGearSwag;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CategoryLandingPage {

	
	 public static void main(String[] args) throws InterruptedException {
	        WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://dev1.sportsgearswag.com/powerlifting");
	        
	        WebElement section = driver.findElement(By.id("landing-product-blocks"));

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
	        

//	        // Define section selectors to check links within
//	        List<String> sectionSelectors = new ArrayList<>();
//	        sectionSelectors.add("landing-product-blocks");
//	        // Add more section selectors as needed, excluding the section you want to skip
//
//	        // Check links in each section
//	        for (String sectionSelector : sectionSelectors) {
//	            if (!sectionSelector.equals(".primarybar-nav.secondarybar-nav")) { 
//	                checkLinksInSection(driver, sectionSelector);
//	            }
//	        }
//
//	        driver.quit();
//	    }
//
//	    private static void checkLinksInSection(ChromeDriver driver, String sectionSelector) {
//	        WebElement section = driver.findElement(By.cssSelector(sectionSelector));
//	        List<WebElement> links = section.findElements(By.tagName("a"));
//	        System.out.println("Total links in section " + sectionSelector + ": " + links.size());
//
//	        List<String> brokenLinks = new ArrayList<>();
//
//	        // Check each link
//	        for (WebElement link : links) {
//	            String url = link.getAttribute("href");
//	            if (url != null && !url.isEmpty()) {
//	                try {
//	                    @SuppressWarnings("deprecation")
//						HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//	                    connection.setRequestMethod("HEAD");
//	                    connection.connect();
//	                    int responseCode = connection.getResponseCode();
//	                    if (responseCode >= 300) {
//	                        System.out.println(url + " is a broken link in section " + sectionSelector + ".");
//	                        brokenLinks.add(url);
//	                    } else {
//	                        System.out.println(url + " is a valid link in section " + sectionSelector + ".");
//	                    }
//	                } catch (Exception e) {
//	                    System.out.println(url + " is a broken link in section " + sectionSelector + ".");
//	                    brokenLinks.add(url);
//	                }
//	            }
//	        }
//
//	        // Print the list of broken links
//	        if (!brokenLinks.isEmpty()) {
//	            System.out.println("Broken links found in section " + sectionSelector + ":");
//	            for (String brokenLink : brokenLinks) {
//	                System.out.println(brokenLink);
//	            }
//	        } else {
//	            System.out.println("No broken links found in section " + sectionSelector + ".");
//	        }
//	        driver.quit();
//	    }
//	}