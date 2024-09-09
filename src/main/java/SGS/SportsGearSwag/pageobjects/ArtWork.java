package SGS.SportsGearSwag.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArtWork {

	WebDriver driver;
	public  ArtWork(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//span[normalize-space()='Browse Artwork']")
	WebElement BrowseArtwork;

	@FindBy(xpath= "//label[normalize-space()='Travel']")
	WebElement ArtworkCategory;

	@FindBy(css= "img[src='https://static.thenounproject.com/png/13358-200.png']")
	WebElement ChooseArtwork;

	@FindBy(xpath= "//div[@class='ant-upload ant-upload-select ant-upload-select-text']//input[@type='file']")
	WebElement UploadArtwrkFile;

	@FindBy(xpath="//span[normalize-space()='Apply']")
	WebElement ClickOnApply;

	@FindBy(xpath= "//span[normalize-space()='Update Cart']")
	WebElement UpdateCart;


	public void ArtWorkDesign() throws InterruptedException {

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-700)");
		Thread.sleep(3000);
		BrowseArtwork.click();
		Thread.sleep(2000);
		ArtworkCategory.click();
		Thread.sleep(2000);
		ChooseArtwork.click();
		System.out.println("Browser Artwork Uploaded on Canvas");
		Thread.sleep(2000);

		//		UploadArtwrkFile.sendKeys("/Users/rammy/Downloads/BeforeCart.png");
		//		Thread.sleep(8000);
		//		js.executeScript("window.scrollBy(0,100)");
		//		ClickOnApply.click();
		//		System.out.println("Custom Artwork Uploaded on canvas");	

	}

	public void UpdateCartButton() {
		UpdateCart.click();
	}	
}
