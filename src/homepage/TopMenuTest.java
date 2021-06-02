package homepage;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    /*
    ●	Create class TopMenuTest
	1 - verifyUserShouldNavigateToShippingPageSuccessfully()
		1.1 Click on the “Shipping” link
		1.2 Verify the text “Shipping”
	2 - verifyUserShouldNavigateToNewPageSuccessfully()
		2.1 Click on the “New!” link
		2.2 Verify the text “New arrivals”
	3 - verifyUserShouldNavigateToComingsoonPageSuccessfully()
		3.1 Click on the “Coming soon” link
		3.2 Verify the text “Coming soon”
	4 - verifyUserShouldNavigateToContactUsPageSuccessfully()
		4.1 Click on the “Contact us” link
		4.2 Verify the text “Contact us”
     */

    String baseUrl="https://mobile.x-cart.com/";
    @Before

    public void setUp(){

        openBrowser(baseUrl);

    }

    @Test

    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {

        Thread.sleep(3000);
        clickOnElement(By.xpath("(//span[text()='Shipping'])[2]"));
        verifyPageNavigation(By.xpath("//h1[@id='page-title']"),"Shipping");
    }

    @Test

    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {

        clickOnElement(By.xpath("(//span[text()='New!'])[2]"));
        Thread.sleep(3000);
        verifyPageNavigation(By.xpath("//h1[@id='page-title']"),"New arrivals");
    }

    @Test

    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() throws InterruptedException {

        clickOnElement(By.xpath("(//span[text()='Coming soon'])[2]"));
        Thread.sleep(3000);
        verifyPageNavigation(By.xpath("//h1[@id='page-title']"),"Coming soon");

    }

    @Test

    public void verifyUserShouldNavigateToContactUsPageSuccessfully() throws InterruptedException {

        clickOnElement(By.xpath("(//span[text()='Contact us'])[2]"));
        Thread.sleep(3000);
        verifyPageNavigation(By.xpath("//h1[@id='page-title']"),"Contact us");

    }

    @After

    public void tearDown(){

        closeBrowser();
    }

}
