package base;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EyesManager;
import pages.SearchPage;

public class BaseTests {

    protected static WebDriver driver;
    protected static SearchPage page;
    protected static Eyes eyes;
    protected static EyesManager eyesManager;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        eyesManager=new EyesManager(driver,"The internet");
        driver.manage().window().maximize();
        String urlBookStore="file://E:/Testing/Automation Testing/Java/OOP/automated-visual-testing-chapter3/website/index.html";
         String urlInternet="https://the-internet.herokuapp.com/tables";
        driver.get(urlInternet);
        System.out.println("Window Title : " + driver.getTitle());
        page=new SearchPage(driver);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
//        eyes.abortIfNotClosed();
    }

}