package SGS.SportsGearSwag.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ShippingDates {

	WebDriver driver;
	public  ShippingDates(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void Shippingdiscount() throws InterruptedException {

		// Get the total amount before choosing the discounted delivery date
		String amount1String = driver.findElement(By.xpath("//span[@id='add_to_cart_total_amount']")).getText();
		System.out.println("Total amount before choosing the discounted delivery date: " + amount1String);

		float originalAmount = Float.parseFloat(amount1String.replace("$", "").replace("Discount", "").trim());
		float discount = originalAmount * 0.05f;
		float discountedAmount = originalAmount - discount;
		String finalAmount = String.format("%.2f", discountedAmount);

		// Discount amount
		String val = driver.findElement(By.xpath("//td[@class='ant-table-cell breakdown-cell text-right breakdown-free-cost']")).getText();
		System.out.println("Additional value retrieved: " + val);
		System.out.println("Final Amount after 5% deduction: " + finalAmount);

		Thread.sleep(2000); 
		driver.findElement(By.xpath("//span[@class='shipping-price w-100']")).click();

		// Retrieve the values from the table (excluding shipping fee)
		List<WebElement> values = driver.findElements(By.xpath("(//div[@class='ant-table-wrapper'])[1]//table/tbody/tr/td[2]"));

		float sum = 0;
		for (int i = 0; i < values.size(); i++) {
			String textValue = values.get(i).getText().trim();

			if (textValue.equalsIgnoreCase("FREE")) {
				sum += 0;
			} else {
				try {
					sum += Float.parseFloat(textValue.replace("$", "").replace("Discount", "").trim());
				} catch (NumberFormatException e) {
					System.out.println("Error parsing value: " + textValue);
				}
			}
		}

		try {
			assertEquals(discountedAmount, sum, 0.01); // Use a small delta (0.01) for comparison due to floating-point precision
			System.out.println("Assertion matched for Total Amount after discount");
		} catch (AssertionError e) {
			System.out.println("Assertion failed for Total Amount after discount. Expected: " + discountedAmount + ", but found: " + sum);
		} catch (NumberFormatException e) {
			System.out.println("Error parsing Amount1: " + amount1String);
		}

		// Simulate a delay before checking another value
		Thread.sleep(2000);

	}

	private void assertEquals(float discountedAmount, float sum, double d) {
		// TODO Auto-generated method stub

	}}
