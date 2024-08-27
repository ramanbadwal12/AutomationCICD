package SGS.SportsGearSwag;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SiteMap {
public static void main(String[] args) throws InterruptedException {
    	
    	WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://sportsgearswag.com/sitemap");
		
		//Homepage header section
		
		  WebElement section = driver.findElement(By.cssSelector(".section-sitemap.container"));


		  
		  //Find link on whole page
//        List<WebElement> links = driver.findElements(By.className("sgs-products container-fluid"));
//        System.out.println("Total links on the page: " + links.size());
		  
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
