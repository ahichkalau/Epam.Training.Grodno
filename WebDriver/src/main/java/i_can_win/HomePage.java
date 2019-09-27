package i_can_win;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private WebDriver driver;

    @FindBy(id = "paste_code")
    private WebElement pasteCode;

    @FindBy(xpath = "//span[@class='select2-selection__rendered' and @title='Never']")
    private WebElement timeExpirations;

    @FindBy(xpath = "//select[@name='paste_expire_date']")
    private WebElement timeExpirationsTenMinutes;

    @FindBy(name = "paste_name")
    private WebElement nameOfPaste;

    @FindBy(name= "submit")
    private WebElement submitTask;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10);
        return this;
    }

    public HomePage writeCode(String code){
        pasteCode.sendKeys(code);
        return this;
    }

    public HomePage setTime(){
        Select selectElement = new Select(timeExpirationsTenMinutes);
        selectElement.selectByVisibleText("10 Minutes");
        return this;
    }

    public HomePage pasteName(String name){
        nameOfPaste.sendKeys(name);
        return this;
    }

    public HomePage createPaste(){
        submitTask.click();
        return this;
    }

}
