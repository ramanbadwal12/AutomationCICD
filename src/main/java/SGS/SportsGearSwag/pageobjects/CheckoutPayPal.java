package SGS.SportsGearSwag.pageobjects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CheckoutPayPal {
	
	
		WebDriver driver;
		public  CheckoutPayPal(WebDriver driver)
		{
			
			this.driver = driver;
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
			
			paypalCheckoutButton.click();
}
 		
		public void makePayment(String email, String password) throws InterruptedException {
			
			paypalEmail.sendKeys(email);
			Thread.sleep(1000);
			clickNext.click();
			Thread.sleep(1000);
			paypalPassword.sendKeys(password);
			Thread.sleep(1000);
			submitPayment.click();
			Thread.sleep(2000);
			paymentSucess.click();
			
			
		}
		
		




}
