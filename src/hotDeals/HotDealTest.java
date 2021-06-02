package hotDeals;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class HotDealTest extends BaseTest {

    /*
●	Create the package hotdeals
●	Create the class HotDealsTest
	1 - verifySaleProductsArrangeAlphabetically()
		1.1 Mouse hover on the “Hot deals” link
		1.2 Mouse hover on the “Sale”  link and click
		1.3 Verify the text “Sale”
		1.4 Mouse hover on “Sort By” and select “Name A-Z”
		1.5 Verify that the product arrange alphabetically
	2 - verifySaleProductsPriceArrangeLowToHigh()
		2.1 Mouse hover on the “Hot deals” link
		2.2 Mouse hover on the “Sale”  link and click
		2.3 Verify the text “Sale”
		2.4 Mouse hover on “Sort By” and select “Price Low-High”
		2.5 Verify that the product’s price arrange Low to High
	3 - verifySaleProductsArrangeByRates()
		3.1 Mouse hover on the “Hot deals” link
		3.2 Mouse hover on the “Sale”  link and click
		3.3 Verify the text “Sale”
		3.4 Mouse hover on “Sort By” and select “Rates”
		3.5 Verify that the product’s arrange Rates
	4 - verifyBestSellersProductsArrangeByZToA()
		1.1 Mouse hover on the “Hot deals” link
		1.2 Mouse hover on the “Bestsellers”  link and click
		1.3 Verify the text “Bestsellers”
		1.4 Mouse hover on “Sort By” and select “Name Z-A”
		1.5 Verify that the product arrange by Z to A
	5 - verifyBestSellersProductsPriceArrangeHighToLow()
		2.1 Mouse hover on the “Hot deals” link
		2.2 Mouse hover on the “Bestsellers” link and click
		2.3 Verify the text “Bestsellers”
		2.4 Mouse hover on “Sort By” and select “Price High-Low”
		2.5 Verify that the product’s price arrange High to Low
	6 - verifyBestSellersProductsArrangeByRates()
		3.1 Mouse hover on the “Hot deals” link
		3.2 Mouse hover on the “Bestsellers”  link and click
		3.3 Verify the text “Bestsellers”
		3.4 Mouse hover on “Sort By” and select “Rates”
		3.5 Verify that the product’s arrange Rates

     */


    String baseUrl = "https://mobile.x-cart.com/";

    @Before

    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test

    public void verifyUserShouldNavigateToSalePageSuccessfully() throws InterruptedException {

        mouseHoverToElement(By.xpath("(//li[@class='leaf has-sub']/child::span[text()='Hot deals'])[2]"));
        mouseHoverAndClickElement(By.xpath("(//span[text()='Sale'])[2]"));
        Thread.sleep(3000);
        verifyPageNavigation(By.xpath("//h1[@id='page-title']"), "Sale");

    }

    @Test

    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {

        verifyUserShouldNavigateToSalePageSuccessfully();
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//div[@class=\"sort-box\"]"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Name A - Z')]"));
        Thread.sleep(3000);
        List<WebElement> productName = driver.findElements(By.xpath("//div[@class='items-list items-list-products sale-products']//h5"));
        verifyProductSortedAsPerAlphabaticalOrder("(//div[@class='items-list items-list-products sale-products']//h5)", productName);

    }

    @Test

    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {

        verifyUserShouldNavigateToSalePageSuccessfully();
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//div[@class=\"sort-box\"]"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Price Low - High')]"));
        Thread.sleep(3000);
        List<WebElement> productPriceList = driver.findElements(By.xpath("//div[@class='items-list items-list-products sale-products']//span[@class='price product-price']"));

        verifyProductSortedAsPerPriceLowToHighFilter("(//div[@class='items-list items-list-products sale-products']//span[@class='price product-price'])",productPriceList);
    }

    @Test

    public void verifySaleProductsArrangeByRates() throws InterruptedException {

        verifyUserShouldNavigateToSalePageSuccessfully();
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//div[@class=\"sort-box\"]"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Rates')]"));
        Thread.sleep(2000);
        List<WebElement> productRatesList = driver.findElements(By.xpath("//div[@class='products']//div[@class='stars-row full']"));

        verifyProductSortedAsPerRatesFilter("(//div[@class='products']//div[@class='stars-row full'])",productRatesList);

    }


    @Test

    public void verifyUserShouldNavigateToBestsellersPageSuccessfully() throws InterruptedException {

        mouseHoverToElement(By.xpath("(//span[contains(text(),'Hot deals')])[2]"));
        mouseHoverAndClickElement(By.xpath("(//span[text()='Bestsellers'])[2]"));
        Thread.sleep(2000);
        verifyPageNavigation(By.xpath("//h1[@id='page-title']"), "Bestsellers");

    }

    @Test

    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {

        verifyUserShouldNavigateToBestsellersPageSuccessfully();
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//div[@class='sort-box']"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Name Z - A')]"));
        Thread.sleep(2000);
        List<WebElement> productName = driver.findElements(By.xpath("//div[@class='products']//h5"));

        verifyProductSortedAsPerZToAFilter("(//div[@class='products']//h5)",productName);
    }

    @Test

    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {

        verifyUserShouldNavigateToBestsellersPageSuccessfully();
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//div[@class='sort-box']"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Price High - Low')]"));
        Thread.sleep(2000);

        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='products']//span[@class='price product-price']"));

        verifyProductSortedAsPerPriceHighToLowFilter("(//div[@class='products']//span[@class='price product-price'])",priceList);
    }

    @Test

    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {

        verifyUserShouldNavigateToBestsellersPageSuccessfully();
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//div[@class='sort-box']"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Rates')]"));
        List<WebElement> productRatesList = driver.findElements(By.xpath("//div[@class='products']//div[@class='stars-row full']"));

        verifyProductSortedAsPerRatesFilter("(//div[@class='products']//div[@class='stars-row full'])",productRatesList);

    }


    @After

    public void tearDown() {

        closeBrowser();
    }

}
