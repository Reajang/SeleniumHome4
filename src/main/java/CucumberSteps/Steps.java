package CucumberSteps;

import cucumber.api.java.ru.Допустим;
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

public class Steps {

    /*static MainRgsPage mainRgsPage = new MainRgsPage();
    static DmsRgsPage dmsRgsPage = new DmsRgsPage();
    static DmsRequestPage dmsRequestPage = new DmsRequestPage();*/

    @Допустим("Перейти по ссылке http://www.rgs.ru")
    public void openRsgUrl(){
        DriverManager.initialDriver("https://www.rgs.ru");
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

    @Допустим("Проверить наличие заголовка - Добровольное медицинское страхование")
    public void checkDmsTitle(){
        DmsRgsPage dmsRgsPage = new DmsRgsPage();
        dmsRgsPage.checkTitle();
    }

    @Допустим("Нажать на кнопку -Отправить заявку")
    public void clickSendRequest(){
        DmsRgsPage dmsRgsPage = new DmsRgsPage();
        dmsRgsPage.clickSendRequest();
        }

    @Допустим("Проверить, что открылась страница , на которой присутствует текст -Заявка на добровольное медицинское страхование")
    public void checkDmsRequest(){
        DmsRequestPage dmsRequestPage = new DmsRequestPage();
        dmsRequestPage.checkFormTitle();
    }
    @Допустим("Заполнение полей")
    public void fillFields(){
        DmsRequestPage dmsRequestPage = new DmsRequestPage();
        List<WebElement> necessaryFields = dmsRequestPage.getNesesseryElements();
        List<String> textToInput = dmsRequestPage.getTextToInputs();
        dmsRequestPage.fillFields(textToInput, necessaryFields);
        dmsRequestPage.fillSelect(dmsRequestPage.getRegions(), 1);
        dmsRequestPage.clickAgree();
    }
    @Допустим("Проверить, что все поля заполнены введенными значениями")
    public void checkFieldsRsg(){
        DmsRequestPage dmsRequestPage = new DmsRequestPage();
        List<WebElement> necessaryFields = dmsRequestPage.getNesesseryElements();
        List<String> textToCheck = dmsRequestPage.getTextToCheck();
        Assert.assertEquals("77", dmsRequestPage.getRegions().get(1).getAttribute("value"));//Нужно вынести в отдельный метод
        dmsRequestPage.assertData(textToCheck, necessaryFields);
    }

    @Допустим("Нажать Отправить")
    public void send(){
        DmsRequestPage dmsRequestPage = new DmsRequestPage();
        dmsRequestPage.clickSendButton();
    }

    @Допустим("Проверить, что у Поля -Эл. почта присутствует сообщение об ошибке -Введите корректный email")
    public void emailError(){
        DmsRequestPage dmsRequestPage = new DmsRequestPage();
        dmsRequestPage.checkEmailError();
        dmsRequestPage.fillEmail("trainee@aplana.ru");
        //DriverManager.closePages();
    }

    //==========================

    /*
    SberPersonPage sberPersonPage = new SberPersonPage();
    InsuranceTravelersPage insuranceTravelersPage = new InsuranceTravelersPage();
    RegistrationPage registrationPage = new RegistrationPage();*/
    @Допустим("Перейти на страницу http:\\/\\/www.sberbank.ru\\/ru\\/person")
    public void setUrl(){
        DriverManager.initialDriver("http://www.sberbank.ru/ru/person");
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
    @Допустим("Проверить наличие на странице заголовка – Страхование путешественников")
    public void checkTravelTitle(){
        SberPersonPage sberPersonPage = new SberPersonPage();
        sberPersonPage.checkTitle();
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
    public void fill(){
        RegistrationPage registrationPage = new RegistrationPage();
        List<WebElement> necessaryFields = registrationPage.getNesesseryElements();
        List<String> textToInput = registrationPage.getTextToInputs();
        registrationPage.fillFields(textToInput, necessaryFields);
    }
    @Допустим("Проверить, что все поля заполнены правильно")
    public void checkFieldsSber(){
        RegistrationPage registrationPage = new RegistrationPage();
        List<WebElement> necessaryFields = registrationPage.getNesesseryElements();
        List<String> textToInput = registrationPage.getTextToInputs();
        registrationPage.assertData(textToInput, necessaryFields);
    }
    @Допустим("Нажать продолжить")
    public void continueButton(){
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.clickContinueButton();
    }
    @Допустим("Проверить, что появилось сообщение - Заполнены не все обязательные поля")
    public void checkErrorMessage(){
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.assertErrorMessage();
        DriverManager.closePages();
        DriverManager.getDriver().quit();
    }
}
