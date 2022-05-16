package com.project.stepDefinitions;

import com.project.CCSUsageTest;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

import java.io.File;
import java.io.IOException;

import static com.saf.framework.AutomationConstants.filePath;

public class CcsUsage {

    CCSUsageTest ssh2;
    @Before
    public void setReportName() {
        ssh2 = new CCSUsageTest();
    }

    @When("I run sh query for sms check")
    public void runSmsCheck() throws IOException {
        File dirPath = new File(filePath);
        String selectedFile= CCSUsageTest.findTemplateFile(dirPath);
        CCSUsageTest.readTemplateExcel(filePath+selectedFile);
        CCSUsageTest.createAndWriteToExcel(selectedFile);
        CCSUsageTest.moveTemplateFile(selectedFile);
    }
}