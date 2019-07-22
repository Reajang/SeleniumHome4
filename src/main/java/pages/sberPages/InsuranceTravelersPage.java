package pages.sberPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class InsuranceTravelersPage extends BasePage {


    @FindBy(xpath = "//div[contains(text(), 'Минимальная')]/..")
    private WebElement buttonMin;
    @FindBy(xpath = "//span[contains(text(), 'Оформить')]/../..")
    private WebElement issue;

    public void clickButtonBin() {
        elemClick(buttonMin);
    }

    public void clickIssue() {
        elemClick(issue);
    }

}
