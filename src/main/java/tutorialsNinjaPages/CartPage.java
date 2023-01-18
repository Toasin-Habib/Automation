package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private By quantity = By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]");

    private By TotalValue = By.xpath("//tbody/tr[1]/td[6]");
    private By myAccount = By.xpath("//a[@title='My Account']");
    private By logout = By.xpath("//a[contains(text(),'Logout')]");

    private By logoutMsg = By.xpath("//h1[contains(text(),'Account Logout')]");

    String expectedTotal , expectedQty;
    public CartPage(WebDriver driver,String expectedQty,String expectedTotal ){
        this.driver = driver;

        this.expectedQty=expectedQty;
        this.expectedTotal=expectedTotal;
    }

    public void VerifyQuantity(){
      //  String expectedQty = "5";
        String actualQty = driver.findElement(quantity).getAttribute("value");
        boolean boo = expectedQty.equalsIgnoreCase(actualQty);
        if (boo) {
            System.out.println("Quantity is correct");
        }
        else {
            System.out.println("Quantity is wrong");
        }
    }

    public  void VerifyTotalValue(){
       // String expectedQty = "$3,010.00";
        //String actualTotal = driver.findElement(TotalValue).getText().trim().replaceAll("$","");
       String actualTotal =driver.findElement(TotalValue).getText().trim().replace("$", "").replace(",", "").replace(".00","");
        boolean boo = expectedTotal.equalsIgnoreCase(actualTotal);
        if (boo) {
            System.out.println("Total value is correct");
        }
        else {
            System.out.println("Total value is wrong");
        }
    }

    public void ClickOnMyAcc(){
        driver.findElement(myAccount).click();
        System.out.println("My account has been clicked");
    }
    public void ClickOnLogout(){
        driver.findElement(logout).click();

        System.out.println("Logout has been clicked");
    }

    public void verifyLogoutMsg() {
        String expectedMsg = "Account Logout";
        String actualMsg = driver.findElement(logoutMsg).getText();
        boolean boo = expectedMsg.equalsIgnoreCase(actualMsg);
        if (boo) {
            System.out.println("Correct Logout message is visible");
        }
        else {
            System.out.println("Logout message is not visible");
        }
    }
}
