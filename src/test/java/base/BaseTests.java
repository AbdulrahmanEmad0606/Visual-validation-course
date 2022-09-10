package base;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;

public class BaseTests {

    protected static WebDriver driver;
    protected static SearchPage page;
    protected static Eyes eyes;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        initiateEyes();
        driver.manage().window().maximize();
        //String url="file://E:/Testing/Automation Testing/Java/OOP/automated-visual-testing-chapter3/website/index.html";

        driver.get("https://the-internet.herokuapp.com/dynamic_content");
        System.out.println("Window Title : " + driver.getTitle());
        page=new SearchPage(driver);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
//        eyes.abortIfNotClosed();
    }
    private static void initiateEyes(){
        eyes = new Eyes();
        eyes.setApiKey("nl75tQMCVt5tZ7HcGJohzdjuf2yneMFulP101Hwn71Z9E110");
    }
    public void validateWindow(){
        eyes.open(driver, "Automation Bookstore",Thread.currentThread().getStackTrace()[2].getMethodName());
        
        eyes.checkWindow();
        eyes.close();
    }
}