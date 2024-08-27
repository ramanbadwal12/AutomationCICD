package SGS.SportsGearSwag.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutAnotherMethods {
	
	WebDriver driver;
	public  CheckoutAnotherMethods(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
//	#Checkout Steps using another methods
	
	@FindBy(xpath= "//button[normalize-space()='checkout']")
	WebElement checkoutAnother;
	@FindBy(xpath= "//input[@id='checkout_shippingAddress_firstName']")
	WebElement UserFirstName;
	@FindBy(xpath= "//input[@id='checkout_shippingAddress_lastName']")
	WebElement userLastName;
	@FindBy(xpath= "(//input[@id='checkout_shippingAddress_addressLine1'])[1]")
	WebElement shippingAddress;
	@FindBy(xpath= "(//input[@id='checkout_shippingAddress_addressLine1'])[1]")
	WebElement shippingAddressDown;
	@FindBy(xpath= "(//input[@id='checkout_shippingAddress_addressLine1'])[1]")
	WebElement shippingAddressEnter;
	@FindBy(xpath= "//input[@id='checkout_shippingAddress_phoneNumber']")
	WebElement phoneNumber;
	@FindBy(xpath= "//input[@id='checkout_shippingAddress_email']")
	WebElement shippingEmail;
	@FindBy(xpath= "//a[normalize-space()='Copy to Billing Address']")
	WebElement copyToBilling;
	
	
//	#Select Payment Method
 
	
	@FindBy(xpath= "(//input[@id='checkout_paymentMethod_7'])[1]")
	WebElement SelectMethod;
	
//	#Click on reCAPTHA and submit button
	
	@FindBy(xpath= ".recaptcha-checkbox-border")
	WebElement reCAPTHA;
	@FindBy(xpath="//button[@id='checkout_submit']")
	WebElement SubmitOrder;

//	#checkout Button
	public void CheckoutRemainMethods() {
		checkoutAnother.click();
	}
	
	
	public void checkoutAnotherMethods(String Firstname, String Lastname, String Address, String Phonenumber, String Shippingemail) throws InterruptedException {
		
		Thread.sleep(1000);

		UserFirstName.sendKeys(Firstname);
		userLastName.sendKeys(Lastname);
		phoneNumber.sendKeys(Phonenumber);
		shippingEmail.sendKeys(Shippingemail);
		shippingAddress.sendKeys(Address);
		Thread.sleep(1000);
		shippingAddress.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		shippingAddress.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		copyToBilling.click();
		
	}
	
//	#Select Payment Method
	
	public void selectPaymentMethod() throws InterruptedException {
		
		
		SelectMethod.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		reCAPTHA.click();
		Thread.sleep(5000);
		SubmitOrder.click();
		
		
		
	}

}

