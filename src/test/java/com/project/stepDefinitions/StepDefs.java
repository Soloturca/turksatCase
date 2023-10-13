package com.project.stepDefinitions;

import com.saf.framework.CommonLib;
import com.saf.framework.MyTestNGBaseClass;
import com.saf.framework.TestUtils;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

public class StepDefs extends MyTestNGBaseClass {
    CommonLib commonLib = new CommonLib();
    int timeout = 30;
    public String uuid = UUID.randomUUID().toString();
    public boolean checkLoginControl = false;
    public String phNo;
    public String randomEmployees;
    public String randomCiroString;
    public String object;
    public static HashMap<String, String> strings = new HashMap<String, String>();
    InputStream stringsis;
    TestUtils utils;

    public String TCKNnumber = "";

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
            if (object != null && CommonLib.checkElementVisibility(object)) {
                object.click();
                System.out.println("Clicked on object-->" + element);
                Allure.addAttachment("Element is clicked.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "I clicked the element: " + element, true);
                return true;
            }
        } catch (Exception e) {
            reportResult("FAIL", "I cannot clicked the element: " + element, true);
            Allure.addAttachment("Element is not clicked.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("Could not clicked the element:" + element);
            flag = false;
        }
        return flag;
    }


    @When("^(?:I )?have to verify the text for: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean verifyText(String element, int index) throws Exception {
        WebElement object = commonLib.findElement(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                String xmlFileName = "strings.xml";
                stringsis = this.getClass().getClassLoader().getResourceAsStream(xmlFileName);
                utils = new TestUtils();
                strings = utils.parseStringXML(stringsis);

                object.click();
                String actualErrTxt = object.getText();
                if (element.contains("approve popup")) {
                    String expectedErrText = strings.get("approve popup");
                    System.out.println("actual popup text - " + actualErrTxt + "\n" + "expected popup text - " + expectedErrText);
                    Assert.assertEquals(actualErrTxt, expectedErrText);
                    Allure.addAttachment("Verification completed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    reportResult("PASS", "Assertion is true." + element, true);
                    return true;
                } else if (element.contains("assign to pool popup")) {
                    String expectedErrText = strings.get("assign to pool popup");
                    System.out.println("actual popup text - " + actualErrTxt + "\n" + "expected popup text - " + expectedErrText);
                    Assert.assertEquals(actualErrTxt, expectedErrText);
                    Allure.addAttachment("Verification completed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    reportResult("PASS", "Assertion is true." + element, true);
                    return true;
                } else if (element.contains("cancel popup")) {
                    String expectedErrText = strings.get("cancel popup");
                    System.out.println("actual popup text - " + actualErrTxt + "\n" + "expected popup text - " + expectedErrText);
                    Assert.assertEquals(actualErrTxt, expectedErrText);
                    Allure.addAttachment("Verification completed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    reportResult("PASS", "Assertion is true." + element, true);
                    return true;
                } else if (element.contains("system menu button")) {
                    String expectedErrText = strings.get("system menu button");
                    System.out.println("actual popup text - " + actualErrTxt + "\n" + "expected popup text - " + expectedErrText);
                    Assert.assertEquals(actualErrTxt, expectedErrText);
                    Allure.addAttachment("Verification completed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    reportResult("PASS", "Assertion is true." + element, true);
                    return true;
                }

            }
        } catch (Exception e) {
            Allure.addAttachment("Verification does not completed.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "An error during assertion. " + element, true);
            Assert.fail("Could not clicked the element:" + element);
            flag = false;
        } finally {
            if (stringsis != null) {
                stringsis.close();
            }
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
                Allure.addAttachment("The text has been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "I entered the text: " + text, true);

                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("The text has not been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
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
        phNo = 111 + randomNumbers;


        try {
            if (object != null) {
                object.sendKeys(phNo);
                System.out.println("The telephone number has been entered:" + phNo);
                Allure.addAttachment("The telephone number has been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "I entered the telephone number: " + phNo, true);
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("The telephone number has not been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "I cannot entered the element: " + phNo, true);
            Assert.fail("Could not entered the telephone number:" + phNo);
            flag = false;
        }
        return flag;
    }

    @Then("^I verify the telephone number to (.*)")
    public boolean verifyTelephoneNumber(String element) throws InterruptedException {
        int index = 3;
        System.out.println("phNo: " + " " + phNo);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        object.click();
        String phNo2 = commonLib.getTheElementInformation(element, index);
        System.out.println("phNo2: " + " " + phNo2);
        boolean flag = false;

        try {
            if (phNo2.equals(phNo)) {
                System.out.println("Matched.Telephone No is Updated.");
                Allure.addAttachment("Matched. Telephone No is Updated.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "Matched. Matched.Telephone No is Updated.", true);
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("Not matched. Telephone No is not updated.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "Not matched. Telephone No Is not Updated. " + phNo, true);
            Assert.fail("Not matched. An error during the update." + phNo);
            flag = false;
        }
        return flag;
    }

    @Then("^I verify the number of employees number to (.*) at index (\\d+)")
    public boolean verifyNumberOfEmployees(String element, int index) throws InterruptedException {
        System.out.println("Number of Employees: " + " " + randomEmployees);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        object.click();
        String randomEmployees2 = commonLib.getTheItemValueFromAttribute(element, index);
        System.out.println("Number of Employees: " + " " + randomEmployees2);
        boolean flag = false;

        try {
            if (randomEmployees2.equals(randomEmployees)) {
                System.out.println("Matched. Number of Employees are Updated.");
                Allure.addAttachment("Matched. Number of Employees are Updated.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "Matched. Number of Employees are Updated.", true);
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("Not matched. Number of Employees are not Updated.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "Not matched. Number of Employees are not Updated. " + phNo, true);
            Assert.fail("Not matched. An error during the update." + phNo);
            flag = false;
        }
        return flag;
    }

    @Then("^I verify the declaration endorsement to (.*) at index (\\d+)")
    public boolean verifyDeclarationEndorsement(String element, int index) throws InterruptedException {
        System.out.println("Declaration Endorsement: " + " " + randomCiroString);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        object.click();
        String randomCiroString2 = commonLib.getTheItemValueFromAttribute(element, index);
        System.out.println("Declaration Endorsement: " + " " + randomCiroString2);
        boolean flag = false;

        try {
            if (randomCiroString2.equals(randomCiroString)) {
                System.out.println("Matched. Declaration Endorsement is Updated.");
                Allure.addAttachment("Matched. Declaration Endorsement is Updated.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "Matched. Declaration Endorsement is Updated.", true);
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("Not matched. Declaration Endorsement is not Updated.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "Not matched. Declaration Endorsement is not Updated." + phNo, true);
            Assert.fail("Not matched. An error during the update." + phNo);
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
                Allure.addAttachment("The email has been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "I entered the email: " + email, true);
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("The email has not been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
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
        randomCiroString = String.valueOf(randomCiro);
        try {
            if (object != null) {
                object.sendKeys(randomCiroString);
                System.out.println("The random declaration endorsement has been entered :" + randomCiroString);
                Allure.addAttachment("The random declaration endorsement has been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "The random declaration endorsement has been entered: " + randomCiroString, true);
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("The random declaration endorsement has not been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "I cannot entered a random declaration endorsement: " + randomCiroString, true);
            Assert.fail("Could not entered a random declaration endorsement:" + randomCiroString);
            flag = false;
        }
        return flag;
    }

    @Then("^I enter a random number of employees to (.*) at index (\\d+)")
    public boolean randomEmployees(String element, int index) throws InterruptedException {
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;
        Random rnd = new Random();
        int randomEmp = rnd.nextInt(999);
        randomEmployees = String.valueOf(randomEmp);
        try {
            if (object != null) {
                object.sendKeys(randomEmployees);
                System.out.println("The random number of employees has been entered :" + randomEmployees);
                Allure.addAttachment("The random number of employees has been entered", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "The random number of employees has been entered: " + randomEmployees, true);
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("I cannot entered a random number of employees.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "I cannot entered a random number of employees: " + randomEmployees, true);
            Assert.fail("Could not entered a random number of employees:" + randomEmployees);
            flag = false;
        }
        return flag;
    }

    @Then("I go to top of the site")
    public void topOfWebsite() {
        ((JavascriptExecutor) oDriver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
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
                Allure.addAttachment("The text has been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "I entered the text: " + text, true);
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("The text has not been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
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
                    Allure.addAttachment("The area is a read only area. Cannot be editable.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                    reportResult("PASS", "The area is a read only area. Cannot be editable.", true);
                    return true;
                }
            }
        } catch (Exception e) {
            Allure.addAttachment("The area is not a read only area. Can be editable.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "The area is not a read only area. Can be editable.", true);
            Assert.fail("The area is not a read only area. Can be editable.");
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
                Allure.addAttachment("The text has been deleted.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "The text has been deleted.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The text has not been deleted.");
            Allure.addAttachment("The text has not been deleted.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
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
                Allure.addAttachment("The selection is done.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "The selection is done.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The selection cannot be done.");
            Allure.addAttachment("The selection cannot be done.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
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

    @Then("^(?:I )?get the text area information: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean getTextFromAttribute(String element, int index) {
        String object = commonLib.getTheItemValueFromAttribute(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                System.out.println(object);
                Allure.addAttachment("Information gathered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "I got the information:" + object, true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Could not got the information.");
            Allure.addAttachment("Information could not be gathered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "Could not got the information.", true);
            Assert.fail("Could not got the information.");
            flag = false;

        }
        return flag;
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
                Allure.addAttachment("The text has been copied.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "The text has been copied.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The copy action cannot be done.");
            Allure.addAttachment("The copy action cannot be done.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
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
                Allure.addAttachment("The text has been pasted.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "The text has been pasted.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The paste action cannot be done.");
            Allure.addAttachment("The paste action cannot be done.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
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

    @Then("^I enter my tckn text to (.*) at index (\\d+)")
    public boolean dynamicTCKNNumberText(String element, int index) throws InterruptedException {
        String text = object;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        boolean flag = false;

        try {
            if (object != null) {
                object.sendKeys(text);
                System.out.println("The tckn:" + text + " " + "has been entered.");
                Allure.addAttachment("The tckn has been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "The tckn:" + text + " " + "has been entered.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The tckn:" + text + " " + "has not been entered.");
            Allure.addAttachment("The tckn has not been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "The tckn:" + text + " " + "has not been entered.", true);
            Assert.fail("The tckn has not been entered!");
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
                Allure.addAttachment("The pricing no has been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "The Pricing No:" + text + " " + "has not been entered.", true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The Pricing No number:" + text + " " + "has not been entered.");
            Allure.addAttachment("The pricing no has not been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
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
                Allure.addAttachment("Changed the option.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "I changed the option ", false);
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("Could not change the option.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
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
    @Then("I maximize the window")
        public void maximizeTheWindow(){
        oDriver.manage().window().maximize();
        System.out.println("Window maximized");
    }

    @Then("^(?:I )?I need to checkbox verify for (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean verifyCheckbox(String element, int index) {
        String value = commonLib.getTheItemValueFromAttribute(element, index);

        boolean flag = false;
        try {
            if (value.equals("on")) {
                System.out.println("The checkbox is selection state is : on");
                Allure.addAttachment("The checkbox is selection state is : on", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "The checkbox is selection state is : on" + element, true);
                return true;
            }
        } catch (Exception e) {
            System.out.println("The checkbox is selection state is : off");
            Allure.addAttachment("The checkbox is selection state is : off", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "The checkbox is selection state is : off" + element, true);
            Assert.fail("The checkbox is selection state is : off:" + element);
            flag = false;
        }
        return flag;
    }

    @When("^I wait for (\\d+) seconds")
    public void waitForSeconds(int time) throws InterruptedException {
        Thread.sleep(time * 1000);
        Allure.addAttachment("Element seen.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
    }

    @When("^(?:I )?see element: (\\w+(?: \\w+)*) at index (\\d+)")
    public boolean seeElement(String element, int index) {
        WebElement object = commonLib.findElement(element, index);
        boolean flag = false;
        try {
            if (object != null) {
                System.out.println(element + " element seen");
                Allure.addAttachment("Element seen.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "I have seen the element: " + element, true);
                return true;
            }
        } catch (Exception e) {
            reportResult("FAIL", "I can not see the element: " + element, true);
            Allure.addAttachment("Element is not seen.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Assert.fail("Could not see the element:" + element);
            flag = false;
        }
        return flag;
    }

    @When("^(?:I )?switch to window")
    public void switchToChildWindow() throws InterruptedException {
        String MainWindow = oDriver.getWindowHandle();
        int timeCount = 1;
        do {
            oDriver.getWindowHandles();
            Thread.sleep(200);
            timeCount++;
            if (timeCount > 50) {
                break;
            }
        }
        while (oDriver.getWindowHandles().size() == 1);
        Set<String> s1 = oDriver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            //System.out.println(ChildWindow + "******" + driver.getTitle());
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                // Switching to Child window
                oDriver.switchTo().window(ChildWindow);
                Thread.sleep(3000);
                System.out.println("Switched to window ID : " + ChildWindow);
                break;
            }
        }
    }

    @When("I hover click {string} sub element at {string}")
    public void hoverFunction(String subElement, String mainElement) {
        Actions actions = new Actions(oDriver);
        //WebElement mainMenu = commonLib.findElement(mainElement,1);
        WebElement mainMenu = oDriver.findElement(By.linkText("Product"));
        actions.moveToElement(mainMenu);

        //WebElement subMenu = commonLib.findElement(subElement,1);
        WebElement subMenu = oDriver.findElement(By.linkText("Offer Management"));
        actions.moveToElement(subMenu);
        actions.click().build().perform();
        System.out.println("Hover clicked " + subElement + " of " + mainElement);
    }

    @Given("^I switch to frame:([^\"]*) frame type:(name|id|xpath)$")
    public void switchToFrame(String myFrame, String locatorType) throws InterruptedException {
        commonLib.switchToFrame(myFrame, locatorType);
    }

    @Given("^I switch to default content$")
    public void switchToDefault() throws InterruptedException {
        commonLib.switchToDefault();
    }

    @When("I click {string} image element")
    public void sikuliClick(String image) throws FindFailed {
        String filepath = "C:\\Users\\amdocsuakgun\\IdeaProjects\\growth_handsup_icbs_web\\Library\\SikuliImages\\";
        Screen s = new Screen();
        Pattern clickedImage = new Pattern(filepath + image + ".PNG");
        s.click(clickedImage);
    }

    @When("I double click {string} image element")
    public void sikuliDoubleClick(String image) throws FindFailed {
        String filepath = "C:\\Users\\amdocsuakgun\\IdeaProjects\\growth_handsup_icbs_web\\Library\\SikuliImages\\";
        Screen s = new Screen();
        Pattern clickedImage = new Pattern(filepath + image + ".PNG");
        s.doubleClick(clickedImage);
    }

    @Then("I get text box parameters as strings and print them")
    public void getTextBoxParameterAsAStringAndPrintIt() {
        String TesterAdi = System.getenv("Talebi Yapan Tester'ın Adı");
        System.out.println("Otomasyon Talep Eden Tester Adı:" + TesterAdi);
        String UrunAdi = System.getenv("Otomasyon Talebi Hangi Ürün İçin Yapılmaktadır?");
        System.out.println("Otomasyon Talep Edilen Ürün Adı:" + UrunAdi);
        String OtomasyonTuru = System.getenv("Talep Ettiğiniz Otomasyon Türü");
        System.out.println("Talep Edilen Otomasyon Türü:" + OtomasyonTuru);
        String TalepEdilenOtomasyon = System.getenv("Talep Ettiğiniz Otomasyon Nedir?");
        System.out.println("Talep Edilen Otomasyon Açıklaması:" + TalepEdilenOtomasyon);
        Allure.addAttachment(TalepEdilenOtomasyon, OtomasyonTuru);
    }

    @When("I scroll down by 500 unit")
    public void scrollDown() throws InterruptedException {

        JavascriptExecutor jsx = (JavascriptExecutor) oDriver;
        Thread.sleep(5000);
        jsx.executeScript("window.scrollBy(0,500)");
        Thread.sleep(5000);
        System.out.println("Scroll success");

    }

    @When("I do TCKN api call")
    public void getTCKNResponse() {
        allureReport("", "Started TCKN api call.", false);
        try {
            String serviceUrl = "http://satautoat15:64271/kenanconf/tcknsot";
            System.out.println("serviceUrl = " + serviceUrl);

            Response response = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .post(serviceUrl)
                    .then().log().all()
                    .assertThat()
                    .extract().response();
            String responseString = response.getBody().asPrettyString();
            System.out.println("----------------");
            System.out.println(responseString);
            String tckn = StringUtils.substringAfter(responseString, "tckn\": \"");
            tckn = StringUtils.substringBefore(tckn, "\"");
            System.out.println("----------------\n" + tckn);
            TCKNnumber = tckn;
            allureReport("", "Finished TCKN api call.", false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Then("I enter tckn to {string}")
    public boolean enterTckn(String element) throws InterruptedException {
        int index = 1;
        WebElement object;
        object = commonLib.waitElement(element, timeout, index);
        try {
            if (object != null) {
                object.sendKeys(TCKNnumber);
                System.out.println("The text has been entered:" + TCKNnumber);
                Allure.addAttachment("The text has been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                reportResult("PASS", "I entered the text: " + TCKNnumber, true);
                return true;
            }
        } catch (Exception e) {
            Allure.addAttachment("The text has not been entered.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            reportResult("FAIL", "I cannot entered the element: " + TCKNnumber, true);
            Assert.fail("Could not entered the text:" + TCKNnumber);
        }

        return false;
    }


    @When("I click element: {string} if it exists at index {int}")
    public void clickIfExists(String element, int index) {
        try {
            WebElement object = commonLib.findElement(element, index, false);
            if (object != null && object.isDisplayed()) {
                System.out.println(element + " exists.");
                object.click();
                Allure.addAttachment("Element is clicked.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                //reportResult("PASS", "I clicked the element: " + element, true);
            } else {
                System.out.println(element + " does not exist.");
                Allure.addAttachment("Element does not exist.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
                Allure.step("The element does not exist", Status.SKIPPED);
            }
        } catch (Exception e) {
            Allure.addAttachment("Element does not exist.", new ByteArrayInputStream(((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES)));
            Allure.step("The element does not exist", Status.SKIPPED);
        }
    }
    public static Connection dbConnection(String ConnectionType) throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        String dbURL = "";
        String username = "";
        String password = "";

        switch (ConnectionType) {
            case "SBLBGFD":
                allureReport("", "connectionType is SBLBGFD ", false);
                dbURL = "jdbc:oracle:thin:@172.31.70.4:1526:SBLBGFD";
                username = "SIEBEL";
                password = "SBL_dbfx";

                break;
            case "SBLCBUST":
                allureReport("", "connectionType is SBLCBUST ", false);
                dbURL = "jdbc:oracle:thin:@172.31.70.173:1526:SBLCBUST";
                username = "TESTUSER";
                password = "TESTUSER";

                break;
            case "KNNBGFD0":
                allureReport("", "connectionType is KNNBGFD0 ", false);
                dbURL = "jdbc:oracle:thin:@172.31.70.164:1526:KNNBGFD0";
                username = "ARBOR";
                password = "ARBOR";

                break;
            case "KNCBUST0":
                allureReport("", "connectionType is KNCBUST0 ", false);
                dbURL = "jdbc:oracle:thin:@172.31.70.227:1526:KNCBUST0";
                username = "TESTUSER";
                password = "TESTUSER";

                break;
            case "KNCBUST1":
                allureReport("", "connectionType is KNCBUST1 ", false);
                dbURL = "jdbc:oracle:thin:@172.31.70.227:1526:KNCBUST1";
                username = "TESTUSER";
                password = "TESTUSER";

                break;
            case "PPRODDB1":
                allureReport("", "connectionType is PPRODDB1 ", false);
                dbURL = "jdbc:oracle:thin:@172.31.60.134:1521:PPRODDB1";
                username = "CLICK";
                password = "CLICK123*";

                break;
        }


        return DriverManager.getConnection(dbURL, username, password);
    }


    @Then("I execute update sql")
    public void givenIExecuteUpdateSql() throws Exception {
        Connection connection_PPRODDB1 = dbConnection("PPRODDB1");
        String cohSQL = "update click_candidates set is_coh='1' where mnp_msisdn in ('5559981215');\nCOMMIT";
        PreparedStatement statement = connection_PPRODDB1.prepareStatement(cohSQL);
        System.out.println("COH data process done");
    }
}