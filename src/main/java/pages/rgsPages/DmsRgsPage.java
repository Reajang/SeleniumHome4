package pages.rgsPages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class DmsRgsPage extends BasePage {

    @FindBy(xpath = "//*[@class='clearfix']//following-sibling::h1")
    private WebElement dmsTitle;
    @FindBy(xpath = "//*[@class='rgs-context-bar-content-call-to-action-buttons']/a[3]")
    private WebElement sendRequest;

    public WebElement getDmsTitle(){
        return dmsTitle;
    }

    public void clickSendRequest(){
        elemClick(sendRequest);
    }

    public void checkTitle(){
        assertData("ДМС —"  +" добровольное медицинское страхование", getDmsTitle());
    }

}
