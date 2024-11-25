package SGS.SportsGearSwag.pageobjects;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement recaptchaFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.switchTo().frame(recaptchaFrame);        
        System.out.println("Please complete the reCAPTCHA manually within 30 seconds.");
        Thread.sleep(30000); 

        driver.switchTo().defaultContent();
        @SuppressWarnings("unused")
		WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create Account']")));
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
