import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TheinternetTests extends BaseTests {
    @BeforeMethod
    public static void startVisualTestSuit(){
        eyesManager.setBatchName("Sort Table");
    }
    @Test
    public void TestSortByLastName(){
        page.sortLastNameColumn();
        eyesManager.validateElement(By.id("table1"));
    }
    @Test
    public void TestSortByFirstName(){
        page.sortFirstNameColumn();
        eyesManager.validateElement(By.id("table1"));
    }
    @Test
    public void TestSortByEmail(){
        page.sortEmailColumn();
        eyesManager.validateElement(By.id("table1"));
    }
    @Test
    public void TestSortByDue(){
        page.sortDueColumn();
        eyesManager.validateElement(By.id("table1"));
    }
    @Test
    public void TestSortByWebSite(){
        page.sortWebSiteColumn();
        eyesManager.validateElement(By.id("table1"));
    }
}
