package com.project.tests;


//extends AbstractTestNGCucumberTests

import com.google.common.io.Files;
import com.saf.framework.CommonLib;
import com.saf.framework.MyTestNGBaseClass;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.testng.*;


import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import org.apiguardian.api.API;
import org.apiguardian.api.API.Status;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;


@CucumberOptions(
        features = "src/test/features/newFeatures/",
        // tags="@JiraScenarioKey1, @JiraScenarioKey2, @Payment",
        tags = "@Test",
        glue = {"com.project.stepdefs"})

public class TestRunner extends MyTestNGBaseClass {

    @API(
            status = Status.STABLE
    )
    private io.cucumber.testng.TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(
            alwaysRun = true
    )
    public void setUpClass() {
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(

            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios"
    )
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickleEvent());

    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver oDriver) {
        return ((TakesScreenshot) oDriver).getScreenshotAs(OutputType.BYTES);
    }

    @DataProvider
    public Object[][] scenarios() {
        return this.testNGCucumberRunner == null ? new Object[0][0] : this.testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(
            alwaysRun = true

    )
    public void tearDownClass() {

        if (this.testNGCucumberRunner != null) {
            this.testNGCucumberRunner.finish();
        }
    }

}
