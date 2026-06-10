package SGS.SportsGearSwag;

import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class StandAloneTest {
 
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
	
 
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 
		driver.get("https://test.im-at.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.id("cookiescript_accept")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cookiescript_accept"))).click();
		
		Thread.sleep(2000L);
		
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-basic"))).click();
 
		driver.findElement(By.cssSelector("div[class='d-none d-md-block'] a:nth-child(2)")).click();
		
		driver.findElement(By.cssSelector("button[title='Continue with your email']")).click();
		
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("imathost@yopmail.com");
		
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("Abc@1234");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
		
		//driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		 By toastMessage = By.cssSelector(".Toastify__toast-body");
 
	        String toastText = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(toastMessage)
	        ).getText();
 
	        System.out.println("Toast message: " + toastText);
	        
	    driver.findElement(By.cssSelector(".styled__BecomeAHost-sc-1d47na1-5.bbpzRs")).click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Activity Name']"))).sendKeys("Sel Test");
	    
	    //driver.findElement(By.cssSelector("input[placeholder='Activity Name']")).sendKeys("Sel Test");
	 // Locate react-select input
	    Thread.sleep(1000L);
	    WebElement reactSelectInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-2-input")));
 
	    // Click using JS to avoid blur
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reactSelectInput);
 
	    // Small wait for menu render
	    Thread.sleep(1000L);
 
	    // Select first option using keyboard
	    reactSelectInput.sendKeys(Keys.ARROW_DOWN);
	    reactSelectInput.sendKeys(Keys.ENTER);
        
	    
	    Thread.sleep(2000L);
	    driver.findElement(By.xpath("(//div[@class='styled__RadioIconWrapper-sc-16e6cp1-2 cCsiJO'])[1]")).click();
        
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='styled__RadioIconWrapper-sc-16e6cp1-2 cCsiJO'])[1]"))).click();
	    Thread.sleep(1000L);
	    driver.findElement(By.cssSelector("button[title='Next']")).click();
 
	 //   driver.findElement(By.cssSelector("select[name='minAge']")).click();
	    
	    WebElement minAgeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.name("minAge")));
        minAgeDropdown.click();
 
        Select select = new Select(minAgeDropdown);
        select.selectByValue("5");
        
        driver.findElement(By.cssSelector("div[class='styled__InputRadioInlineWrapper-sc-17qnefm-15 ibGvZn'] div:nth-child(1) div:nth-child(1) div:nth-child(1)")).click();
        
        driver.findElement(By.cssSelector("textarea[placeholder='Requirements']")).sendKeys("Test");
        Thread.sleep(2000);
        
       
        
        driver.findElement(By.cssSelector("button[title='Next']")).click();
        
        Thread.sleep(2000L);
        driver.findElement(By.cssSelector("textarea[placeholder='Description']")).sendKeys("Test");
      
   
        
        //Food and language dropdown code here
    
        
        WebElement selectDropdown = driver.findElement(By.xpath(("(//div[@class='inputSelectWrapper'])[1]")));
        		
        
 
        selectDropdown.click();

     // Use Actions for keyboard
     Actions actions = new Actions(driver);
     actions.sendKeys(Keys.ARROW_DOWN)
            .sendKeys(Keys.ENTER)
            .perform();

     WebElement selectDropdown2 = driver.findElement(By.xpath(("(//div[@class='inputSelectWrapper'])[2]")));
		
     
     
     selectDropdown2.click();

  // Use Actions for keyboard
  Actions actions2 = new Actions(driver);
  actions2.sendKeys(Keys.ARROW_DOWN)
         .sendKeys(Keys.ENTER)
         .perform();
        
//	    Thread.sleep(3000L);
//	    driver.quit();
 
	}
 
}