package com.project.stepDefsWithoutDriver;

import com.project.DonationAutomation;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

public class Donation extends DonationAutomation{

    Donation donation;
    @Before
    public void setReportName() {
        donation = new Donation();
    }

    @When("I run donation automation")
    public static void run() throws Exception {
        DonationAutomation.excelFileName = DonationAutomation.findExcel(DonationAutomation.excelPath);
        DonationAutomation.infoGathering();
        DonationAutomation.excelList();
        DonationAutomation.createExcel(DonationAutomation.excelFileName);
        DonationAutomation.findTemplateFile(DonationAutomation.folderpath);
    }
}