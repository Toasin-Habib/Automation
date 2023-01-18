package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.ExcelReader;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import tutorialsNinjaPages.*;

import java.io.IOException;


public class Main {

    static  WebDriver driver;
    static HomePage objthomepage;

    static RegisterPage objtregisterpage;

    static RegisterSuccessPage objregsuccesspage;

    static AccountPage objaccpage;

    static YourStorePage objstorepage;

    static ProductPage objproductpage;

    static CartPage objcartpage;

    public static void browsername(String drivername){
        if (drivername.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        } else if (drivername.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (drivername.equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else{
            System.out.println("Invalid browser name");
        }
        if (driver != null) {
            driver.get("http://tutorialsninja.com/demo/");
            driver.manage().window().maximize();

        } else {
            System.out.println("Failed to load browser");
        }



    }
    public static void main(String[] args) throws IOException {

         String[] browsers = {"chrome"};

        for (String browser : browsers) {
            browsername(browser);
            objthomepage = new HomePage(driver);
            objthomepage.clickonMyacc();
            objthomepage.clickonRegister();

            String fname="Md Toasin",lname="Habib",tphone="11111111",pass="010101010",conpass="010101010",email="a447@gmail.com";
            objtregisterpage = new RegisterPage(driver,fname,lname,email,tphone,pass,conpass);
            objtregisterpage.VerifyRegaccText();
            objtregisterpage.FirstNameField();
            objtregisterpage.LastNameField();
            objtregisterpage.EmailField();
            objtregisterpage.TelephoneField();
            objtregisterpage.Passwordfield();
            objtregisterpage.PassConfirmField();
            objtregisterpage.NewsletterSubscribe();
            objtregisterpage.PrivacyPolicy();
            objtregisterpage.ContinueBtn();
            objregsuccesspage = new RegisterSuccessPage(driver);
            objregsuccesspage.verifyRegSuccessText();
            objregsuccesspage.ClickOnContinueBtn();

            String value = "Price (High > Low)";
            objaccpage = new AccountPage(driver,value);
            objaccpage.VerifyMyAccText();
            objaccpage.hoverOnDesktop();
            objaccpage.SelectFromDropdown();
            objaccpage.ClickOnFirstitem();

            String quantity ="5" ;
            objproductpage = new ProductPage(driver,quantity);
            objproductpage.modifiedQty();
            objproductpage.ClickOnAddtoCart();
            objproductpage.clickOnCartButton();
            objproductpage.clickOnViewCart();
            int subtotal=5 *1000,vat =1000,tax=10, expectedTotal = subtotal+vat+tax;
            String expectedQty = "5",total=Integer.toString(expectedTotal);

            objcartpage = new CartPage(driver,expectedQty,total );
            objcartpage.VerifyQuantity();
            objcartpage.VerifyTotalValue();
            objcartpage.ClickOnMyAcc();
            objcartpage.ClickOnLogout();
            objcartpage.verifyLogoutMsg();

            driver.quit();

        }
    }
}