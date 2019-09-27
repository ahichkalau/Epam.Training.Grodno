import hardcore.CloudGoogleHomePage;
import hardcore.PricingCalculatorPage;
import hardcore.TenMinuteEMailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HardcoreTest {
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test()
    public void openPage(){
        PricingCalculatorPage cloudGoogleHomePage = new CloudGoogleHomePage(driver)
                .openHomePage()
                .enterASearchQueryAndGetResult("Google Cloud Platform Pricing Calculator")
                .clickOnFirstLinkInSearchResult()
                .inputNumberOfInstance(4)
                .chooseOperationSystem("Free")
                .chooseMachineClass("Regular")
                .inputMachineType("n1-standard-8")
                .addGPU(1, "V100")
                .selectSSD(2)
                .selectDataCenterLocation("Frank")
                .selectCommittedUsage(1)
                .addToEstimate()
                .emailEstimate()
                .createNewTab()
                .switchTab()
                ;

        TenMinuteEMailPage tenMinuteEMailPage = new TenMinuteEMailPage(driver)
                .openPage()
                .copyEMailAdress()
                .switchTab()
                ;

        cloudGoogleHomePage
                .sendEmail()
                .switchTab()
        ;

        tenMinuteEMailPage
                .openMessage()
                .getEstimatedMonthlyCostInEmail()
                .switchTab()
        ;

        cloudGoogleHomePage
                .getEstimatedCost()
        ;
    }

     @Test(dependsOnMethods = "openPage")
     public void checkCost(){
        Assert.assertEquals(PricingCalculatorPage.estimatedMonthlyCostInCalculator, TenMinuteEMailPage.estimatedMonthlyCostInEMail);

     }

    @AfterClass(alwaysRun = true)
    public void closeBrowser(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        driver = null;
    }
}

