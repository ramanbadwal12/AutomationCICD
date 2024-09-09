package SGS.SportsGearSwag.pageobjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryShopPageBroken {

	WebDriver driver;
	WebDriverWait wait;


	public CategoryShopPageBroken(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "(//a[@id='navbarDropdownbasketball'])[3]")
	WebElement ClickCategoryHome;
	@FindBy(xpath="//h2[normalize-space()='BASKETBALL JERSEYS']")
	WebElement ClickCategory;
	@FindBy(css = "#all-products-list")
	WebElement allProductsListSection;
	@FindBy(tagName = "a")
	List<WebElement> linksInSection;

	public WebElement getAllProductsListSection() throws InterruptedException {

		ClickCategoryHome.click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		ClickCategory.click();
		js.executeScript("window.scrollBy(0,4000)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,2700)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,2900)");
		Thread.sleep(3000);
		return allProductsListSection;
	}


	public List<WebElement> getAllLinksInAccountSection() {
		return allProductsListSection.findElements(By.tagName("a"));
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
