package com.project.stepDefinitions;

import com.project.DonationAutomation;
import cucumber.api.java.en.When;

import java.io.File;

public class Donation {

    static File excelPath = new File("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Template\\");
    static String excelFileName = " ";
    static File folderpath = new File("\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\Kenan_Template\\CBU_BAGIS_Kampanyasi_Kenan\\");

    @When("I run donation automation")
    public static void run() throws Exception {
        excelFileName = DonationAutomation.findExcel(excelPath);
        DonationAutomation.infoGathering();
        DonationAutomation.excelList();
        DonationAutomation.createExcel(excelFileName);
        DonationAutomation.findTemplateFile(folderpath);
    }
}
