package hardcore;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class PricingCalculatorPage extends hurtmeplenty.PricingCalculatorPage {
    public static Double estimatedMonthlyCostInCalculator;
    public static ArrayList<String> tabs;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    WebElement eMailEstimateButton;

    @FindBy(xpath = "//input[@type='email']")
    WebElement eMailInEstimate;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement sendEmailButton;

    @FindBy(xpath = "//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]")
    WebElement totalEstimatedCostInCalculator;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage createNewTab(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
        return this;
    }

    public PricingCalculatorPage switchTab(){
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public PricingCalculatorPage emailEstimate(){
        webElementWaitToBeClickableAndClick(eMailEstimateButton);
        return this;
    }

    public PricingCalculatorPage sendEmail(){
        driver.switchTo().frame("idIframe");
        eMailInEstimate.sendKeys(TenMinuteEMailPage.eMailAdress);
        webElementWaitToBeClickableAndClick(sendEmailButton);
        return this;
    }

    public PricingCalculatorPage getEstimatedCost(){
        driver.switchTo().frame("idIframe");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .textMatches(By.xpath("//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]"), Pattern.compile("USD")));
        String string = totalEstimatedCostInCalculator
                .getText()
                .replace("1 month","")
                .replaceAll("[^0-9.]", "");
        estimatedMonthlyCostInCalculator = Double.parseDouble(string);
        return this;
    }
}
