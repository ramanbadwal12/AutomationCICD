package SGS.TestComponent;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;

import SGS.SportsGearSwag.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver InitializeDriver() throws IOException {
	    Properties prop = new Properties();
	    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/SGS/Resources/GlobalData.properties");
	    prop.load(fis);

	    String browserName = prop.getProperty("browser");

	    if (browserName.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();
	        options.setPageLoadStrategy(PageLoadStrategy.EAGER); // Faster but ensures DOM is ready
	        options.addArguments("--disable-gpu", "--disable-extensions", "--disable-popup-blocking");
	        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
	        options.addArguments("--disable-blink-features=AutomationControlled"); 
	        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	        options.setExperimentalOption("useAutomationExtension", false);
	        driver = new ChromeDriver(options);
	    } 
	    
	    else if (browserName.equalsIgnoreCase("firefox")) {
	        WebDriverManager.firefoxdriver().setup();
	        FirefoxOptions options = new FirefoxOptions();
	        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	        driver = new FirefoxDriver(options);
	    } 
	    
	    else if (browserName.equalsIgnoreCase("edge")) {
	        WebDriverManager.edgedriver().setup();
	        EdgeOptions options = new EdgeOptions();
	        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	        driver = new EdgeDriver(options);
	    } 
	    
	    else if (browserName.equalsIgnoreCase("safari")) {
	        driver = new SafariDriver();
	        driver.manage().window().maximize();
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