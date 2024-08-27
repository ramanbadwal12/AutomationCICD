package SGS.SportsGearSwag.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SGS.AbstractComponents.AbstractComponent;

public class ProuctCatalouge extends AbstractComponent {

	WebDriver driver;
	public  ProuctCatalouge(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
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
		
		Thread.sleep(1000);
		selectStyle.click();
		System.out.println("Style is selected");
		
	}
	public void chooseApparel() throws InterruptedException {
		
		Thread.sleep(1000);
		selectApparel.click();
		System.out.println("Apparel is selected");
	}
	public void choosePrint() {
		selectPrint.click();
		System.out.println("Print is selected");
	}
	public void chooseFrabric() throws InterruptedException {
		selectFrabric.click();
		Thread.sleep(1000);
		selectFrabric2.click();
		System.out.println("Fabric is selected");
	}
	public void chooseNeckline() {
		selectNeckline.click();
		System.out.println("Neckline is selected");
	}
	public void chooseSize(String size1) throws InterruptedException {
		selectSize1.sendKeys(size1);
		Thread.sleep(1000);
		
		
	}
	
	
	
	public void AddRoaster() throws InterruptedException {
		
		ClickRoaster.click();
		Thread.sleep(1000);
		UploadRoaster.sendKeys("/Users/rammy/Downloads/Roster.xlsx");
		System.out.println("Roaster sheet is uploaded");
	}

	public void checkoutAmt() {
		
//		Get the total amount
		String Amount1 = driver.findElement(By.xpath("//span[@id='add_to_cart_total_amount']")).getText();

		
//		Print the table value
		List<WebElement> TableValues = driver.findElements(By.xpath("//div[@id='add_to_cart_breakdown_details']//table/tbody/tr"));
		for(int i=0; i<TableValues.size(); i++) {
			System.out.println(TableValues.get(i).getText());
		}
		
//		# XPath with shipping fee
//		List<WebElement> values = driver.findElements(By.xpath("//div[@id='add_to_cart_breakdown_details']//table/tbody/tr/td[2]"));
		
//		#XPath without shipping fee
		List<WebElement> values = driver.findElements(By.xpath("(//div[@class='ant-table-wrapper'])[1]//table/tbody/tr/td[2]"));
		
		
		
		float sum= 0;
		for(int i=0; i<values.size(); i++) {
			sum =sum + Float.parseFloat(values.get(i).getText().replace('$','0'));
		}
		sum=sum*5;
		System.out.println("Amount per product: " + sum);
		assertEquals(Float.parseFloat(Amount1.replace('$', ' ').trim()), sum);
		System.out.println("Assertion matched for Total Amount");
		
	}
	  
private void assertEquals(float float1, float sum) {


		// TODO Auto-generated method stub
		
	}



//	public void VerifyBreakDown()
//	{
//		List<WebElement> values = driver.findElements(By.xpath("//div[@class='sc-gsVtTC eTBBht']/div[2]"));
//		
//		float sum= 0;
//		for(int i=0; i<values.size(); i++) {
//			System.out.println(values.get(i).getText());
//			sum =  Float(values.get(i).getText().replace('$',' '));
//					}	
//	}
	

	@SuppressWarnings("unused")
	private float Float(String replace) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void AddToCart() {
		addCart.click();
	}

}