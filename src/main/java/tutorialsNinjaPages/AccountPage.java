package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AccountPage {
    private WebDriver driver;
    private By MyaccText = By.xpath("//h2[contains(text(),'My Account')]");

    private By MyOrderText = By.xpath("//h2[contains(text(),'My Orders')]");

    private By MyAffAcc = By.xpath("//h2[contains(text(),'My Affiliate Account')]");

    private By Newssettler = By.xpath("//h2[contains(text(),'Newsletter')]");

    private By YourStoreText = By.xpath("//a[contains(text(),'Your Store')]");

    private By Desktop = By.xpath("//a[normalize-space()='Desktops']");
    private By Showdesktop = By.xpath("//a[normalize-space()='Show All Desktops']");

    private By dropdown = By.xpath("//select[@id='input-sort']");
    private By firstItem = By.cssSelector("div[id='content'] div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) h4:nth-child(1) a:nth-child(1)");
   String value;
    public AccountPage(WebDriver driver,String value){
        this.driver=driver;
        this.value = value;
    }
    public void VerifyMyAccText(){
        String expectedText= "My Account";
        String trueText = driver.findElement(MyaccText).getText();
        if(expectedText.equalsIgnoreCase(trueText)){
            System.out.println("Correct text is visible");
        }else{
            System.out.println("Wrong text is visible");
        }
    }
    public void hoverOnDesktop(){
        Actions action = new Actions(driver);
        WebElement elem = driver.findElement(Desktop);
        action.moveToElement(elem);
        action.perform();
        driver.findElement(Showdesktop).click();
    }
    public void SelectFromDropdown(){
        driver.findElement(dropdown).click();
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(value);
        driver.findElement(dropdown).click();

    }
    public void ClickOnFirstitem(){

        driver.findElement(firstItem).click();
        System.out.println("First Item has been clicked");
    }
    public boolean verifyFirstItemHasLowestPrice(){
        List<WebElement> products = driver.findElements(By.cssSelector(".product-layout"));
        int lowestPrice;
        try {
            lowestPrice = Integer.parseInt(products.get(0).findElement(By.cssSelector("p.price > span.price-new")).getText().trim().replaceAll("$", ""));
        } catch (Exception e) {
            lowestPrice = Integer.parseInt(products.get(0).findElement(By.cssSelector("p.price")).getText().trim().replaceAll("$", ""));
        }
        for (int i = 1; i < products.size() ; i++) {
            int comparisonPrice;
            try {
                comparisonPrice = Integer.parseInt(products.get(i).findElement(By.cssSelector("p.price > span.price-new")).getText().trim().replaceAll("$", ""));
            } catch (Exception e) {
                comparisonPrice = Integer.parseInt(products.get(i).findElement(By.cssSelector("p.price")).getText().trim().replaceAll("$", ""));
            }
            if(comparisonPrice < lowestPrice ){
                return false;

            }
        }
        return true;
    }
    public void low(){
        if(verifyFirstItemHasLowestPrice()==true){
            System.out.println("It is a lowest item");
        }
       else{
            System.out.println("It is not lowest item");
        }
    }
}
