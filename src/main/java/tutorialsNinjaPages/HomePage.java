package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private By myaccount = By.xpath("//a[@title='My Account']");
    private By register = By.xpath("//a[contains(text(),'Register')]");


    public HomePage(WebDriver driver){
        this.driver = driver;

    }
    public void clickonMyacc(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(myaccount));
        driver.findElement(myaccount).click();
        System.out.println("My acc is clicked");
    }

    public void clickonRegister(){

        driver.findElement(register).click();
        System.out.println("Registered is clicked");
    }
}
