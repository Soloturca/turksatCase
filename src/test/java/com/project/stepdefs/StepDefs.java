package com.project.stepdefs;

import com.saf.framework.CommonLib;
import com.saf.framework.MyTestNGBaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.UUID;

public class StepDefs extends MyTestNGBaseClass {
    CommonLib commonLib = new CommonLib();
    int timeout = 30;
    public String uuid = UUID.randomUUID().toString();
    public boolean checkLoginControl = false;

    @Before
    public void setReportName(Scenario scenario) {
        commonLib.startTest(scenario.getName());
    }

    @Given("^Open the (.*) URL$")
    public void openUrl(String URL) {
        CommonLib.navigateToURL(oDriver, URL);
    }

    @Then("^I see (.*) page$")
    public void seePage(String page) {
        commonLib.seePage(page);
    }

    @When("^(?:I )?click element: (\\w+(?: \\w+)*) at index (\\d+)")
    public void clickElement(String element, int index) {
        WebElement object = commonLib.findElement(element, index);

        try {
            if (object != null) {
                object.click();
                System.out.println("Clicked on object-->" + element);
                reportResult("PASS", "I click " + element + " element.(element found)", false);
            } else {
                System.out.println("Could not click on object-->" + element);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not click " + element + " element.(element not found)", true);
        }
    }

    @Then("^I enter \"([^\"]*)\" text to (.*) at index (\\d+)")
    public void enterText(String text, String element, int index) throws InterruptedException {
        //mouseHover(element);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);

        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The text has been entered.");
                reportResult("PASS", "I entered the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not entered the text ", true);
        }
    }

