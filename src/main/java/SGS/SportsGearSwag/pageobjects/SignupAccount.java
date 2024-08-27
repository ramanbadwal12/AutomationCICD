package SGS.SportsGearSwag.pageobjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupAccount {
	

	WebDriver driver;
	public  SignupAccount(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
//	    #Sign up New User
	
		@FindBy(css= "div[class='dont-have-account text-center'] a span")
		WebElement CreateAccount;
		
		@FindBy(xpath= "//h2[normalize-space()='Create Account']")
		WebElement PageConfirm;
		
		@FindBy(xpath= "//button[normalize-space()='Create Account']")
		WebElement CreateButton;
		
		@FindBy(xpath= "//label[@id='sign_up_form_name-error']")
		WebElement ErrorMessage;
		
		@FindBy(xpath= "//input[@id='sign_up_form_name']")
		WebElement UserName;
		
		@FindBy(xpath= "//input[@id='sign_up_form_email']")
		WebElement UserEmail;
		
		@FindBy(xpath= "//label[@id='sign_up_form_email-error']")
		WebElement EmailValidate;
		
		@FindBy(xpath= "//input[@id='sign_up_form_password_first']")
		WebElement FirstPassword;
		
		@FindBy(xpath= "//input[@id='sign_up_form_password_second']")
		WebElement SecondPassword;
		
		@FindBy(css= ".form-error-message")
		WebElement MatchPassword;
		
		@FindBy(css= "button[class='btn repeat-btn btn-block']")
		WebElement AccountCreatedStatus;
		

	public void ClickCreateAccount() throws InterruptedException {
		
		CreateAccount.click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(1000);
		CreateButton.click();
	}
	
	public String SingupEmptyValidation() {
		
		
		return PageConfirm.getText();
		
	}
	
	public String EmptyDataValidate() {
		
		return ErrorMessage.getText();
		
	}
	
	public String ValidateInvalidData(String Name, String Email) {
		
		UserName.sendKeys(Name);
		UserEmail.sendKeys(Email);
		return EmailValidate.getText();
		
	}
	
	public String ValidatePassword(String Email, String Password1, String Password2) throws InterruptedException {
		
		UserEmail.clear();
		UserEmail.sendKeys(Email);
		FirstPassword.sendKeys(Password1);
		SecondPassword.sendKeys(Password2);
		CreateButton.click();
		Thread.sleep(1000);
		return MatchPassword.getText();
		
		
	}
	
	public void CreateSucessAccount( String Password1, String Password2) throws InterruptedException {
		
		
		FirstPassword.sendKeys(Password1);
		SecondPassword.sendKeys(Password2);
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		CreateButton.click();

	}	
	
}
