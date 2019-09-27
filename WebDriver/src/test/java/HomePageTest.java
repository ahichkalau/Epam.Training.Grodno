import i_can_win.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePageTest {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void testHomePage(){
        HomePage homePage = new HomePage(driver)
                .openPage()
                .writeCode("Hello from WebDriver")
                .setTime()
                .pasteName("helloweb")
                .createPaste();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws InterruptedException{
        Thread.sleep(10000);
        driver.quit();
        driver = null;
    }
}
