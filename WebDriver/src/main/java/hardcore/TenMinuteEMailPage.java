package hardcore;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;


public class TenMinuteEMailPage {
    public static final String TEN_MINUTE_EMAIL = "https://10minutemail.com/";
    static String eMailAdress;
    public static Double estimatedMonthlyCostInEMail;
    WebDriver driver;

    @FindBy(xpath = "//input[@id='mailAddress']")
    WebElement mailAdress;

    @FindBy(xpath = "//div[@id='messagesList']//span[contains(text(),'Google')]")
    WebElement messageFromGoogleCloud;

    @FindBy(xpath = "//h2[contains(text(),'Estimated')]")
    WebElement estimatedMonthlyCost;

    public TenMinuteEMailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TenMinuteEMailPage openPage(){
        driver.get(TEN_MINUTE_EMAIL);
        new WebDriverWait(driver, 10);
        return this;
    }

    public TenMinuteEMailPage copyEMailAdress(){
        eMailAdress = mailAdress.getAttribute("value");
        return this;
    }

    public TenMinuteEMailPage switchTab(){
        driver.switchTo().window(PricingCalculatorPage.tabs.get(0));
        return this;
    }

    public TenMinuteEMailPage openMessage(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        new WebDriverWait(driver, 90).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//div[@id='messagesList']//span[contains(text(),'Google')]")));
        messageFromGoogleCloud.click();
        return this;
    }

    public TenMinuteEMailPage getEstimatedMonthlyCostInEmail(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .textMatches(By.xpath("//h2[contains(text(),'Estimated')]"),Pattern.compile("USD")));
        String string = estimatedMonthlyCost
                .getText()
                .replaceAll("[^0-9.]", "");
        estimatedMonthlyCostInEMail = Double.parseDouble(string);
        return this;
    }

}
