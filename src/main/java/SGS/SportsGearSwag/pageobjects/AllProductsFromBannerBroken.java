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

public class AllProductsFromBannerBroken {

	WebDriver driver;

	public AllProductsFromBannerBroken(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
	@FindBy(xpath = "//div[@class='carousel-item active']//img[@alt='SGS Banner']")
	WebElement ClickBanner;

	@FindBy(css = "#shop-products-list")
	WebElement LinkSection;

	@FindBy(tagName = "a")
	List<WebElement> linksInSection;

	// Methods
	public void ClickBannerPage() {
		ClickBanner.click();

	}

	public List<WebElement> getAllLinksInAccountSection() {
		return LinkSection.findElements(By.tagName("a"));
	}

	public List<String> findBrokenLinks(List<WebElement> links) {
		List<String> brokenLinks = new ArrayList<>();
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty()) {
				try {
					@SuppressWarnings("deprecation")
					HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
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



