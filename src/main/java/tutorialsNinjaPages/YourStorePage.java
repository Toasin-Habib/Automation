package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourStorePage {

    private WebDriver driver;
    private By FirstItem = By.xpath("//a[contains(text(),'MacBook')]");
    public YourStorePage(WebDriver driver){
        this.driver=driver;
    }

    public void ClickOnFirstItemPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(FirstItem);
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(FirstItem).click();
        System.out.println("First Item has been clicked");
    }
}
