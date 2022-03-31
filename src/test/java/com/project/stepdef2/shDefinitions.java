package com.project.stepdef2;

import com.project.stepdefs.SSH2;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

import java.io.File;
import java.io.IOException;

public class shDefinitions {
    static String filePath = "\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\";
    SSH2 ssh2;
    @Before
    public void setReportName() {
        ssh2 = new SSH2();
    }

    @When("I run sh query for sms check")
    public void runSmsCheck() throws IOException {
        File dirPath = new File(filePath);
        String selectedFile=ssh2.findTemplateFile(dirPath);
        ssh2.readCheckSms(filePath+selectedFile);
        ssh2.createAndWriteToExcel(selectedFile);
        ssh2.moveTemplateFile(selectedFile);
    }
}
