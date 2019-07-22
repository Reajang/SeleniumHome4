package pages.sberPages;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[@name='insured0_surname']")
    private WebElement ownerSurname;
    @FindBy(xpath = "//input[@name='insured0_name']")
    private WebElement ownerName;
    @FindBy(xpath = "//input[@name='insured0_birthDate']")
    private WebElement ownerBday;
    @FindBy(xpath = "//input[@name='surname']")
    private WebElement targerSurname;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement targerName;
    @FindBy(xpath = "//input[@name='middlename']")
    private WebElement targerMiddleName;
    @FindBy(xpath = "//input[@name='birthDate']")
    private WebElement targerBday;
    @FindBy(xpath = "//input[@name='male']")
    private WebElement targerSexMale;
    @FindBy(xpath = "//input[@placeholder='Серия']")
    private WebElement targerPaspSer;
    @FindBy(xpath = "//input[@placeholder='Номер']")
    private WebElement targerPaspNum;
    @FindBy(xpath = "//input[@name='issueDate']")
    private WebElement targetPaspDay;
    @FindBy(xpath = "//*[@ng-click='save()']")
    private WebElement continueButton;
    @FindBy(xpath = "//div[@ng-show='tryNext && myForm.$invalid']")
    private WebElement errorMessage;

    public List<String> getTextToInputs(){
        return  Arrays.asList("Ivan", "Ivanov", "16.05.1994", "Шультц", "Андрей", "Петрович", "28.09.1999", "1234", "567890", "12.10.2013");
    }

    public List<WebElement> getNesesseryElements(){
        List<WebElement> list = new ArrayList<>();
        list.add(ownerSurname);
        list.add(ownerName);
        list.add(ownerBday);
        list.add(targerSurname);
        list.add(targerName);
        list.add(targerMiddleName);
        list.add(targerBday);
        list.add(targerPaspSer);
        list.add(targerPaspNum);
        list.add(targetPaspDay);
        return list;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public void clickContinueButton(){
        elemClick(getContinueButton());
    }

    public WebElement getOwnerSurname() {
        return ownerSurname;
    }

    public WebElement getOwnerName() {
        return ownerName;
    }

    public WebElement getOwnerBday() {
        return ownerBday;
    }

    public WebElement getTargerSurname() {
        return targerSurname;
    }

    public WebElement getTargerName() {
        return targerName;
    }

    public WebElement getTargerMiddleName() {
        return targerMiddleName;
    }

    public WebElement getTargerBday() {
        return targerBday;
    }

    public WebElement getTargerSexMale() {
        return targerSexMale;
    }

    public WebElement getTargerPaspSer() {
        return targerPaspSer;
    }

    public WebElement getTargerPaspNum() {
        return targerPaspNum;
    }

    public WebElement getTargetPaspDay() {
        return targetPaspDay;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
    public void assertErrorMessage(){
        Assert.assertEquals("\nНет сообщения","Заполнены не все обязательные поля", getErrorMessage().getText());
    }
}





