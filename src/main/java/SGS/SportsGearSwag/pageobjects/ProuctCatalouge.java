package SGS.SportsGearSwag.pageobjects;




import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SGS.AbstractComponents.AbstractComponent;

public class ProuctCatalouge extends AbstractComponent {

	WebDriver driver;
	WebDriverWait wait;

	public  ProuctCatalouge(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10-second explicit wait

		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath= "//div[contains(text(),'BA253')]")
	WebElement selectStyle;

	@FindBy(xpath= "//div[normalize-space()='Reversible Jersey']")
	WebElement selectApparel;

	@FindBy(xpath= "//div[contains(text(),'Embroidered')]")
	WebElement selectPrint;

	@FindBy(xpath= "//div[contains(text(),'Poly-Mesh')]")
	WebElement selectFrabric;
	@FindBy(xpath= "//div[contains(text(),'PRO-Wick')]")
	WebElement selectFrabric2;

	@FindBy(xpath= "//div[normalize-space()='Round Shape']")
	WebElement selectNeckline;

	@FindBy(xpath = "//input[@id='sizes_JERSEY_S']")
	WebElement selectSize1;

	@FindBy(xpath= "//button[@class='ant-btn roster-yes-btn g-btn ']")
	WebElement ClickRoaster;

	@FindBy(xpath= "//div[@class='ant-upload ant-upload-select ant-upload-select-text']//input[@type='file']")
	WebElement UploadRoaster;

	@FindBy(xpath= "//span[@aria-label='shopping-cart']")
	WebElement addCart;

	public void clickOnProduct() throws InterruptedException {


		System.out.println("Landing on homepage"); Thread.sleep(1000);


		List <WebElement>products =driver.findElements(By.cssSelector(".mt-3"));
		WebElement prod =products.stream().filter(product->
		product.findElement(By.xpath("//div[text()='Custom 3-Pointer Stars Adult Youth Unisex Basketball Jersey - Reversible Uniform']")).getText()
		.equals("Custom 3-Pointer Stars Adult Youth Unisex Basketball Jersey - Reversible Uniform")).findFirst().orElse(null);



		prod.findElement(By.xpath("//div[text()='Custom 3-Pointer Stars Adult Youth Unisex Basketball Jersey - Reversible Uniform']")).click();
		System.out.println("Product is selected and redirecting to Editorpage");
		Thread.sleep(2000);

	}

	public void chooseStyle() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(selectStyle)).click();
		System.out.println("Style is selected");

	}

	public void chooseApparel() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(selectApparel)).click();
		System.out.println("Apparel is selected");
	}

	public void choosePrint() {
		wait.until(ExpectedConditions.elementToBeClickable(selectPrint)).click();
		System.out.println("Print is selected");
	}

	public void chooseFrabric() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(selectFrabric)).click();
		wait.until(ExpectedConditions.elementToBeClickable(selectFrabric2)).click();
		System.out.println("Fabric is selected");
	}

	public void chooseNeckline() {
		wait.until(ExpectedConditions.elementToBeClickable(selectNeckline)).click();
		System.out.println("Neckline is selected");
	}

	public void chooseSize(String size1) throws InterruptedException {
		selectSize1.sendKeys(size1);
		Thread.sleep(1000);
	}

	public void AddRoaster() throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(ClickRoaster)).click();
		UploadRoaster.sendKeys("/Users/rammy/Downloads/Roster.xlsx");
		System.out.println("Roaster sheet is uploaded");
	}

	public void AddToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(addCart)).click();
		System.out.println("Added to cart");	}

}

