package shopping;

import hotDeals.HotDealTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShoppingTest extends HotDealTest {

    /*
●	Create the package shopping
●	Create the class ShoppingTest
    1 - verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetooth Speaker()
    1.1 Mouse hover on the “Hot deals” link
    1.2 Mouse hover on the “Sale”  link and click
    1.3 Verify the text “Sale
    1.4 Mouse hover on “Sort By” and select “Name A-Z”
    1.5 Click on “Add to cart” button of the product “Cup of Mojo Bluetooth
          Speaker”
    1.6 Verify the message “Product has been added to your cart” display in  green bar
    1.7 Click on X sign to close the message
    1.8 Click on “Your cart” icon and Click on “View cart” button
    1.9 Verify the text “Your shopping cart - 1 item”
    1.10 Change the Qty = 2
    1.11 Verify the text “Your shopping cart - 2 items”
    1.12 Verify the Subtotal $39.98
    1.13 Verify the total $46.18
    1.14 Click on “Go to checkout” button
    1.15 Verify the text “Log in to your account”
    1.16 Enter Email address
    1.17 Click on “Continue” Button
    1.18 Verify the text “Secure Checkout”
    1.19 Fill all the mandatory fields
    1.20 Check the check box “Create an account for later use”
    1.21 Enter the password
    1.22 Select the Delivery Method to “Local Shipping”
    1.23 Select Payment Method “COD”
    1.24 Verify the total $47.22
    1.25 Click on “Place Order” Button
    1.26 Verify the text “Thank you for your order”

    2 - verifyThatUserShouldClearShoppingCartSuccessfully()
    1.1 Mouse hover on the “Hot deals” link
    1.2 Mouse hover on the “Bestseller”  link and click
    1.3 Verify the text “Bestsellers”
    1.4 Mouse hover on “Sort By” and select “Name A-Z”
    1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”
    1.6 Verify the message “Product has been added to your cart” display in  green bar
    1.7 Click on X sign to close the message
    1.8 Click on “Your cart” icon and Click on “View cart” button
    1.9 Verify the text “Your shopping cart - 1 item”
    1.10 Click on “Empty your cart” link
    1.11 Verify the text “Are you sure you want to clear your cart?” on alert
    1.12 Click “Ok” on alert
    1.13 Verify the message “Item(s) deleted from your cart”
    1.15 Verify the text “Your cart is empty”

     */

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);

    }

    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationsPlush() throws InterruptedException {

        verifySaleProductsArrangeAlphabetically();
        Thread.sleep(2000);
        //mouseHoverToElement(By.xpath("//div[@class='product productid-16 product-added']"));

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(5000);
        mouseHoverAndClickElement(By.xpath("(//button[@type='button'])[4]"));
        try {
            Alert alert = driver.switchTo().alert();
            String actualText = alert.getText();
            String expectedText = "Product has been added to your cart";
            alert.accept();
            Thread.sleep(2000);
            Assert.assertEquals("Text does not match", actualText, expectedText);
        } catch (Exception e) {

            verifyText(By.xpath("//li[contains(text(),'Product has been added to your cart')]"), "Product has been added to your cart");
            clickOnElement(By.xpath("//a[@class='close']"));
        }

        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        Thread.sleep(3000);
        verifyPageNavigation(By.xpath("//h1[@id='page-title']"), "Your shopping cart - 1 item");
        Thread.sleep(2000);
        changeQuantityOnElement(By.xpath("//input[contains(@id,'amount')]"), "2");
        Thread.sleep(5000);
        verifyText(By.xpath("//h1[@id='page-title']"), "Your shopping cart - 2 items");
        verifyText(By.xpath("(//li[@class='subtotal'])[1]"), "Subtotal: $29.98");
        Thread.sleep(2000);
        verifyText(By.xpath("(//span[@class='surcharge-cell'])[7]"), "$36.00");
        clickOnElement(By.xpath("//span[contains(text(),'Go to checkout')]"));
        Thread.sleep(5000);
        verifyPageNavigation(By.xpath("//h3[contains(text(),'Log in to your account')]"), "Log in to your account");
        sendTextToElement(By.xpath("//input[@id='email']"), "nids82@yahoo.com");
        clickOnElement(By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']"));
        Thread.sleep(5000);
        verifyPageNavigation(By.xpath("//h1[contains(text(),'Secure Checkout')]"), "Secure Checkout");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Kitten");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Cruz");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-street']"), "45,Cooper Street");
        changeQuantityOnElement(By.xpath("//input[@id='shippingaddress-city']"), "Leicester");

        selectByValueDropDown(By.xpath("//select[@id='shippingaddress-country-code']"), "GB");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "Leicestershire");
        changeQuantityOnElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "20504");

        JavascriptExecutor jsx3 = (JavascriptExecutor) driver;
        jsx3.executeScript("window.scrollBy(0,600)", "");
        Thread.sleep(3000);
        clickOnElement(By.xpath("//input[@id='create_profile']"));
        Thread.sleep(3000);
        sendTextToElement(By.xpath("//input[@id='password']"), "J12345");
        Thread.sleep(3000);
        JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
        jsx1.executeScript("window.scrollBy(0,100)", "");
        Thread.sleep(3000);
        mouseHoverAndClickElement(By.xpath("(//input[contains(@id,'method')])[2]"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("(//input[contains(@id,'pmethod')])[6]"));
        Thread.sleep(3000);
        verifyText(By.xpath("(//span[@class='surcharge-cell'])[6]"), "$37.03");
        clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
        Thread.sleep(5000);
        verifyPageNavigation(By.xpath("//h1[@id='page-title']"), "Thank you for your order");

    }

    @Test

    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {

        verifyUserShouldNavigateToBestsellersPageSuccessfully();
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//div[@class='sort-box']"));
        mouseHoverAndClickElement(By.xpath("//a[contains(text(),'Name A - Z')]"));

        List<WebElement> productName = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']//h5"));

        verifyProductSortedAsPerAlphabaticalOrder("(//ul[@class='products-grid grid-list']//h5)", productName);
        Thread.sleep(3000);
        JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
        jsx1.executeScript("window.scrollBy(0,700)", "");

        clickOnElement(By.xpath("(//span[text()='Add to cart'])[7]"));
        try {
            verifyPageNavigation(By.xpath("//li[contains(text(),'Product has been added to your cart')]"), "Product has been added to your cart");
            clickOnElement(By.xpath("//a[@class='close']"));
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        Thread.sleep(3000);
        verifyPageNavigation(By.xpath("//h1[@id='page-title']"), "Your shopping cart - 1 item");
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart')]"));
        Thread.sleep(3000);
        verifyAndAcceptAlert("Are you sure you want to clear your cart?");
        verifyText(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"), "Item(s) deleted from your cart");
        Thread.sleep(3000);
        verifyText(By.xpath("//h1[@id='page-title']"), "Your cart is empty");
    }

    @After
    public void tearDown() {

        // closeBrowser();
    }
}
