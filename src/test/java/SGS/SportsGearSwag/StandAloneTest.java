package SGS.SportsGearSwag;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://dev1.sportsgearswag.com/softball/shop/jersey/6036/"
				+ "custom-u-shape-bottom-stripe-adult-youth-unisex-softball-jersey");
		
		Thread.sleep(2000);

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		        
	}
		}
