import bring_it_on.HomePageBring;
import bring_it_on.ResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BringItOnTest {

    WebDriver driver;
    String codeForSubmit;
    String pasteName = "how to gain dominance among developers";


    @BeforeClass(alwaysRun = true)
    public void openBrowser(){
        driver = new ChromeDriver();
    }


    @Test
    public void testOpenPageAndPasteCode(){
        codeForSubmit = (
                "git config --global user.name" + "\"New Sheriff in Town\"\n"
                + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                + "git push origin master --force");
        ResultPage resultPage = new HomePageBring(driver)
                .openPage()
                .writeCode(codeForSubmit)
                .selectSyntax("Bash")
                .selectTime("10 Minutes")
                .writePasteName(pasteName)
                .submitCode();
    }

    @Test
    public void verificationTitleName(){
        Assert.assertTrue(driver.getTitle().contains(pasteName),
                "Tittle name not correct for example  Paste Name / Title");
    }

    @Test
    public void verificationTextInFrame(){
        WebElement bashFrame = driver.findElement(By.xpath("//ol[@class='bash']"));
        Assert.assertTrue(bashFrame.getText().equals(codeForSubmit),
                "The text in the code window does not match the entered");
    }

    @Test
    public void verificationSyntaxHighlighting(){
        WebElement bashFrame = driver.findElement(By.xpath("//ol[@class='bash']"));
        Assert.assertFalse(bashFrame.findElements(By.className("kw2")).isEmpty() |
                bashFrame.findElements(By.className("st0")).isEmpty(),
                "The Bash syntax is not highlighted");
    }



    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){

        }
        driver.quit();
        driver = null;
    }
}
