package pages.rgsPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MainRgsPage extends BasePage {
    @FindBy(xpath = "//*[contains(text(), 'Страхование')]")
    private WebElement insurance;
    @FindBy(xpath = "//*[contains(text(), 'ДМС')]")
    private WebElement dms;

    public void clickInsurance(){
        elemClick(insurance);
    }

    public void clickDms(){
        elemClick(dms);
    }

}
