package tutorialsNinjaPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterSuccessPage {
    private WebDriver driver;

    private By RegSuccessText = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");

    private By ContinueBtn = By.xpath("//a[contains(text(),'Continue')]");


    public RegisterSuccessPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyRegSuccessText(){
        String expectedText= "Your Account Has Been Created!";
        String trueText = driver.findElement(RegSuccessText).getText();
        if(expectedText.equalsIgnoreCase(trueText)){
            System.out.println("Correct text is visible");
        }else{
            System.out.println("Wrong text is visible");
        }
    }
    public void ClickOnContinueBtn(){
        driver.findElement(ContinueBtn).click();
        System.out.println("Continue button has been clicked");
    }
}
