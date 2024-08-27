package SGS.SportsGearSwag;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import SGS.AbstractComponents.AbstractComponent;
import SGS.SportsGearSwag.pageobjects.AdditionalAccessories;
import SGS.SportsGearSwag.pageobjects.ArtWork;
import SGS.SportsGearSwag.pageobjects.EditCartDeatils;
import SGS.SportsGearSwag.pageobjects.ProuctCatalouge;
import SGS.TestComponent.BaseTest;
import SGS.TestComponent.Retry;

 public class SubmitOrderTest extends BaseTest {
	
	@Test(retryAnalyzer=Retry.class)
	public void submitOrder() throws IOException, InterruptedException
	{		
		
		
//		#Login into Application
		
		    landingPage.accountClick();
		    landingPage.loginApplication("rammybadwal@gmail.com", "123456"); 
		    String UserStatus = driver.findElement(By.cssSelector(".heading")).getText();
			String ExpectedTitleOnDashboard = "MY ACCOUNT";
			AssertJUnit.assertEquals(ExpectedTitleOnDashboard, UserStatus);
			System.out.println("User Login into application sucessfully");
		    landingPage.homePage();
		    
		

//		#Find Product
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h4[normalize-space()='Basketball']")).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,600)"); Thread.sleep(1000);
		ProuctCatalouge productCatalouge = new ProuctCatalouge(driver);
		productCatalouge.clickOnProduct();
		Thread.sleep(1000);
		
	
		
//		#Customize your design
		
		productCatalouge.chooseStyle();
		Thread.sleep(1000); js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		productCatalouge.chooseApparel();
		Thread.sleep(1000);
		productCatalouge.choosePrint();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		productCatalouge.chooseFrabric();
		productCatalouge.chooseNeckline();
		productCatalouge.chooseSize("1");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(1000);
		productCatalouge.AddRoaster();
		Thread.sleep(2000);

		
		
		
//		#VerifyBreakdown 
		
		js.executeScript("window.scrollBy(0,2600)");		
		
		String Amount = driver.findElement(By.xpath("//span[@id='add_to_cart_total_amount']")).getText();
		System.out.println("Final Total Amount: "  +  Amount);	
		String JerseyDetils = driver.findElement(By.xpath("//div[@id='add_to_cart_breakdown_heading']")).getText();
		System.out.println("------ Breakdown  " + JerseyDetils + "  ------ Review deatils");
		productCatalouge.checkoutAmt();
		Thread.sleep(1000);
		
		File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("/Users/rammy/Downloads/BeforeCart.png"));
		System.out.println("Capture the screen before adding into cart");
		
		
		
//		#Verifying the cart
		
		Thread.sleep(2000);
		productCatalouge.AddToCart();
		Thread.sleep(2000);
		String cartText = driver.findElement(By.xpath("//h2[normalize-space()='SHOPPING CART']")).getText();
		System.out.println("Landing on " + cartText + " Page");
		String ExpectedTitleOnCart = "SHOPPING CART";
		AssertJUnit.assertEquals(ExpectedTitleOnCart, cartText);
		
		
//		#Take screenshot of cart
		
		File Cart =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Cart, new File("/Users/rammy/Downloads/Cart.png"));
		System.out.println("Cart Page is Captured");
		
//		#Edit cart page:
		
		EditCartDeatils EditCartdetail = new EditCartDeatils(driver);
		EditCartdetail.EditCart();
		Thread.sleep(2000);
		EditCartdetail.ChangeCustomizations();
		System.out.println("All the customizations are done");
		
//		#Add Accessories
		
		AdditionalAccessories ExtraAccessories = new AdditionalAccessories(driver);
		ExtraAccessories.Accessories();
		
//		#Upload Browse and Custom Artwork
		ArtWork CustomArtworkDesign = new ArtWork(driver);
		CustomArtworkDesign.ArtWorkDesign();
		Thread.sleep(6000);
		js.executeScript("window.scrollBy(0,2400)");

//		#Update the Cart With new Changes
		Thread.sleep(4000);
		CustomArtworkDesign.UpdateCartButton();
		Thread.sleep(4000);
		String ExpectedTitleOnCartPage = "SHOPPING CART";
		AssertJUnit.assertEquals(ExpectedTitleOnCartPage, cartText);
		System.out.println("Changes are done and landed on cartpage");
		
		

		
//		#Close the browser
		
		AbstractComponent abstractComponent = new AbstractComponent(driver);
		abstractComponent.closeBrowser();

	}}

