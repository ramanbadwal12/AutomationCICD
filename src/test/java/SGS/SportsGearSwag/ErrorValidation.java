package SGS.SportsGearSwag;



import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import SGS.SportsGearSwag.pageobjects.ForgotPassword;
import SGS.SportsGearSwag.pageobjects.SignupAccount;
import SGS.TestComponent.BaseTest;
import SGS.TestComponent.Retry;

public class ErrorValidation extends BaseTest {

	@Test(retryAnalyzer=Retry.class)

	public void LoginValidation() throws InterruptedException {

		landingPage.accountClick(); landingPage.loginApplication("rammy@gmail.com", "123456");
		AssertJUnit.assertEquals("Invalid credentials, please try again, click Forgot Password? or "
				+ "email support@sportsgearswag.com for assistance.", 
				landingPage.getErrorMessage());
		driver.close();

	}

	@Test 

	public void Singup() throws InterruptedException {

		landingPage.accountClick();
		SignupAccount signupAccount = new SignupAccount(driver);
		signupAccount.ClickCreateAccount();
		AssertJUnit.assertEquals("CREATE ACCOUNT", 
				signupAccount.SingupEmptyValidation());
		AssertJUnit.assertEquals("This field is required.", 
				signupAccount.EmptyDataValidate());
		AssertJUnit.assertEquals("Please enter a valid email address.", 
				signupAccount.ValidateInvalidData("Ramanpreet Singh", "Rammy@"));

		AssertJUnit.assertEquals("The New Password field must match with Confirm Password field", 
				signupAccount.ValidatePassword("Rammy5@gmail.com", "12345678", "123456"));



		signupAccount.CreateSucessAccount( "12345678", "12345678");	


		//		driver.findElement(By.cssSelector("button[class='btn repeat-btn btn-block']")).click();
		String ErrorMessage = driver.findElement(By.cssSelector(".card.shadow-sm.border-black.rounded-lg ")).getText();
		if(ErrorMessage.contains("Your account has been created successfully.")) {

			System.out.println("Your account has been created successfully.");

		}

		else{
			System.out.println("We have already registered an account with this email. "
					+ "Please Sign In to your account or use another email to create new account.");
		}


		driver.close();
	}

	@Test
	public void UserForgotPassword() throws InterruptedException {


		landingPage.accountClick();
		ForgotPassword forgotPassword = new ForgotPassword(driver);
		forgotPassword.ClickOnButtons();
		AssertJUnit.assertEquals("This field is required.",
				forgotPassword.UserEmptyData());
		AssertJUnit.assertEquals("This is not a registered email address."
				+ " Please try again or email support@sportsgearswag.com for assistance.",
				forgotPassword.UnRegisteredEmail("Ramnz@gmail.com"));

		driver.close();

	}


}

