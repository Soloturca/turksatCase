package com.project.stepDefinitions;

import com.project.DonationAutomation;
import cucumber.api.java.en.When;

import static com.saf.framework.AutomationConstants.*;

public class Donation {


    @When("I run donation automation")
    public static void run() throws Exception {
        excelFileName = DonationAutomation.findExcel(excelPath);
        DonationAutomation.infoGathering();
        DonationAutomation.excelList();
        DonationAutomation.createExcel(excelFileName);
        DonationAutomation.findTemplateFile(folderpath);
    }
}
