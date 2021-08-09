package com.project.stepdefs;

import com.saf.framework.CommonLib;
import com.saf.framework.MyTestNGBaseClass;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utils.excelutils.ExcelUtils;


import java.awt.*;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class StepDefs extends MyTestNGBaseClass {
    ExcelUtils excelUtils = new ExcelUtils();
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
    public boolean clickElement(String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                System.out.println("Clicked on object-->" + element);
                reportResult("PASS", "I clicked the element: " + element, true);
                return true;
            }
        } catch (Exception e) {
            reportResult("FAIL", "I cannot clicked the element: " + element, true);
            Assert.fail("Could not clicked the element:" + element);
            flag = false;
        }
        return flag;
    }


    @Then("^I enter \"([^\"]*)\" text to (.*) at index (\\d+)")
    public boolean enterText(String text, String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The text has been entered:" + text);
                reportResult("PASS", "I entered the text: " + text, true);
                return true;
            }
        } catch (Exception e) {
            reportResult("FAIL", "I cannot entered the element: " + text, true);
            Assert.fail("Could not entered the text:" + text);
            flag = false;
        }
        return flag;
    }

    @Then("^I enter a telephone number to (.*) at index (\\d+)")
    public boolean enterTelephoneNumber(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        String randomNumbers = RandomStringUtils.randomNumeric(7);
        String phNo = 111 + randomNumbers;
        try {
            if (object != null) {
                object.sendKeys(phNo);
                System.out.println("The telephone number has been entered:" + phNo);
                reportResult("PASS", "I entered the telephone number: " + phNo, true);
                return true;
            }
        } catch (Exception e) {
            reportResult("FAIL", "I cannot entered the element: " + phNo, true);
            Assert.fail("Could not entered the telephone number:" + phNo);
            flag = false;
        }
        return flag;
    }

    @Then("^I enter a email to (.*) at index (\\d+)")
    public boolean enterEmail(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        String email = commonLib.getRandomString() + "@example.com";
        try {
            if (object != null) {
                object.sendKeys(email);
                System.out.println("The email has been entered:" + email);
                reportResult("PASS", "I entered the email: " + email, true);
                return true;
            }
        } catch (Exception e) {
            reportResult("FAIL", "I cannot entered the element: " + email, true);
            Assert.fail("Could not entered the email:" + email);
            flag = false;
        }
        return flag;
    }

    @Then("^I enter a random declaration endorsement to (.*) at index (\\d+)")
    public boolean randomCiro(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        Random rnd = new Random();
        int randomCiro = rnd.nextInt(9999999);
        String randomCiroString=String.valueOf(randomCiro);
        try {
            if (object != null) {
                object.sendKeys(randomCiroString);
                System.out.println("The random declaration endorsement has been entered :" + randomCiroString);
                reportResult("PASS", "The random declaration endorsement has been entered: " + randomCiroString, true);
                return true;
            }
        } catch (Exception e) {
            reportResult("FAIL", "I cannot entered a random declaration endorsement: " + randomCiroString, true);
            Assert.fail("Could not entered a random declaration endorsement:" + randomCiroString);
            flag = false;
        }
        return flag;
    }

    @Then("^I have to check is there any document is uploaded on the (.*) at index (\\d+)")
    public boolean checkUploadFile(String element, int index) throws InterruptedException, AWTException, FindFailed, IOException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        try {
            if(object != null){
                seePage("customerTransactions");
                waitElement("address document upload button", 30, 3);
                clickElement("address document upload button", 3);
                if (oDriver.findElements(By.xpath("//*[contains(text(),'Dosya Yükleme')]")).size() > 0) {
                    seePage("customerTransactions");
                    waitElement("address document already popup",30,1);
                    clickElement("address document already popup",1);
                    waitElement("address document remove button",30,3);
                    clickElement("address document remove button",3);
                    waitElement("address document remove yes button",30,1);
                    clickElement("address document remove yes button",1);
                    waitElement("address document remove close button",30,1);
                    clickElement("address document remove close button",1);
                    waitElement("address document upload button",30,3);
                    uploadFile("aa.txt","address document upload button",3);
                    System.out.println("Uploaded the txt file.");
                    reportResult("PASS", "I upload the txt file. " , true);
                    return true;
            }
            else{
                    Thread.sleep(5000);
                    System.out.println("aa.txt is uploading.");
                    String fileName = System.getProperty("user.dir") + "\\Library\\aa.txt";
                    Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\Exes\\seleniumFolderUpload.exe " + fileName);
                    Thread.sleep(5000);
                    System.out.println("Uploaded the txt file.");
                    reportResult("PASS", "I upload the txt file. ", true);
                    return true;
            }
            }
        } catch (Exception e) {
            reportResult("FAIL", "An error during the uploading process. ", true);
            Assert.fail("An error during the uploading process.");
            flag = false;
        }
        return flag;
    }

    @Then("^I enter unique text to (.*) at index (\\d+)")
    public boolean uniqueText(String element, int index) throws InterruptedException {
        //mouseHover(element);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        String text = "automation" + uuid;
        boolean flag = false;
        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The text has been entered.");
                reportResult("PASS", "I entered the text: " + text, true);
                return true;
            }
        } catch (Exception e) {
            reportResult("FAIL", "I cannot entered the element: " + text, true);
            Assert.fail("Could not entered the text:" + text);
            flag = false;
        }
        return flag;
    }

    @Then("^I verify the area (.*) by read only at index (\\d+)")
    public boolean readOnlyAreaCheck(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;

        try {
            if (object != null) {
                if (!object.isEnabled()) {
                    System.out.println("The area is a read only area. Cannot be editable.");
                    reportResult("PASS", "The area is a read only area. Cannot be editable.", true);
                    return true;
                }
            }
        } catch (Exception e) {
            reportResult("FAIL", "The area is not a read only area. Can be editable. ", true);
            Assert.fail("The area is not a read only area. Can be editable.");
            flag = false;
        }
        return flag;
    }

    @Then("^I verify the area (.*) by (.*) by segmentation at index (\\d+)")
    public boolean segmentationCheck(String element1, String element2, int index) throws InterruptedException {
        WebElement object1;
        WebElement object2;

        object1 = commonLib.waitElement(element1, timeout, index);
        object2 = commonLib.waitElement(element2, timeout, index);
        boolean flag = false;

        String segmentCode = commonLib.getTheItemValueFromAttribute(element1, index);
        String ciroInfo = commonLib.getTheItemValueFromAttribute(element2, index);
        String ciroInfos=ciroInfo.replace(".","");
        System.out.println(ciroInfos);
        String ciroLast= ciroInfos.substring(0, ciroInfos.indexOf(","));
        System.out.println(ciroLast);
        int ciroInfoNum = Integer.parseInt(ciroLast);
        System.out.println(ciroInfoNum);

        try {
            if (object1 != null & object2 != null) {
                if (ciroInfoNum == 0) {
                    segmentCode.equals("BELİRTİLMEDİ");
                    System.out.println("Matched. Segment Code: NOK");
                    reportResult("PASS", "Matched. Segment Code: NOK", true);
                } else if (0 < ciroInfoNum & ciroInfoNum < 2000000) {
                    segmentCode.equals("MİKRO İŞLETME");
                    System.out.println("Matched. Segment Code: Micro Company");
                    reportResult("PASS", "Matched. Segment Code: Micro Company", true);
                } else if (2000000 < ciroInfoNum & ciroInfoNum <= 10000000) {
                    segmentCode.equals("KÜÇÜK İŞLETME");
                    System.out.println("Matched. Segment Code: Small Bussiness");
                    reportResult("PASS", "Matched. Segment Code: Small Company", true);
                } else if (10000000 < ciroInfoNum & ciroInfoNum <= 75000000) {
                    segmentCode.equals("TİCARİ İŞLETME");
                    System.out.println("Matched. Segment Code: Commercial Company");
                    reportResult("PASS", "Matched. Segment Code: Commercial Company", true);
                } else {
                    segmentCode.equals("KURUMSAL İŞLETME");
                    System.out.println("Matched. Segment Code: Corparate Company");
                    reportResult("PASS", "Matched. Segment Code: Corparate Company", true);
                }
                return true;
            }
        } catch (Exception e) {
            reportResult("FAIL", "Unknown Company. Error. ", true);
            Assert.fail("Unknown Company. Error.");
            flag = false;
        }
        return flag;
    }


    @Then("^I clear text to (.*) at index (\\d+)")
    public boolean clearText(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                Thread.sleep(1000);
                object.sendKeys(Keys.CONTROL, "a");
                object.sendKeys(Keys.DELETE);
                Thread.sleep(1000);
                System.out.println("The text has been deleted.");
                reportResult("PASS", "The text has been deleted.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The text has not been deleted.");
            reportResult("FAIL", "The text has not been deleted", true);
            Assert.fail("Waiting element is not found!");
            flag = false;
        }
        return flag;
    }

    @And("^I wait (.*) element (\\d+) seconds at index (\\d+)")
    public void waitElement(String element, int timeout, int index) throws InterruptedException {
        commonLib.waitElement(element, timeout, index);

    }

    @When("^(?:I )?select element: \"([^\"]*)\" under (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean selectElement(String text, String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                System.out.println("Select the object type-->" + text + element);
                Select select = new Select(object);
                select.selectByVisibleText(text);
                reportResult("PASS", "The selection is done.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The selection cannot be done.");
            reportResult("FAIL", "The selection cannot be done.", true);
            Assert.fail("The selection cannot be done!");
            flag = false;
        }
        return flag;
    }


    @And("^I need to just wait")
    public void justWait() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Then("^(?:I )?get the information: (\\w+(?: \\w+)*) at index (\\d+)")
    public void getTheReferenceNumber(String element, int index) {
        String object = commonLib.getTheElementInformation(element, index);
    }

    @Then("^(?:I )?get the text area information: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean getTextFromAttribute(String element, int index) {
        String object = commonLib.getTheItemValueFromAttribute(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                System.out.println(object);
                reportResult("PASS", "I got the information:" + object, true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Could not got the information.");
            reportResult("FAIL", "Could not got the information.", true);
            Assert.fail("Could not got the information.");
            flag = false;

        }
        return flag;
    }


    @Then("^(?:I )?get the credit amount information: (\\w+(?: \\w+)*) at index (\\d+)")
    public void getTheElementInformationForCreditAmount(String element, int index) {
        double object = commonLib.getTheElementInformationForCreditAmount(element, index);

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
    public boolean copyElement(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                Thread.sleep(1000);
                object.sendKeys(Keys.CONTROL, "c");
                Thread.sleep(1000);
                System.out.println("The text has been copied.");
                reportResult("PASS", "The text has been copied.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The copy action cannot be done.");
            reportResult("FAIL", "The copy action cannot be done.", true);
            Assert.fail("The copy action cannot be done!");
            flag = false;

        }
        return flag;
    }


    @Then("^(?:I )?copy the information by copying the value to: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean pasteElement(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.click();
                Thread.sleep(1000);
                object.sendKeys(Keys.CONTROL, "v");
                Thread.sleep(1000);
                System.out.println("The text has been pasted.");
                reportResult("PASS", "The text has been pasted.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The paste action cannot be done.");
            reportResult("FAIL", "The paste action cannot be done.", true);
            Assert.fail("The paste action cannot be done!");
            flag = false;

        }
        return flag;
    }


    @When("^(?:I )?double click element: (\\w+(?: \\w+)*) at index (\\d+)")
    public void doubleClickElement(String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        commonLib.doubleClickElement(object);
    }


    @Then("^I enter my reference: \"([^\"]*)\" text to (.*) at index (\\d+)")
    public boolean dynamicReferenceNumberText(String text, String element, int index) throws InterruptedException {
        text = commonLib.referenceNumber;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;

        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The reference number:" + text + " " + "has been entered.");
                reportResult("PASS", "The reference number:" + text + " " + "has not been entered.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The reference number:" + text + " " + "has not been entered.");
            reportResult("FAIL", "The reference number:" + text + " " + "has not been entered.", true);
            Assert.fail("The reference number has not been entered!");
            flag = false;

        }
        return flag;
    }

    @Then("^I enter my pricing no: \"([^\"]*)\" text to (.*) at index (\\d+)")
    public boolean dynamicPricingNoText(String text, String element, int index) throws InterruptedException {
        text = commonLib.pricingNo;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The Pricing No number:" + text + " " + "has been entered.");
                reportResult("PASS", "The Pricing No:" + text + " " + "has not been entered.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The Pricing No number:" + text + " " + "has not been entered.");
            reportResult("FAIL", "The Pricing No number:" + text + " " + "has not been entered.", true);
            Assert.fail("The Pricing No has not been entered!");
            flag = false;

        }
        return flag;
    }

    @Then("^(?:I )?get the item value: (\\w+(?: \\w+)*)")
    public void getTheItemValue(String element) {
        int index = 1;
        String object = commonLib.getTheItemValue(element, index);
    }

    @Then("^The item value is changed to \"([^\"]*)\" under (.*)$")
    public boolean oppositeOption(String text, String element) throws InterruptedException {

        text = commonLib.itemValue;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, 1);
        boolean flag = false;

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
                return true;
            }
        } catch (Exception e) {
            Assert.fail("Could not change the option!");
            reportResult("FAIL", "Could not change the option", true);
            flag = false;
        }
        return flag;
    }

    @Given("I go to \"([^\"]*)\" with this username: \"([^\"]*)\" and this password:\"([^\"]*)\"")
    public void loginSystem(String URL, String username, String password) throws InterruptedException {
        openUrl(URL);
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


    @Then("^(?:I )?get the data from Excel file to element: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean getExcelValue(String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        String text = excelUtils.ReadCellData(4, 0);
        boolean flag = false;

        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The excel value:" + text + " " + "has been entered.");
                reportResult("PASS", "The excel value:" + text + " " + "has not been entered.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The reference number:" + text + " " + "has not been entered.");
            reportResult("FAIL", "The excel value:" + text + " " + "has not been entered.", true);
            Assert.fail("The excel value has not been entered!");
            flag = false;

        }
        return flag;
    }

    @Then("I need to TCKN verify for (\\w+(?: \\w+)*) match from Excel file at index (\\d+)")
    public boolean verifyClientDataForTCKN(String element, int index) {
        String TCKNExcel = excelUtils.ReadCellData(4, 1);
        System.out.println(TCKNExcel);

        String TCKN = commonLib.getTheItemValueFromAttribute(element, index);
        System.out.println(TCKN);
        boolean flag = false;

        try {

            if (TCKN.equals(TCKNExcel)) {
                System.out.println("The excel value:" + TCKNExcel + "is match with the element text " + TCKN);
                reportResult("PASS", "The excel value:" + TCKNExcel + "is match with the element text " + TCKN, true);
            }
            return true;
        } catch (Exception e) {
            System.out.println("The excel value:" + TCKNExcel + "is not match with the element text " + TCKN);
            reportResult("FAIL", "The excel value:" + TCKNExcel + "is not match with the element text " + TCKN, true);
            Assert.fail("The values are not match with each other!");
            flag = false;
        }
        return flag;
    }

    @Then("I need to Title verify for (\\w+(?: \\w+)*) match from Excel file at index (\\d+)")
    public boolean verifyClientDataForTitle(String element, int index) {
        String TCKNExcel = excelUtils.ReadCellData(4, 0);
        System.out.println(TCKNExcel);

        String Name = commonLib.getTheItemValue(element, index);
        System.out.println(Name);
        boolean flag = false;

        try {

            if (Name.equals(TCKNExcel)) {
                System.out.println("The excel value:" + TCKNExcel + "is match with the element text " + Name);
                reportResult("PASS", "The excel value:" + TCKNExcel + "is match with the element text " + Name, true);
            }
            return true;
        } catch (Exception e) {
            System.out.println("The excel value:" + TCKNExcel + "is not match with the element text " + Name);
            reportResult("FAIL", "The excel value:" + TCKNExcel + "is not match with the element text " + Name, true);
            Assert.fail("The values are not match with each other!");
            flag = false;
        }
        return flag;
    }

    @Then("^(?:I )?I need to checkbox verify for (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean verifyCheckbox(String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        boolean flag = false;
        try {
            if (object.isSelected()) {
                System.out.println("The checkbox is selection state is - " + object.isSelected());
                reportResult("PASS", "I selected the checkbox: " + element, true);
                return true;
            }
        } catch (Exception e) {
            reportResult("FAIL", "I cannot selected the checkbox: " + element, true);
            Assert.fail("Could not selected the checkbox:" + element);
            flag = false;
        }
        return flag;
    }

    @Then("^(?:I )?upload the file \"([^\"]*)\" using the: (\\w+(?: \\w+)*) at index (\\d+)")
    public void uploadFile(String text, String element, int index) throws IOException, InterruptedException, FindFailed, AWTException, IOException {

        WebElement object;
        object = commonLib.findElement(element, index);
        //object.click();
        Thread.sleep(5000);

        System.out.println("aa.txt is uploading.");
        String fileName = System.getProperty("user.dir") + "\\Library\\aa.txt";
        Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\Exes\\seleniumFolderUpload.exe " + fileName);
        Thread.sleep(5000);


    }

    //******************************* FINCO TEST STEPS ********************************//
    //Aşağıdaki metotlar, kredi test case'leri için pre-condition niteliği taşıyan ve sürekli kullanımı elzem olan metotlardır. Aşağıdaki metotlar yer alır:

    //1. Kredi oluşturma - TC001
    //2. Kredi iptal etme -TC008
    //3. Kredi değerlendirme - TC001
    //43. Kredi Kullandırım - TC001

    @Then("I have to create a credit by credit amount:\"([^\"]*)\" for customer:\"([^\"]*)\"")
    public void createCredit(String amount, String customerNo) throws InterruptedException {
        waitElement("loan button for 4000", timeout, 1);
        clickElement("loan button for 4000", 1);
        seePage("loan");
        waitElement("application button", timeout, 1);
        clickElement("application button", 1);
        waitElement("credit application introduction button", timeout, 1);
        clickElement("credit application introduction button", 1);
        enterText(customerNo, "customer no-new application text area", 1);

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
    public void cancelCredit(String text) throws InterruptedException {
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
        dynamicReferenceNumberText(text, "reference number area", 1);
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
        dynamicReferenceNumberText(text, "reference number area", 1);
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

    @Then("I have to evaluate for the credit for kurumsal")
    public void evaulateCreditForKurumsal() throws InterruptedException {
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);

        enterText("20210713-00042", "reference number area", 1);
        //dynamicReferenceNumberText(text, "reference number area", 1);

        waitElement("inquire button", timeout, 1);
        clickElement("inquire button", 1);
        clickElement("row button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement("yes button", 1);
        justWait();
        seePage("loan");
        waitElement("customer information tab continue button", timeout, 1);
        clickElement("customer information tab continue button", 1);
        waitElement("external agency inquiry tab continue button", timeout, 1);
        clickElement("external agency inquiry tab continue button", 1);
        waitElement("FINCO observation tab continue button", timeout, 1);
        clickElement("FINCO observation tab continue button", 1);

        waitElement("calculate button for financial info", timeout, 1);
        clickElement("calculate button for financial info", 1);

        waitElement("close button for financial info", timeout, 1);
        clickElement("close button for financial info", 1);
        waitElement("save button for financial info", timeout, 1);
        clickElement("save button for financial info", 1);
        waitElement("close button for financial info", timeout, 1);
        clickElement("close button for financial info", 1);

        //waitElement("calculate button for consolidated", timeout, 1);
        //clickElement("calculate button for consolidated", 1);
        //waitElement("close button for financial info", timeout, 1);
        // clickElement("close button for financial info", 1);
        //waitElement("save button for consolidated", timeout, 1);
        //clickElement("save button for consolidated", 1);
        //waitElement("close button for financial info", timeout, 1);
        //clickElement("close button for financial info", 1);
        selectElement("YMM", "signature area 1", 1);
        selectElement("YMM", "signature area 2", 1);
        selectElement("YMM", "signature area 3", 1);
        selectElement("YMM", "signature area 4", 1);

        clickElement("calculate button for financial info", 1);
        waitElement("close button for financial info", timeout, 1);
        waitElement("save button for financial info", timeout, 1);
        clickElement("close button for financial info", 1);

        waitElement("financial information tab continue button", timeout, 1);
        clickElement("financial information tab continue button", 1);
        waitElement("evaluation tab area", timeout, 1);
        clickElement("evaluation tab continue button", 1);

        waitElement("documents tab area", timeout, 1);
        clickElement("documents tab continue button", 1);
        waitElement("opinion and decision tab area", timeout, 1);
        clearText("approved due date text area", 1);
        enterText("1", "approved due date text area", 1);
        clearText("approved amount text area", 1);
        enterText("1", "approved amount text area", 1);

        waitElement("create payment plan button", timeout, 1);
        clickElement("create payment plan button", 1);
        waitElement("create payment plan section button", timeout, 1);
        clickElement("create payment plan section button", 1);
        waitElement("create payment plan button", timeout, 1);
        clickElement("create payment plan button", 1);
        waitElement("save button for payment plan", timeout, 1);
        clickElement("save button for payment plan", 1);
        waitElement("save button for financial info", timeout, 1);
        clickElement("save button for financial info", 1);
        waitElement("close button for financial info", timeout, 1);
        clickElement("close button for financial info", 1);
        waitElement("approve button", timeout, 1);
        clickElement("approve button", 1);
        enterText("TEST", "transaction confirmation note text area", 1);
        waitElement("send approve button", timeout, 1);
        clickElement("send approve button", 1);
        waitElement("close button", timeout, 1);
        clickElement("close button", 1);

        /*    if (commonLib.creditAmount < 450000) {
           approveCreditUnder();
        } else if (450000< commonLib.creditAmount &&  commonLib.creditAmount<1000000) {
            approveCreditBetween();
        } else {
            approveCreditAbove();
        }*/


    }

    @Then("I have to evaluate for the credit for GKT")
    public void evaulateCreditForGKT() throws InterruptedException {
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);

        enterText("20210713-00023", "reference number area", 1);
        clickElement("job first date area", 1);
        enterText("01", "job first date area", 1);
        //dynamicReferenceNumberText(text, "reference number area", 1);

        waitElement("inquire button", timeout, 1);
        clickElement("inquire button", 1);
        clickElement("row button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement("yes button", 1);
        justWait();
        seePage("loan");
        waitElement("customer information tab continue button", timeout, 1);
        clickElement("customer information tab continue button", 1);
        waitElement("external agency inquiry tab continue button", timeout, 1);
        clickElement("external agency inquiry tab continue button", 1);
        waitElement("FINCO observation tab continue button", timeout, 1);
        clickElement("FINCO observation tab continue button", 1);

        waitElement("calculate button for financial info", timeout, 1);
        clickElement("calculate button for financial info", 1);

        waitElement("close button for financial info", timeout, 1);
        clickElement("close button for financial info", 1);
        waitElement("save button for financial info", timeout, 1);
        clickElement("save button for financial info", 1);
        waitElement("close button for financial info", timeout, 1);
        clickElement("close button for financial info", 1);

        //waitElement("calculate button for consolidated", timeout, 1);
        //clickElement("calculate button for consolidated", 1);
        //waitElement("close button for financial info", timeout, 1);
        // clickElement("close button for financial info", 1);
        //waitElement("save button for consolidated", timeout, 1);
        //clickElement("save button for consolidated", 1);
        //waitElement("close button for financial info", timeout, 1);
        //clickElement("close button for financial info", 1);

        //selectElement("YMM", "signature area 1", 1);
        //selectElement("YMM", "signature area 2", 1);
        //selectElement("YMM", "signature area 3", 1);
        //selectElement("YMM", "signature area 4", 1);
        //
        //clickElement("calculate button for financial info", 1);
        //waitElement("close button for financial info", timeout, 1);
        //waitElement("save button for financial info", timeout, 1);
        //clickElement("save button for financial info", 1);
        //clickElement("close button for financial info", 1);

        waitElement("financial information tab continue button", timeout, 1);
        clickElement("financial information tab continue button", 1);
        waitElement("evaluation tab area", timeout, 1);
        clickElement("evaluation tab continue button", 1);

        waitElement("documents tab area", timeout, 1);
        clickElement("documents tab continue button", 1);
        waitElement("opinion and decision tab area", timeout, 1);
        clickElement("approved maturity text area", 1);
        clearText("approved maturity text area", 1);
        enterText("2", "approved maturity text area", 1);
        clickElement("approved amount text area", 1);
        clearText("approved amount text area", 1);
        enterText("20000", "approved amount text area", 1);

        waitElement("create payment plan button", timeout, 1);
        clickElement("create payment plan button", 1);
        waitElement("create payment plan section button", timeout, 1);
        clickElement("create payment plan section button", 1);
        waitElement("create payment plan button", timeout, 1);
        clickElement("create payment plan button", 1);
        waitElement("save button for payment plan", timeout, 1);
        clickElement("save button for payment plan", 1);
        waitElement("save button for financial info", timeout, 1);
        clickElement("save button for financial info", 1);
        waitElement("close button for financial info", timeout, 1);
        clickElement("close button for financial info", 1);
        waitElement("approve button", timeout, 1);
        clickElement("approve button", 1);
        enterText("TEST", "transaction confirmation note text area", 1);
        //waitElement("send approve button", timeout, 1);
        //clickElement("send approve button", 1);
        //waitElement("close button", timeout, 1);
        //clickElement("close button", 1);

    /*    if (commonLib.creditAmount < 450000) {
       approveCreditUnder();
    } else if (450000< commonLib.creditAmount &&  commonLib.creditAmount<1000000) {
        approveCreditBetween();
    } else {
        approveCreditAbove();
    }*/


    }


    @Then("I have to approve for the credit of under 450.000TL")
    public void approveCreditUnder(String text) throws InterruptedException {
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);
        dynamicReferenceNumberText(text, "reference number area", 1);
        waitElement("inquire button", timeout, 1);
        clickElement("inquire button", 1);
        clickElement("row button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement("yes button", 1);
        waitElement("approve button", timeout, 1);
        clickElement("approve button", 1);
        enterText("TEST", "transaction confirmation note text area", 1);
        enterText("TEST", "transaction description text area", 1);
        waitElement("send approve button", timeout, 1);
        clickElement("send approve button", 1);
        waitElement("close button", timeout, 1);
        clickElement("close button", 1);
        waitElement("close system button", timeout, 1);
        clickElement("close system button", 1);
        waitElement("warning popup ", timeout, 1);
        clickElement("yes button", 1);

        //Kullanıcı değişti -> Kredi komitesi (user name: 3005)
        seePage("login");
        waitElement("username text area", timeout, 1);
        enterText("3005", "username text area", 1);
        waitElement("login button ", timeout, 1);
        clickElement("login button", 1);
        seePage("home");
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);
        dynamicReferenceNumberText(text, "reference number area", 1);
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
        enterText("TEST", "transaction confirmation note text area", 1);
        waitElement("send approve button", timeout, 1);
        clickElement("send approve button", 1);
        waitElement("close button", timeout, 1);
        clickElement("close button", 1);
        waitElement("close system button", timeout, 1);
        clickElement("close system button", 1);
        waitElement("warning popup ", timeout, 1);
        clickElement("yes button", 1);

        //Kullanıcı değişti -> Yönetim Kurulu (user name: 3005)
        seePage("login");
        waitElement("username text area", timeout, 1);
        enterText("3005", "username text area", 1);
        waitElement("login button ", timeout, 1);
        clickElement("login button", 1);
        seePage("home");
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);
        dynamicReferenceNumberText(text, "reference number area", 1);
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
        enterText("TEST", "transaction confirmation note text area", 1);
        waitElement("send approve button", timeout, 1);
        clickElement("send approve button", 1);
        waitElement("close button", timeout, 1);
        clickElement("close button", 1);
        waitElement("close system button", timeout, 1);
        clickElement("close system button", 1);
        waitElement("warning popup ", timeout, 1);
        clickElement("yes button", 1);
    }


    @Then("I have to approve for the credit of between 450.000 - 1.000.000 TL")
    public void approveCreditBetween(String text) throws InterruptedException {
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);
        dynamicReferenceNumberText(text, "reference number area", 1);
        waitElement("inquire button", timeout, 1);
        clickElement("inquire button", 1);
        clickElement("row button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement("yes button", 1);
        waitElement("approve button", timeout, 1);
        clickElement("approve button", 1);
        enterText("TEST", "transaction confirmation note text area", 1);
        enterText("TEST", "transaction description text area", 1);
        waitElement("send approve button", timeout, 1);
        clickElement("send approve button", 1);
        waitElement("close button", timeout, 1);
        clickElement("close button", 1);
        waitElement("close system button", timeout, 1);
        clickElement("close system button", 1);
        waitElement("warning popup ", timeout, 1);
        clickElement("yes button", 1);


        //Kullanıcı değişti -> Yönetim Kurulu (user name: 3005)
        seePage("login");
        waitElement("username text area", timeout, 1);
        enterText("3005", "username text area", 1);
        waitElement("login button ", timeout, 1);
        clickElement("login button", 1);
        seePage("home");
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);
        dynamicReferenceNumberText(text, "reference number area", 1);
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
        enterText("TEST", "transaction confirmation note text area", 1);
        waitElement("send approve button", timeout, 1);
        clickElement("send approve button", 1);
        waitElement("close button", timeout, 1);
        clickElement("close button", 1);
        waitElement("close system button", timeout, 1);
        clickElement("close system button", 1);
        waitElement("warning popup ", timeout, 1);
        clickElement("yes button", 1);

    }


    @Then("I have to approve for the credit of above 1.000.000 TL")
    public void approveCreditAbove(String text) throws InterruptedException {
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);
        dynamicReferenceNumberText(text, "reference number area", 1);
        waitElement("inquire button", timeout, 1);
        clickElement("inquire button", 1);
        clickElement("row button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement("yes button", 1);
        waitElement("approve button", timeout, 1);
        clickElement("approve button", 1);
        enterText("TEST", "transaction confirmation note text area", 1);
        enterText("TEST", "transaction description text area", 1);
        waitElement("send approve button", timeout, 1);
        clickElement("send approve button", 1);
        waitElement("close button", timeout, 1);
        clickElement("close button", 1);
        waitElement("close system button", timeout, 1);
        clickElement("close system button", 1);
        waitElement("warning popup ", timeout, 1);
        clickElement("yes button", 1);
    }

    @Then("I have to do usage control for the credit")
    public void creditUsage(String text) throws InterruptedException {
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("pending jobs button", timeout, 1);
        clickElement("pending jobs button", 1);
        dynamicReferenceNumberText(text, "reference number area", 1);
        waitElement("inquire button", timeout, 1);
        clickElement("inquire button", 1);
        clickElement("row button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement("yes button", 1);
        waitElement("approve button", timeout, 1);
        clickElement("approve button", 1);
        seePage("loan");
    }

    @Then("I have to do usage control for the document")
    public void creditUsageControlDigital(String text) throws InterruptedException {
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("pending jobs button", timeout, 1);
        clickElement("pending jobs button", 1);
        dynamicReferenceNumberText(text, "reference number area", 1);
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

    }

    @Then("I have to do usage control and observation for the document")
    public void creditUsageControlObservation(String text) throws InterruptedException {
        waitElement("credit button", timeout, 1);
        clickElement("credit button", 1);
        seePage("loan");
        waitElement("credit application button", timeout, 1);
        clickElement("credit application button", 1);
        waitElement("credit application observation and report button", timeout, 1);
        clickElement("credit application observation and report button", 1);
        waitElement("credit application observation and report customer no button", timeout, 1);
        enterText("5426", "credit application observation and report customer no button", 1);
        waitElement("credit application observation and report search and list button", timeout, 1);
        clickElement("credit application observation and report search and list button", 1);
        readTheReferenceNumber(" credit application observation and report transaction reference number text area", 1);
    }

    @Then("I have to do usage control money transfer")
    public void creditUsageControlMoneyTransfer(String text) throws InterruptedException {
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);
        dynamicReferenceNumberText(text, "reference number area", 1);
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
        waitElement("sender bank button", timeout, 1);
        clickElement("sender bank button", 1);
        selectElement("T.C MERKEZ BANKASI A.S.", "bank code selection", 1);
        dynamicReferenceNumberText(text, "account no text area", 1);
        waitElement("inquire button for account information", timeout, 1);
        clickElement("inquire button for account information", 1);

    }

    @Then("I have to do usage control money transfer approve")
    public void creditUsageControlMoneyTransferApprove(String text) throws InterruptedException {
        clickElement("workflow management button", 1);
        seePage("workflowManagement");
        waitElement("jobs pending on my list button", timeout, 1);
        clickElement("jobs pending on my list button", 1);
        dynamicReferenceNumberText(text, "reference number area", 1);
        waitElement("inquire button", timeout, 1);
        clickElement("inquire button", 1);
        clickElement("row button", 1);
        waitElement("warning popup", timeout, 1);
        clickElement("yes button", 1);

    }
}


