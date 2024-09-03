package SGS.SportsGearSwag.pageobjects;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SGS.AbstractComponents.AbstractComponent;


public class ExpressCheckoutPayPal extends AbstractComponent{
	
	
		WebDriver driver;
	    private WebDriverWait wait;

		public  ExpressCheckoutPayPal(WebDriver driver)
		{
			super(driver);
			this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed

			PageFactory.initElements(driver, this);

		}
		
		
		  @FindBy(xpath= "//div[@id='paypal-button-container']") WebElement
		  paypalCheckoutButton;
		  
		  @FindBy(xpath= "//div[@class='fieldWrapper']/input[@id='email']") WebElement
		  paypalEmail;
		  
		  @FindBy(xpath= "//button[@id='btnNext']") WebElement clickNext;
		  
		  @FindBy(xpath= "//input[@id='password']") WebElement paypalPassword;
		  
		  @FindBy(xpath= "//button[@id='btnLogin']") WebElement submitPayment;
		  
		  @FindBy(xpath= "//button[@id='payment-submit-btn']") WebElement
		  paymentSucess;
		  
		  @FindBy(xpath= "//button[normalize-space()='checkout']") WebElement
		  anotherPaymentMethods;
		 			
		
//		#Checkout Using PayPal
		public void checkoutPaypal() throws InterruptedException {
			
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1200)");
			Thread.sleep(2000);
	        wait.until(ExpectedConditions.elementToBeClickable(paypalCheckoutButton)).click();

}
 		
		public void makePayment(String email, String password) throws InterruptedException {
						
			paypalEmail.sendKeys(email);
			Thread.sleep(1000);
			clickNext.click();
			Thread.sleep(1000);
			paypalPassword.sendKeys(password);
			Thread.sleep(1000);
//			submitPayment.click();
//			Thread.sleep(2000);
//			paymentSucess.click();
			
			
		}
}
