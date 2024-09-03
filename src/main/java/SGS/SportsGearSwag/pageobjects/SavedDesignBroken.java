package SGS.SportsGearSwag.pageobjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SavedDesignBroken {

	 WebDriver driver;

	    public SavedDesignBroken(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Locators
	    @FindBy(xpath = "//h5[normalize-space()='My Account']")
	    WebElement myAccountLink;

	    @FindBy(xpath = "//input[@id='inputEmailAddress']")
	    WebElement emailField;

	    @FindBy(xpath = "//input[@id='inputPassword']")
	    WebElement passwordField;

	    @FindBy(xpath = "//button[normalize-space()='Sign In']")
	    WebElement signInButton;
	    
	    @FindBy(xpath="//h5[normalize-space()='Email Quote']")
	    WebElement SavedDesigClick;

	    @FindBy(css = ".customer-saved-designs.mb-5.mt-4")
	    WebElement SavedDesignSection;

	    @FindBy(tagName = "a")
	    List<WebElement> linksInSection;

	    // Methods
	    public void SavedDesign(String email, String password) {
	        myAccountLink.click();
	        emailField.sendKeys(email);
	        passwordField.sendKeys(password);
	        signInButton.click();
	        SavedDesigClick.click();
	    }

	    public List<WebElement> getAllLinksInAccountSection() {
	        return SavedDesignSection.findElements(By.tagName("a"));
	    }

	    public List<String> findBrokenLinks(List<WebElement> links) {
	        List<String> brokenLinks = new ArrayList<>();
	        for (WebElement link : links) {
	            String url = link.getAttribute("href");
	            if (url != null && !url.isEmpty()) {
	                try {
	                    @SuppressWarnings("deprecation")
						HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	                    connection.setInstanceFollowRedirects(true); 
	                    connection.setRequestMethod("HEAD");
	                    connection.connect();
	                    
	                    int responseCode = connection.getResponseCode();
	                    if (responseCode >= 300) {
	                        brokenLinks.add(url);
	                    }
	                } catch (Exception e) {
	                    brokenLinks.add(url); 
	                }
	            }
	        }
	        return brokenLinks;
	    }
	}

