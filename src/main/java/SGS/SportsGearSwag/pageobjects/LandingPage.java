package SGS.SportsGearSwag.pageobjects;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SGS.AbstractComponents.AbstractComponent;


public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public  LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath= "//a[@class='text-white'][normalize-space()='My Account']")
	WebElement aButtonClick;

	@FindBy(xpath= "//input[@id='inputEmailAddress']")
	WebElement userName;

	@FindBy(xpath= "//input[@id='inputPassword']")
	WebElement passwordEle;

	@FindBy(xpath= "//button[normalize-space()='Sign In']")
	WebElement submit;

	@FindBy(xpath= "//div[@class='alert alert-danger']")
	WebElement getErrorMessage;


	@FindBy(xpath= "//a[@class='menu-left-side']//img[@alt='logo']")
	WebElement homeClick;



	public void goTo() 
	{
//		driver.get("https://sportsgearswag.com/");
				driver.get("https://dev1.sportsgearswag.com/");

	}

	public void accountClick() {
		aButtonClick.click();
	}

	public void loginApplication(String email, String password) throws InterruptedException
	{
		userName.sendKeys(email);
		passwordEle.sendKeys(password);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement recaptchaFrame = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@title='reCAPTCHA']")));
        driver.switchTo().frame(recaptchaFrame);        
        System.out.println("Please complete the reCAPTCHA manually within 30 seconds.");
        Thread.sleep(30000); 

        driver.switchTo().defaultContent();
        @SuppressWarnings("unused")
		WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']")));
		submit.click();
	}

	public String getErrorMessage() {

		return getErrorMessage.getText();
	}

	public void homePage() {
		homeClick.click();
	}
}


