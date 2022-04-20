package com.project.stepdef2;

import com.project.stepdefs.CCS_Usage_Test;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

import java.io.File;
import java.io.IOException;

public class shDefinitions {
    static String filePath = "\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\";
    CCS_Usage_Test ssh2;
    @Before
    public void setReportName() {
        ssh2 = new CCS_Usage_Test();
    }

    @When("I run sh query for sms check")
    public void runSmsCheck() throws IOException {
        File dirPath = new File(filePath);
        String selectedFile= CCS_Usage_Test.findTemplateFile(dirPath);
        CCS_Usage_Test.readTemplateExcel(filePath+selectedFile);
        CCS_Usage_Test.createAndWriteToExcel(selectedFile);
        CCS_Usage_Test.moveTemplateFile(selectedFile);
    }
}