    @Then("^I enter unique text to (.*) at index (\\d+)")
    public void uniqueText(String element, int index) throws InterruptedException {
        //mouseHover(element);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        String text = "automation" + uuid;
        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The text has been entered.");
                reportResult("PASS", "I entered the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not entered the text ", true);
        }
    }

    @Then("^I clear text to (.*) at index (\\d+)")
    public void clearText(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        try {
            if (object != null) {
                object.click();
                Thread.sleep(1000);
                object.sendKeys(Keys.CONTROL, "a");
                object.sendKeys(Keys.DELETE);
                Thread.sleep(1000);
                System.out.println("The text has been deleted.");
                reportResult("PASS", "I deleted the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not deleted the text ", true);
        }

    }

    @And("^I wait (.*) element (\\d+) seconds at index (\\d+)")
    public void waitElement(String element, int timeout, int index) throws InterruptedException {
        commonLib.waitElement(element, timeout, index);
    }

    @When("^(?:I )?select element: \"([^\"]*)\" under (\\w+(?: \\w+)*) at index (\\d+)")
    public void selectElement(String text, String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        try {
            if (object != null) {
                object.click();
                System.out.println("Select the object type-->" + text + element);
                reportResult("PASS", "I selected " + element + " element.(element selected)", false);

                Select select = new Select(object);
                select.selectByVisibleText(text);

            } else {
                System.out.println("Could not select the object type-->" + element);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not select " + element + " element.(element not selected)", true);
        }
    }

    @And("^I need to just wait")
    public void justWait() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Then("^(?:I )?get the information: (\\w+(?: \\w+)*) at index (\\d+)")
    public void getTheReferenceNumber(String element, int index) {
        String object = commonLib.getTheElementInformation(element, index);
    }

    @Then("^(?:I )?read the information: (\\w+(?: \\w+)*) at index (\\d+)")
    public void readTheReferenceNumber(String element, int index) {
        String object = commonLib.readTheElementInformation(element, index);

    }

    @Then("^(?:I )?get pricing information of: (\\w+(?: \\w+)*) at index (\\d+)")
    public void getThePricingNumber(String element, int index) {
        String object = commonLib.getTheElementInformationForPricing(element, index);
    }

    @Then("^(?:I )?get the information by copying the value from: (\\w+(?: \\w+)*) at index (\\d+)")
    public void copyElement(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        try {
            if (object != null) {
                object.click();
                Thread.sleep(1000);
                object.sendKeys(Keys.CONTROL, "c");
                Thread.sleep(1000);
                System.out.println("The text has been copied.");
                reportResult("PASS", "I copied the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not copied the text ", true);
        }
    }

    @Then("^(?:I )?copy the information by copying the value to: (\\w+(?: \\w+)*) at index (\\d+)")
    public void pasteElement(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        try {
            if (object != null) {
                object.click();
                Thread.sleep(1000);
                object.sendKeys(Keys.CONTROL, "v");
                Thread.sleep(1000);
                System.out.println("The text has been pasted.");
                reportResult("PASS", "I pasted the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not pasted the text ", true);
        }
    }


    @When("^(?:I )?double click element: (\\w+(?: \\w+)*) at index (\\d+)")
    public void doubleClickElement(String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        commonLib.doubleClickElement(object);
    }


    @Then("^I enter my reference: \"([^\"]*)\" text to (.*) at index (\\d+)")
    public void dynamicReferenceNumberText(String text, String element, int index) throws InterruptedException {
        text = commonLib.referenceNumber;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);

        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The reference number:" + text + " " + "has been entered.");
                reportResult("PASS", "I entered the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not entered the text ", true);
        }
    }

    @Then("^I enter my pricing no: \"([^\"]*)\" text to (.*) at index (\\d+)")
    public void dynamicPricingNoText(String text, String element, int index) throws InterruptedException {
        text = commonLib.pricingNo;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);

        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The Pricing No number:" + text + " " + "has been entered.");
                reportResult("PASS", "I entered the text ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not entered the text ", true);
        }
    }

    @Then("^(?:I )?get the item value: (\\w+(?: \\w+)*)")
    public void getTheItemValue(String element) {
        int index = 1;
        String object = commonLib.getTheItemValue(element, index);
    }

    @Then("^The item value is changed to \"([^\"]*)\" under (.*)$")
    public void oppositeOption(String text, String element) throws InterruptedException {

        text = commonLib.itemValue;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, 1);

        Select select = new Select(object);
        object.click();

        try {
            if (object != null) {
                if (text == "POZİTİF") {
                    select.selectByVisibleText(text = "NEGATİF");
                    System.out.println("The opposite option:" + text + " " + "is entered.");
                } else if (text == "NEGATİF") {
                    select.selectByVisibleText(text = "POZİTİF");
                    System.out.println("The opposite option:" + text + " " + "is entered.");
                }

                reportResult("PASS", "I changed the option ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "I do not change the option ", true);
        }
    }
    //oluşan krediyi tutmamız lazım.
    //hashmap
    // if(tutar<450.000){test 0003>ilgili adımlar}
    //elseif(450.000<tutar<1.000.000)){test0004>>ilgili adımlar}
    //else{test0005>>ilgili adımları)

    @Then("I have to create a credit by credit amount:\"([^\"]*)\"")
    public void createCredit(String amount) throws InterruptedException {
        waitElement("loan button", timeout, 1);
        clickElement("loan button", 1);
        seePage("loan");
        waitElement("application button", timeout, 1);
        clickElement("application button", 1);
        waitElement("credit application introduction button", timeout, 1);
        clickElement("credit application introduction button", 1);
        enterText("5427", "customer no-new application text area", 1);
        clickElement("closeview", 1);
        waitElement("row button", timeout, 27);
        clickElement("row button", 27);
        waitElement("trade registration no text area", timeout, 1);
        enterText("4600", "trade registration no text area", 1);
        waitElement("parties row", timeout, 1);
        clickElement("parties row", 1);
        waitElement("row button", timeout, 1);
        clickElement("row button", 1);
        waitElement("checkbox", timeout, 1);
        clickElement("checkbox", 1);
        waitElement("update the guarantor button", timeout, 1);
        clickElement("update the guarantor button", 1);
        justWait();
        clickElement("continue to Reference Information button", 1);
        waitElement("shut down button", timeout, 1);
        clickElement("shut down button", 1);
        //# Başvuru Bilgileri sekmesine geçtim.
        waitElement("product name selection", timeout, 1);
        selectElement("DONANIM - YILLIK", "product name selection", 1);
        justWait();
        selectElement("136 - 30062021 FINCO", "pricing selection", 1);
        justWait();
        //Credit price
        enterText(amount, "invoice amount/product quantity text area", 1);
        justWait();
        clickElement("application calender button", 1);
        enterText("2", "maturity text area", 1);
        clickElement("update product button", 1);
        waitElement("shut down button", timeout, 1);
        clickElement("shut down button", 1);
        waitElement("row pick input", timeout, 1);
        clickElement("row pick input", 1);
        clickElement("create payment plan button", 1);
        waitElement("go on button", timeout, 1);
        clickElement("go on button", 1);
        waitElement("payment month selection", timeout, 1);
        selectElement("MART", "payment month selection", 1);
        clickElement("create payment plan button", 1);
        waitElement("pop up save button", timeout, 1);
        clickElement("pop up save button", 1);
        waitElement("save button", timeout, 1);
        clickElement("save button", 1);
        //# Teminat bilgileri sekmesine geldim.
        waitElement("collateral type selection", timeout, 1);
        selectElement("KEFALET", "collateral type selection", 1);
        selectElement("5278 - Sibel Eratak", "guarantor selection", 1);
        enterText("30", "collateral margin ratio text area", 1);
        clickElement("add collateral button", 1);
        waitElement("shut down button ", timeout, 1);
        clickElement("shut down button", 1);
        waitElement("continue to Finco Observation button ", timeout, 1);
        clickElement("continue to Finco Observation button", 1);
        //# Finco Gözlem sekmesine geldim.
        waitElement("continue to Financial Information button ", timeout, 1);
        clickElement("continue to Financial Information button", 1);
        //#Mali Bilgiler sekmesine geldim.
        //#Batu -> Buradan sonrasına upload methodu ekliyoruz. Daha düzenlediğim için karışık.
        waitElement("upload1 button ", timeout, 1);
        clickElement("upload1 button", 1);
        justWait();
        //uploadTheFile();
        justWait();
        clickElement("load 1st year button", 1);
        /*
        *waitElement("upload2 button ", timeout, 1);
        //Then I upload the "2018.pdf" file to upload2 button at index 1
        justWait();
        clickElement("load 2nd year button", 1);
        waitElement("upload3 button ", timeout, 1);
        //Then I upload the "2019.pdf" file to upload3 button at index 1
       justWait();
        clickElement("load 3rd year button", 1);
       waitElement("upload4 button ", timeout, 1);
       // Then I upload the "2020.pdf" file to upload4 button at index 1
        justWait();
        clickElement("load 4th year button", 1);*/
        selectElement("YMM", "1st year signing officer selection", 1);
        //Burada kaydetmemiz gereken butonu daha önceden oluşturmuşuz. (Buton ismi biraz yersiz kaldı.)
        clickElement("save button for parameter management", 1);
        waitElement("warning popup ", timeout, 1);
        clickElement("shut down button", 1);
        waitElement("continue to Documents button ", timeout, 1);
        clickElement("continue to Documents button", 1);
        //Evraklar sekmesine geldim. Evrak olarak herhangi bir PDF,excel,word dosyası yükleyebiliriz. Ben 2017.pdf'i yükledim.
        waitElement("upload to excel button ", timeout, 1);
        clickElement("upload to excel button", 1);
        // Then I upload the "2017.pdf" file to upload4 button at index 1
        waitElement("upload to excel button ", timeout, 2);
        clickElement("upload to excel button", 2);
        // Then I upload the "2017.pdf" file to upload4 button at index 2
        waitElement("upload to excel button ", timeout, 3);
        clickElement("upload to excel button", 3);
        // Then I upload the "2017.pdf" file to upload4 button at index 3
        waitElement("side selection ", timeout, 1);
        selectElement("TR - 5278 - Sibel Eratak", "side selection", 1);
        waitElement("upload to excel button ", timeout, 1);
        clickElement("upload to excel button", 1);
        // Then I upload the "2017.pdf" file to upload4 button at index 1
        waitElement("upload to excel button ", timeout, 2);
        clickElement("upload to excel button", 2);
        // Then I upload the "2017.pdf" file to upload4 button at index 2
        waitElement("upload to excel button ", timeout, 3);
        clickElement("upload to excel button", 3);
        // Then I upload the "2017.pdf" file to upload4 button at index 3
        waitElement("continue to Summary button ", timeout, 1);
        clickElement("continue to Summary button", 1);
        //Özet sekmesine geldim.
        waitElement("continue to the Registration button ", timeout, 1);
        clickElement("continue to the Registration button", 1);
        //Kayıt sekmesine geldim.
        waitElement("sending to approval button ", timeout, 1);
        clickElement("sending to approval button", 1);
        waitElement("warning popup  ", timeout, 1);
        enterText("Test islem onayina sunulmustur.", "explanation text area", 1);
        clickElement("add comment button", 1);
        enterText("Test", "note text area", 1);
        clickElement("approve the registration button", 1);
        getTheReferenceNumber("approve the registration button", 1);
        //Burada oluşturulan referans numarasını alarak da devam edebiliriz, fakat müşteri numarasını da biliyoruz.
        waitElement("warning popup  ", timeout, 1);
        clickElement("close button", 1);
        waitElement("customer no-new application text area  ", timeout, 1);
        //Yeni müşteri sayfasını gördükten sonra sistem kapanıyor, OKEY.
    }

    @Then("I have to cancel the credit")
    public void cancelCredit() throws InterruptedException {
        waitElement("loan button", timeout, 1);
        clickElement("loan button", 1);
        seePage("loan");
        waitElement("application button", timeout, 1);
        clickElement("application button", 1);
        clickElement("application button", 1);
        waitElement("customer no-application cancel text area", timeout, 1);
        enterText("5427", "customer no-application cancel text area", 1);
        clickElement("list references button", 1);
        waitElement("row select input ", timeout, 1);
        clickElement("row select input", 1);
        clickElement("cancel the application button", 1);
        waitElement("reason for cancellation selection ", timeout, 1);
        selectElement("MÜŞTERİ VAZGEÇTİ", "reason for cancellation selection", 1);
        clickElement("reason for cancellation selection", 1);
        waitElement("application cancel explanation text area ", timeout, 7);
        enterText("Test iptal.", "application cancel explanation text area", 7);
        waitElement("complete process button", timeout, 6);
        clickElement("complete process button", 6);
        waitElement("reference number text area", timeout, 1);
        getTheReferenceNumber("reference number text area", 1);
        waitElement("close button", timeout, 1);
        clickElement("close button", 1);
        seePage("home");
        waitElement("close system button", timeout, 1);
        clickElement("close system button", 1);
        waitElement("warning popup ", timeout, 1);
        clickElement("yes button", 1);
        //Kullanıcı değişti -> Kredi Tahsis Uzmanı (user name: 3003)
        seePage("login");
        waitElement("username text area", timeout, 1);
        enterText("3003", "username text area", 1);
        waitElement("login button ", timeout, 1);
        clickElement("login button", 1);
        seePage("home");
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);
        //BURADA KALDIN!
        //dynamicReferenceNumberText(text, "reference number area", 1);
        waitElement("inquire button", timeout, 1);
        clickElement("inquire button", 1);
        clickElement("row button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement("yes button", 1);
        waitElement("approve button", timeout, 1);
        clickElement("approve button", 1);
        waitElement("yes button", timeout, 1);
        clickElement("yes button", 1);
        justWait();
        waitElement("close button", timeout, 1);
        clickElement("close button", 1);
        seePage("home");
        waitElement("close system button", timeout, 1);
        clickElement("close system button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement(" yes button", 1);
        //Kullanıcı değişti -> Operasyon Uzmanı (user name: 3007)
        seePage("login");
        waitElement("username text area", timeout, 1);
        enterText("3007", "username text area", 1);
        waitElement("login button ", timeout, 1);
        clickElement("login button", 1);
        seePage("home");
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);
        //BURADA KALDIN!
       // dynamicReferenceNumberText(text, "reference number area", 1);
        waitElement("inquire button", timeout, 1);
        clickElement("inquire button", 1);
        clickElement("row button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement("yes button", 1);
        waitElement("approve button", timeout, 1);
        clickElement("approve button", 1);
        waitElement("yes button", timeout, 1);
        clickElement("yes button", 1);
        justWait();
        waitElement("close button", timeout, 1);
        clickElement("close button", 1);
        seePage("home");
        waitElement("close system button", timeout, 1);
        clickElement("close system button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement(" yes button", 1);


    }

    @Given("I go to \"([^\"]*)\" with this username: \"([^\"]*)\" and this password:\"([^\"]*)\"")
    public void loginSystem(String URL, String username, String password) throws InterruptedException {
        checkURLControl(URL);
        seePage("login");
        enterText(username, "username text area", 1);
        enterText(password, "password text area", 1);
        waitElement("login button", timeout, 1);
        clickElement("login button", 1);
        seePage("home");
    }


    @When("My website is close")
    public void checkURLControl(String URL) throws InterruptedException {
        //eğer URL kapalı ise git URL'i ayağa kaldır.
        if (checkLoginControl = false) {
            openUrl(URL);
            checkLoginControl = true;
        }
        //eğer URL açık ise (checkLoginControl = true)  hata bas.
        else {
            throw new InterruptedException("Your page is already opened. You cannot open the URL one more time.");
        }
    }
}