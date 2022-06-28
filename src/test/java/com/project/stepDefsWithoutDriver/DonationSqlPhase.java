package com.project.stepDefsWithoutDriver;

import com.project.DonationAutomation;
import io.cucumber.java.en.When;

public class DonationSqlPhase extends DonationAutomation{

    @When("I create sql outputs from excel")
    public static void run() throws Exception {
        attendVariablesFromExcel("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Conf\\BAGIS-001_CBU_Donation_Kenan_Template.xlsx");
        findTemplateFile(folderpath);
    }
}