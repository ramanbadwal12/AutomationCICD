package SGS.SportsGearSwag.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {


	WebDriver driver;
	public  ForgotPassword(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	//	#Forgot Password

	@FindBy(css= ".sign-in-trouble")
	WebElement ClickForgot;

	@FindBy(xpath="//button[@id='form_submit']")
	WebElement SubmitButton;

	@FindBy(xpath= "//label[@id='form_email-error']")
	WebElement EmptyEmailError;

	@FindBy(xpath="//input[@id='form_email']")
	WebElement EmailID;



	@FindBy(css="div[class$='alert  alert-danger']")
	WebElement UnRegisteredUser;


	public void ClickOnButtons() {
		ClickForgot.click();
		SubmitButton.click();
	}

	public String UserEmptyData() {

		return EmptyEmailError.getText();

	}

	public String UnRegisteredEmail(String Email) throws InterruptedException {

		EmailID.sendKeys(Email);
		SubmitButton.click();
		Thread.sleep(1000);
		return UnRegisteredUser.getText();

	}

}
