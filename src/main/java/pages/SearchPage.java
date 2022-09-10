package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SearchPage {
    private final WebDriver driver;
    private final By searchBar = By.id("searchBar");
    private final By visibleBooks =
            By.xpath("//li[not(contains(@class, 'ui-screen-hidden'))]");
    private final By hiddenBooks =
            By.xpath("//li[contains(@class, 'ui-screen-hidden')]");
    private final By  titleAttribute=By.id("pid1_title");
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void search(String text) {
        search(text, true);
    }

    public void search(String text, boolean waitForHidden) {
        clearSearch();
        driver.findElement(searchBar).sendKeys(text);

        if(waitForHidden) {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(presenceOfElementLocated(hiddenBooks));
        }
    }

    public void clearSearch() {
        driver.findElement(searchBar).clear();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(numberOfElementsToBe(hiddenBooks, 0));
    }

    public int getNumberOfVisibleBooks() {
        return findVisibleBooks().size();
    }
    public boolean isBookVisible(String title){
        List<WebElement> books = findVisibleBooks();

        for(WebElement book : books) {
            if(title.equalsIgnoreCase(book.findElement(titleAttribute).getText())){
                return true;
            }
        }

        return false;
    }
    private List<WebElement> findVisibleBooks(){
        return driver.findElements(visibleBooks);
    }
    public void sortLastNameColumn(){
        driver.findElement(By.xpath("//*[@id=\"table1\"]/thead/tr/th[1]/span")).click();
    }
    public void sortFirstNameColumn(){
        driver.findElement(By.xpath("//*[@id=\"table1\"]/thead/tr/th[2]/span")).click();
    }
    public void sortEmailColumn(){
        driver.findElement(By.xpath("//*[@id=\"table1\"]/thead/tr/th[3]/span")).click();
    }
    public void sortDueColumn(){
        driver.findElement(By.xpath(" //*[@id=\"table1\"]/thead/tr/th[4]/span")).click();
    }
    public void sortWebSiteColumn(){
        driver.findElement(By.xpath(" //*[@id=\"table1\"]/thead/tr/th[5]/span")).click();
    }
}