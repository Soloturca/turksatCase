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
    public void clickElement(String element,int index) {
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
    public void uniqueText(String element,int index) throws InterruptedException {
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
    public void waitElement(String element, int timeout,int index) throws InterruptedException {
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
    public void getTheReferenceNumber(String element ,int index) {
                String object = commonLib.getTheElementInformation(element, index);
    }
    @Then("^(?:I )?get the information by copying the value from: (\\w+(?: \\w+)*) at index (\\d+)")
    public void copyElement (String element, int index) throws InterruptedException {
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
    public void pasteElement (String element, int index) throws InterruptedException {
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


    @Then("^I enter my \"([^\"]*)\" text to (.*)$")
    public void dynamicText(String text, String element) throws InterruptedException {
        text = commonLib.referenceNumber;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, 1);
    }

    @Then("^(?:I )?get the Item Value: (\\w+(?: \\w+)*) at index (\\d+)")
    public void getTheItemValue(String element, int index) {
        String object = commonLib.getTheElementInformation2(element, index);
    }

    @Then("^I changed the \"([^\"]*)\" selection under (.*)$")
    public void oppositeSituation(String text, String element) throws InterruptedException {
        text = commonLib.positiveornegative;
        System.out.println(text);
        WebElement object;
        object = commonLib.waitElement(element, timeout, 1);
        object.click();
        Select select = new Select(object);

        try {
            if (object != null) {
                if(text=="POZİTİF") {
                    text = "NEGATİF";
                    select.selectByVisibleText(text);
                }

                else if (text=="NEGATİF") {
                    text= "POZİTİF";
                    select.selectByVisibleText(text);
                }

                System.out.println("The situation returned to:" + text + " " + "successfully.");
                reportResult("PASS", "The opposite of the item value is taken. ", false);
            }
        } catch (Exception e) {
            reportResult("FAIL", "The opposite of the item value is not taken. ", true);
        }
    }
}