package SGS.SportsGearSwag.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdditionalAccessories {

	WebDriver driver;
	public  AdditionalAccessories(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath="(//span[contains(text(),'Choose Your Sizes')])[3]")
	WebElement ChoosePoloAccessories;

	@FindBy(xpath="//input[@id='sizes_accessory_HOODIE_M']")
	WebElement EnterAccessoiresSize;

	@FindBy(xpath="//span[normalize-space()='Save']")
	WebElement SaveButton;

	@FindBy(xpath= "(//button[@class='ant-switch ant-switch-small'])[1]")
	WebElement ClickRoaster;

	@FindBy(xpath= "(//input[@id='roster_1_M_teamName'])[1]")
	WebElement EnterRaosterValue;

	@FindBy(xpath= "//div[@class='col-12 text-center']//textarea[@id='accessoriesNote']")
	WebElement EnterNotes;

	@FindBy(xpath="(//span[contains(text(),'Save')])[3]")
	WebElement ClickSaveButton;


	@FindBy(xpath="(//button[@class='ant-switch ant-switch-small'])[1]")
	WebElement AccessoriesArtwork;

	@FindBy(xpath="(//button[@class='ant-switch ant-switch-small'])[1]")
	WebElement SGSLogoDiscount;

	@FindBy(xpath="//div[contains(@class,'ant-upload ant-upload-select ant-upload-select-picture')]"
			+ "//input[@id='accessory-artwork-upload']")
	WebElement UploadImage;

	@FindBy(xpath= "(//span[contains(text(),'Save')])[4]")
	WebElement ClickSave;



	public void Accessories() throws InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1800)");
		Thread.sleep(1000);
		ChoosePoloAccessories.click();
		System.out.println("Accessoroes is selected");
		Thread.sleep(1000);
		EnterAccessoiresSize.sendKeys("1");
		SaveButton.click();
		System.out.println("Accessories Added sucessfully");
		Thread.sleep(3000);
		ClickRoaster.click();
		Thread.sleep(2000);
		EnterRaosterValue.click();
		EnterRaosterValue.sendKeys("Jassi");
		EnterNotes.sendKeys("Make it little bold");
		Thread.sleep(3000);
		ClickSaveButton.click();
		System.out.println("Roaster added for accessories");
		AccessoriesArtwork.click();
		Thread.sleep(2000);
		UploadImage.sendKeys("/Users/rammy/Downloads/Cart.png");
		Thread.sleep(8000);
		ClickSave.click();
		System.out.println(" Custom Artwork uploaded for Accessories");	
		SGSLogoDiscount.click();
		Thread.sleep(1000);
		System.out.println("SGS Logo discount applied sucessfully");
	}
}