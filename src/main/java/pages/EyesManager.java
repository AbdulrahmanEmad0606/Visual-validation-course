package pages;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EyesManager {
    protected WebDriver driver;
    protected SearchPage page;
    protected final Eyes eyes;
    protected final String appName;

    public EyesManager(WebDriver driver, String appName){
        this.driver = driver;
        this.appName = appName;
        eyes = new Eyes();
        eyes.setApiKey("nl75tQMCVt5tZ7HcGJohzdjuf2yneMFulP101Hwn71Z9E110");
    }
    // to set name of out test suit/batch
    public void setBatchName(String batchName){
        eyes.setBatch(new BatchInfo(batchName));
    }
    public void validateElement(By locator){
        eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkElement(locator);
        eyes.close();
    }
    public void validateWindow(){
        eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();
    }
    public void validateFrame(String locator){
        eyes.open(driver, appName, Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkFrame(locator);
        eyes.close();
    }
}
