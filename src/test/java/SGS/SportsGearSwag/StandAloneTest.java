package SGS.SportsGearSwag;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		
//		hello

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://dev1.sportsgearswag.com/softball/shop/jersey/6036/"
				+ "custom-u-shape-bottom-stripe-adult-youth-unisex-softball-jersey");
		
		Thread.sleep(2000);

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//input[@id='sizes_JERSEY_S']")).sendKeys("2");
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,2800)");
		
		
//		Get the total amount
		String Amount1 = driver.findElement(By.xpath("//span[@id='add_to_cart_total_amount']")).getText();
		System.out.println(Amount1);

		
//		Print the table value
		List<WebElement> TableValues = driver.findElements(By.xpath("//div[@id='add_to_cart_breakdown_details']//table/tbody/tr"));
		for(int i=0; i<TableValues.size(); i++) {
			System.out.println(TableValues.get(i).getText());
		}
		
//		# XPath with shipping fee
		List<WebElement> values = driver.findElements(By.xpath("//div[@id='add_to_cart_breakdown_details']//table/tbody/tr/td[2]"));
		
//		#XPath without shipping fee
//		List<WebElement> values = driver.findElements(By.xpath("(//div[@class='ant-table-wrapper'])[1]//table/tbody/tr/td[2]"));
//		
//		
//		
		float sum = 0;
		for (int i = 0; i < values.size(); i++) {
		    String textValue = values.get(i).getText().trim();
		    
		    if (textValue.equalsIgnoreCase("FREE")) {
		        sum += 0;
		    } else {
		        try {
		            
		            sum += Float.parseFloat(textValue.replace("$", "").replace("Discount", "").trim()                  
		            );
		        } catch (NumberFormatException e) {
		            System.out.println("Error parsing value: " + textValue);
		          
		        }
		    }
		}

		// Optionally multiply the sum by 5 if needed
		 sum = sum * 2;

		System.out.println("Amount per product: " + sum);

		// Assert that the calculated sum matches the expected amount
		try {
		    assertEquals(Float.parseFloat(Amount1.replace("$", "").replace("Discount", "").trim()), sum);
		    System.out.println("Assertion matched for Total Amount");
		} catch (NumberFormatException e) {
		    System.out.println("Error parsing Amount1: " + Amount1);
		}
	
		
		        
	}
		}
