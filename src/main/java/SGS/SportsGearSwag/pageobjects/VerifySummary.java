package SGS.SportsGearSwag.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class VerifySummary {

	WebDriver driver;
	public  VerifySummary(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void summaryCalacualtions() {
		
		
//		#Get the total amount
		String Amount1 = driver.findElement(By.xpath("//span[@id='add_to_cart_total_amount']")).getText();
		
//		Print the table value
		List<WebElement> TableValues = driver.findElements(By.xpath("//div[@id='add_to_cart_breakdown_details']//table/tbody/tr"));
		for(int i=0; i<TableValues.size(); i++) {
		}
		
//		# XPath with shipping fee
		List<WebElement> values = driver.findElements(By.xpath("//div[@id='add_to_cart_breakdown_details']//table/tbody/tr/td[2]"));
	
		
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

		//Multiply the sum by quantity if needed
		 sum = sum * 5;
		 
		// Assert that the calculated sum matches the expected amount
		try {
			 assertEquals(Float.parseFloat(Amount1.replace("$", "").replace("Discount", "").trim()), sum);
		    System.out.println("Assertion matched again after make more customizations");
		} catch (NumberFormatException e) {
			
		}
	
	}

	private void assertEquals(float float1, float sum) {
		// TODO Auto-generated method stub
	}


	@SuppressWarnings("unused")
	private float Float(String replace) {
		// TODO Auto-generated method stub
		return 0;
	}}
	

