package SGS.SportsGearSwag;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlonetest{
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
driver.get("https://www.sportsgearswag.com/cart/?id=2859c0ad-f6cf-423c-9a4c-6fbdd9e707f4");

//Click on edit cart

driver.findElement(By.xpath("//i[@class='fa fa-edit']")).click();
Thread.sleep(2000);
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,4800)");
Thread.sleep(2000);



driver.close();
}}