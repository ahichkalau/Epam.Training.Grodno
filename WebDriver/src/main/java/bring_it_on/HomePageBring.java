package bring_it_on;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageBring {
    private static final String HOME_PAGE = "https://pastebin.com";
    private WebDriver driver;

    @FindBy(className = "paste_textarea")
    WebElement codeTextArea;

    @FindBy(name = "paste_format")
    WebElement syntaxHighlighting;

    @FindBy(name = "paste_expire_date")
    WebElement expireDate;

    @FindBy(name = "paste_name")
    WebElement pasteName;

    @FindBy(name = "submit")
    WebElement submitButton;

    public HomePageBring(WebDriver driver){
        this.driver = driver;
       PageFactory.initElements(driver, this);
    }

    public HomePageBring openPage(){
        driver.get(HOME_PAGE);
        new WebDriverWait(driver, 5);
        return this;
    }

    public HomePageBring writeCode(String code){
        codeTextArea.sendKeys(code);
        return this;
    }

    public HomePageBring selectSyntax(String syntax){
        new Select(syntaxHighlighting).selectByVisibleText(syntax);
        return this;
    }

    public HomePageBring selectTime(String time){
        new Select(expireDate).selectByVisibleText(time);
        return this;
    }

    public HomePageBring writePasteName(String name){
        pasteName.sendKeys(name);
        return this;
    }

    public ResultPage submitCode(){
        submitButton.click();
        return new ResultPage(driver);
    }

}
