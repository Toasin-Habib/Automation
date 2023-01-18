package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;
    private By QtyField = By.xpath("//input[@id='input-quantity']");
    private By AddtoCartBtn = By.xpath("//button[@id='button-cart']");

    private By cartBtn = By.xpath("//div[@id='cart']");
    private By viewCart = By.xpath("//strong[contains(text(),'View Cart')]");
//    private By successmsg = By.xpath("//body/div[@id='product-product']/div[1]");
    private By successmsg = By.xpath("div[class='alert alert-success alert-dismissible'] a:nth-child(2)");
    private By macbook = By.xpath("//a[contains(text(),'MacBook')]");
    private By shooping = By.xpath("//a[contains(text(),'shopping cart')]");
    String quantity;
    public ProductPage(WebDriver driver,String quantity){
        this.driver = driver;
        this.quantity= quantity;
    }
    public void modifiedQty(){
        WebElement qty =driver.findElement(QtyField);
        qty.clear();
        qty.sendKeys(quantity);
        System.out.println("Quantity has been modified");

    }
    public void ClickOnAddtoCart(){
        driver.findElement(AddtoCartBtn).click();
        System.out.println("Add to cart button has been clicked");
    }


    public void Verfysucessmsg(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successmsg));
//        String mac = driver.findElement(macbook).getText();
//        String shop = driver.findElement(shooping).getText();
//        StringBuilder builder = new StringBuilder();
//        builder.append("Success: You have added ").append(mac).append(" to your ").append(shop);
//        String actual = builder.toString();

        String expected = "Success: You have added MacBook to your shopping cart!";
        String actual = driver.findElement(successmsg).getText();
        boolean bool = expected.equalsIgnoreCase(actual);
        if (bool) {
            System.out.println("success massge is visible");
        }
        else {
            System.out.println("success massge is not visible");
        }
    }

    public void clickOnCartButton() {
        driver.findElement(cartBtn).click();
        System.out.println("Cart button has been clicked");

    }
    public void clickOnViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart));
        driver.findElement(viewCart).click();
        System.out.println("View cart has been clicked");

    }
}
