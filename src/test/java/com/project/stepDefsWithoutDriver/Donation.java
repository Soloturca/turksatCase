package com.project.stepDefsWithoutDriver;

import com.project.DonationAutomation;
import io.cucumber.java.en.When;

public class Donation extends DonationAutomation{

    @When("I create template excel for donation")
    public static void run() throws Exception {
        excelFileName = findExcel(excelPath);
        infoGathering();
        excelList();
        createExcel(excelFileName);
    }
}