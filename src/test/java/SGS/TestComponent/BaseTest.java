package SGS.TestComponent;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;

import SGS.SportsGearSwag.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;

	@SuppressWarnings("deprecation")
	public WebDriver InitializeDriver() throws IOException {

		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("/Users/rammy/SportsGearSwag/SportsGearSwag"
				+ "/src/main/java/SGS/Resources/GlobalData.properties");
		prop.load(fis);

		String browserName = prop.getProperty("browser");


		if (browserName.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
		
		else if (browserName.equalsIgnoreCase("firefox")) {
	        WebDriverManager.firefoxdriver().setup();
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    } 
		
		 else if (browserName.equalsIgnoreCase("edge")) {
		        WebDriverManager.edgedriver().setup();
		        driver = new EdgeDriver();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		    }
		
		 else if (browserName.equalsIgnoreCase("safari")) {
		        driver = new SafariDriver();  // SafariDriver is built-in on macOS
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		    }
		
		driver.manage().window().maximize();
		return driver;

	}
	
	public String getScreenshot(String testCaseName, WebDriver driver ) throws IOException 
	{
		TakesScreenshot ts =  (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File (System.getProperty("user.dir") + "//reports//" + testCaseName + ".png"); 
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png"; 
	}
	
	 

	@BeforeMethod (alwaysRun=true)
	public LandingPage LaunchApplication() throws IOException{

		driver = InitializeDriver();

		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;


	}}