package pages;

//import io.qameta.allure.Attachment;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void elemClick(WebElement element) {
        DriverManager.waitElem(element).click();
    }

    public void fillText(WebElement element, String text) {

        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).click().perform();
        element.sendKeys(text);
    }

    //@Attachment(value = "скриншот", type = "image/png")
    public byte[] takescreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public void assertData(List<String> expextedData, List<WebElement> actualElements) {
        if (expextedData.size() != actualElements.size()) return;
        if (expextedData.isEmpty() || actualElements.isEmpty()) return;
        for (int i = 0; i < expextedData.size(); i++) {
            Assert.assertEquals(expextedData.get(i), actualElements.get(i).getAttribute("value"));
        }
    }
    public void fillFields(List<String> text, List<WebElement> elemensts) {
        if (text.size() != elemensts.size()) return;
        if (text.isEmpty() || elemensts.isEmpty()) return;
        for (int i = 0; i < text.size(); i++) {
            fillText(elemensts.get(i), text.get(i));
        }
    }

    public void assertData(String expect, WebElement element) {
        Assert.assertEquals(expect, DriverManager.waitElem(element).getText());
    }

    public void fillSelect(List<WebElement> elementList, int value) {
        elemClick(elementList.get(value));
    }


}
