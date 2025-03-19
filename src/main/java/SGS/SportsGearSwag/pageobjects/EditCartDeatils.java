package SGS.SportsGearSwag.pageobjects;


import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class EditCartDeatils {

	WebDriver driver;
	private WebDriverWait wait;

	public  EditCartDeatils(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed

	}

	@FindBy(xpath= "//i[@class='fa fa-edit']")
	WebElement EditCartButton;

	@FindBy(xpath= "//div[@class='sc-JAcuL rhuht'][normalize-space()='Uniform']")
	WebElement ChooseUniform;

	@FindBy(xpath= "//div[contains(text(),'PRO-Air')]")
	WebElement ChooseFabric;

	@FindBy(xpath= "//div[normalize-space()='Y Shape']")
	WebElement ChooseNeckline;

	@FindBy(xpath= "//div[contains(text(),'Zip Pockets')]")
	WebElement ChoosePockets;

	public void EditCart() {
		wait.until(ExpectedConditions.elementToBeClickable(EditCartButton)).click();
	}

	public void ChangeCustomizations() throws InterruptedException {

		System.out.println("Landing on Editor Page Again");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		ChooseUniform.click();
		System.out.println("Uniform is Selected");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		ChooseFabric.click();
		ChooseNeckline.click();
		System.out.println("Fabric and Neckline is Selected");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		ChoosePockets.click();
		System.out.println("Pockets are Selcted");
		Thread.sleep(2000);

	}
}


