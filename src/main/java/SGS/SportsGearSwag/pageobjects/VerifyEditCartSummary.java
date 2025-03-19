package SGS.SportsGearSwag.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class VerifyEditCartSummary {

    WebDriver driver;
    private String cleanedText;
    private String formattedTotal;
    private String formattedDate;
    private String shippingAmount;

    public VerifyEditCartSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Get the overall jersey amount and other details
    public void getOverallJerseyAmount() {
        // Get overall jersey cost
        String jerseyAmount = driver.findElement(By.xpath("//div[@class='ant-col ant-col-7 desktop item_cost']")).getText();
        cleanedText = jerseyAmount.replaceAll("[^\\d.]", "");
        System.out.println("Per Jersey Amount: " + cleanedText);

        // Get sum of customization costs multiplied by 5
        List<WebElement> allRows = driver.findElements(By.xpath("//div[@id='add_to_cart_breakdown_details']//table/tbody/tr/td[2]"));

        double sum = 0;  
        for (int i = 0; i < allRows.size(); i++) {
            if (i == 6 || i == 10) {
                continue;
            }
            String rowText = allRows.get(i).getText();
            System.out.println(rowText);
            String cleanText = rowText.replace("$", "").replace(",", "").trim();
            double value = Double.parseDouble(cleanText);
            sum += value;
        }

        double total = sum * 5;
        System.out.println(sum);
        formattedTotal = String.format("%.2f", total);
        System.out.println("Total sum multiplied by 5: " + formattedTotal);

        // Get shipping date from editor
        String shippingDate = driver.findElement(By.xpath("//div[@class='ant-card-body']"
        		+ "//div[@class='ant-col ant-col-4 p-1 choose-delivery-cols '][6]")).getText();
        String[] lines = shippingDate.split("\\n|,");
        String datePart = lines[0].trim();
        String monthYearPart = lines[1].trim() + " " + lines[2].trim();
        formattedDate = datePart + " " + monthYearPart;
        System.out.println("Shipping Date: " + formattedDate);

        // Get shipping amount from editor
        shippingAmount = driver.findElement(By.xpath("//td[@class='ant-table-cell breakdown-cell text-right breakdown-free-cost']")).getText();
        System.out.println("Shipping Charges: " + shippingAmount);
    }

    // Method to get the cart details
    public void getCartDetails() {
        List<WebElement> allRows1 = driver.findElements(By.xpath("//table[@class='table table-bordered cartTablePrice ']//tbody/tr/td[2]"));

        if (allRows1.size() >= 2) {
            WebElement jerseyPrice = allRows1.get(1);
            String secondElementText = jerseyPrice.getText();
            String cleanedText2 = secondElementText.replace("$", "").trim();
            System.out.println("Per Jersey Amount: " + cleanedText2);
//            Assert.assertEquals(cleanedText, cleanedText2, "Jersey price mismatch between editor and cart!");
        }

        List<WebElement> allRows3 = driver.findElements(By.xpath("//table[@class='table table-bordered cartTablePrice ']//tbody/tr/td[2]"));
        if (allRows3.size() >= 3) {
            WebElement thirdElement = allRows3.get(2);
            String thirdElementText = thirdElement.getText();
            String cleanedText3 = thirdElementText.replace("$", "").trim();
            System.out.println("Total sum multiplied by 5: " + cleanedText3);
//            Assert.assertEquals(formattedTotal, cleanedText3, "Total amount mismatch between editor and cart!");
        }

        List<WebElement> allRows4 = driver.findElements(By.xpath("//table[@class='table table-bordered cartTablePrice ']//tbody/tr/td[2]"));
        if (allRows4.size() >= 4) {
            WebElement fourthElement = allRows4.get(3);
            String fourthElementText = fourthElement.getText();
            System.out.println("Shipping Date: " + fourthElementText);
//            Assert.assertEquals(formattedDate, fourthElementText, "Shipping date mismatch between editor and cart!");
        }

        List<WebElement> allRows5 = driver.findElements(By.xpath("//table[@class='table table-bordered cartTablePrice ']//tbody/tr/td[2]"));
        if (allRows5.size() >= 5) {
            WebElement fifthElement = allRows5.get(4);
            String fifthElementText = fifthElement.getText();
            System.out.println("Shipping Charges: " + fifthElementText);
//            Assert.assertEquals(shippingAmount, fifthElementText, "Shipping amount mismatch between editor and cart!");
        }
    }
}
