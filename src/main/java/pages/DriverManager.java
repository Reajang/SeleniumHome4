package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract class DriverManager {

    private static WebDriver driver;
    private static WebDriverWait waiter;


    public static void initialDriver(String url){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        getDriver().get(url);
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver(){
        if(driver == null) driver = new ChromeDriver();
        return driver;
    }

    public static WebDriverWait getWaiter() {
        if(waiter == null) waiter = new WebDriverWait(getDriver(), 5, 100);
        return waiter;
    }
    public static WebElement waitElem(WebElement element){
        return getWaiter().until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void changePageByClickWebElement(WebElement element){
        Set<String> oldHandlers = getDriver().getWindowHandles();
        element.click();
        Set<String> newHendlers = getDriver().getWindowHandles();
        newHendlers.removeAll(oldHandlers);
        getDriver().switchTo().window(newHendlers.iterator().next());
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    public static void closePages(){
        for(String windowHandler : getDriver().getWindowHandles())
            getDriver().switchTo().window(windowHandler).close();
    }
}
