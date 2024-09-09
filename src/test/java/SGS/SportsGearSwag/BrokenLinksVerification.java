package SGS.SportsGearSwag;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import SGS.SportsGearSwag.pageobjects.AccountDashBoardBroken;
import SGS.SportsGearSwag.pageobjects.AllProductsFromBannerBroken;
import SGS.SportsGearSwag.pageobjects.CategoryLandingPageBroken;
import SGS.SportsGearSwag.pageobjects.CategoryShopPageBroken;
import SGS.SportsGearSwag.pageobjects.EmailQuoteBroken;
import SGS.SportsGearSwag.pageobjects.HomageNavBar;
import SGS.SportsGearSwag.pageobjects.HomepageHeaderBroken;
import SGS.SportsGearSwag.pageobjects.OrderHistoryBroken;
import SGS.SportsGearSwag.pageobjects.SavedCartBroken;
import SGS.SportsGearSwag.pageobjects.SavedDesignBroken;
import SGS.SportsGearSwag.pageobjects.SiteMapBroken;
import SGS.TestComponent.BaseTest;

public class BrokenLinksVerification extends BaseTest {


	@Test
	public void verifyBrokenLinks() {
		AccountDashBoardBroken accountDashboardPage = new AccountDashBoardBroken(driver);
		accountDashboardPage.loginToAccount("rammybadwal@gmail.com", "123456");
		List<WebElement> links = accountDashboardPage.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = accountDashboardPage.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);
	}

	@Test
	public void verifyBannerBrokenLinks() {
		AllProductsFromBannerBroken allProductsFromBanner = new AllProductsFromBannerBroken(driver);
		allProductsFromBanner.ClickBannerPage();
		List<WebElement> links = allProductsFromBanner.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = allProductsFromBanner.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);
	}

	@Test
	public void VerifyCategoryLinks() {
		CategoryLandingPageBroken categoryLandingPageBroken = new CategoryLandingPageBroken(driver);
		categoryLandingPageBroken.getLandingProductBlocksSection();
		List<WebElement> links = categoryLandingPageBroken.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = categoryLandingPageBroken.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);
	}

	@Test
	public void VerifyShopLinks() throws InterruptedException {
		CategoryShopPageBroken categoryShopPageBroken = new CategoryShopPageBroken(driver);
		categoryShopPageBroken.getAllProductsListSection();
		List<WebElement> links = categoryShopPageBroken.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = categoryShopPageBroken.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);
	}

	@Test
	public void EmailQuoteLinks() {
		EmailQuoteBroken emailQuoteBroken = new EmailQuoteBroken(driver);
		emailQuoteBroken.EmailQuote("rammybadwal@gmail.com", "123456");
		List<WebElement> links = emailQuoteBroken.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = emailQuoteBroken.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);
	}

	@Test
	public void HeaderLinks() {
		HomepageHeaderBroken homepageHeaderBroken = new HomepageHeaderBroken(driver);
		homepageHeaderBroken.getHeaderSection();
		List<WebElement> links = homepageHeaderBroken.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = homepageHeaderBroken.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);
	}

	@Test
	public void HeaderNavLinks() {
		HomageNavBar homageNavBar = new HomageNavBar(driver);
		homageNavBar.getNavSection();
		List<WebElement> links = homageNavBar.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = homageNavBar.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);
	}

	@Test
	public void OrderHistoryLink() {
		OrderHistoryBroken orderHistoryBroken = new OrderHistoryBroken(driver);
		orderHistoryBroken.OrderHistory("rammybadwal@gmail.com", "123456");
		List<WebElement> links = orderHistoryBroken.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = orderHistoryBroken.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);	
	}

	@Test
	public void SavedCartLinks() {
		SavedCartBroken savedCartBroken = new SavedCartBroken(driver);
		savedCartBroken.SavedCart("rammybadwal@gmail.com", "123456");
		List<WebElement> links = savedCartBroken.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = savedCartBroken.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);
	}

	@Test
	public void SavedDesignLinks() {
		SavedDesignBroken savedDesignBroken = new SavedDesignBroken(driver);
		savedDesignBroken.SavedDesign("rammybadwal@gmail.com", "123456");
		List<WebElement> links = savedDesignBroken.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = savedDesignBroken.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);
	}

	@Test
	public void SiteMapLinks() throws InterruptedException {
		SiteMapBroken siteMapBroken = new SiteMapBroken(driver);
		siteMapBroken.getSiteMapSection();
		List<WebElement> links = siteMapBroken.getAllLinksInAccountSection();
		System.out.println("Total links found: " + links.size());
		List<String> brokenLinks = siteMapBroken.findBrokenLinks(links);
		reportBrokenLinks(brokenLinks);
	}


	private void reportBrokenLinks(List<String> brokenLinks) {
		if (!brokenLinks.isEmpty()) {
			System.out.println("Broken links found:");
			for (String brokenLink : brokenLinks) {
				System.out.println(brokenLink);
			}
		} else {
			System.out.println("No broken links found.");
		}
	}
}
