package CucumberSteps;

import cucumber.api.java.ru.Допустим;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DriverManager;
import pages.rgsPages.DmsRequestPage;
import pages.rgsPages.DmsRgsPage;
import pages.rgsPages.MainRgsPage;
import pages.sberPages.InsuranceTravelersPage;
import pages.sberPages.RegistrationPage;
import pages.sberPages.SberPersonPage;

import java.util.List;
import java.util.Map;

public class Steps {

    /*static MainRgsPage mainRgsPage = new MainRgsPage();
    static DmsRgsPage dmsRgsPage = new DmsRgsPage();
    static DmsRequestPage dmsRequestPage = new DmsRequestPage();*/

    @Допустим("Перейти по ссылке {string}")
    public void openRsgUrl(String rsgUrl){
        DriverManager.initialDriver(rsgUrl);
    }
    @Допустим("Выбрать пункт меню - страхование")
    public void insuranceRsg(){
        MainRgsPage mainRgsPage = new MainRgsPage();
        mainRgsPage.clickInsurance();
    }

    @Допустим("Выбрать категорию - ДМС")
    public void dms(){
        MainRgsPage mainRgsPage = new MainRgsPage();
        mainRgsPage.clickDms();
    }

    @Допустим("Проверить наличие заголовка - {string}")
    public void checkDmsTitle(String string){
        DmsRgsPage dmsRgsPage = new DmsRgsPage();
        dmsRgsPage.checkTitle(string);
    }

    @Допустим("Нажать на кнопку - Отправить заявку")
    public void clickSendRequest(){
        DmsRgsPage dmsRgsPage = new DmsRgsPage();
        dmsRgsPage.clickSendRequest();
        }

    @Допустим("Проверить, что открылась страница , на которой присутствует текст - {string}")
    public void checkDmsRequest(String string){
        DmsRequestPage dmsRequestPage = new DmsRequestPage();
        dmsRequestPage.checkFormTitle(string);
    }
    @Допустим("Заполнение полей")
    public void fillFields(List<String> textToInput){
        DmsRequestPage dmsRequestPage = new DmsRequestPage();
        List<WebElement> necessaryFields = dmsRequestPage.getNesesseryElements();
        dmsRequestPage.fillFields(textToInput, necessaryFields);
        dmsRequestPage.fillSelect(dmsRequestPage.getRegions(), 1);
        dmsRequestPage.clickAgree();
    }
    @Допустим("Проверить, что все поля заполнены введенными значениями")
    public void checkFieldsRsg(List<String> textToCheck){
        DmsRequestPage dmsRequestPage = new DmsRequestPage();
        List<WebElement> necessaryFields = dmsRequestPage.getNesesseryElements();
        Assert.assertEquals("77", dmsRequestPage.getRegions().get(1).getAttribute("value"));
        dmsRequestPage.assertData(textToCheck, necessaryFields);
    }

    @Допустим("Нажать Отправить")
    public void send(){
        DmsRequestPage dmsRequestPage = new DmsRequestPage();
        dmsRequestPage.clickSendButton();
    }

    @Допустим("Проверить, что у поля Эл. почта присутствует сообщение об ошибке")
    public void emailError(){
        DmsRequestPage dmsRequestPage = new DmsRequestPage();
        dmsRequestPage.checkEmailError();
        dmsRequestPage.fillEmail("trainee@aplana.ru");
    }

    //==========================

    @Допустим("Перейти на страницу {string}")
    public void setUrl(String sberUrl){
        DriverManager.initialDriver(sberUrl);
    }
    @Допустим("Нажать на – Страхование")
    public void insuranceSber(){
        SberPersonPage sberPersonPage = new SberPersonPage();
        sberPersonPage.clickMainPage();
    }
    @Допустим("Выбрать – Путешествие и покупки")
    public void travel(){
        SberPersonPage sberPersonPage = new SberPersonPage();
        sberPersonPage.clickTravel();
    }
    @Допустим("Проверить наличие на странице заголовка – {string}")
    public void checkTravelTitle(String string){
        SberPersonPage sberPersonPage = new SberPersonPage();
        sberPersonPage.checkTitle(string);
    }
    @Допустим("Нажать на – Оформить Онлайн")
    public void clickOnline(){
        SberPersonPage sberPersonPage = new SberPersonPage();
        DriverManager.changePageByClickWebElement(sberPersonPage.getMakeOnline());
    }
    @Допустим("На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная")
    public void clickMin(){
        InsuranceTravelersPage insuranceTravelersPage = new InsuranceTravelersPage();
        insuranceTravelersPage.clickButtonBin();
    }
    @Допустим("Нажать Оформить")
    public void issuing(){
        InsuranceTravelersPage insuranceTravelersPage = new InsuranceTravelersPage();
        insuranceTravelersPage.clickIssue();
    }
    @Допустим("На вкладке Оформить заполнить поля:")
    public void fill(List<String> textToInput){
        RegistrationPage registrationPage = new RegistrationPage();
        List<WebElement> necessaryFields = registrationPage.getNesesseryElements();
        registrationPage.fillFields(textToInput, necessaryFields);
    }
    @Допустим("Проверить, что все поля заполнены правильно")
    public void checkFieldsSber(List<String> textToCheck){
        RegistrationPage registrationPage = new RegistrationPage();
        List<WebElement> necessaryFields = registrationPage.getNesesseryElements();
        registrationPage.assertData(textToCheck, necessaryFields);
    }
    @Допустим("Нажать продолжить")
    public void continueButton(){
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickContinueButton();
    }
    @Допустим("Проверить, что появилось сообщение - {string}")
    public void checkErrorMessage(String string){
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.assertErrorMessage(string);
        DriverManager.closePages();
        DriverManager.getDriver().quit();
    }
}
