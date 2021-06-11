package com.project.tests;


//extends AbstractTestNGCucumberTests

import com.saf.framework.MyTestNGBaseClass;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



@CucumberOptions(

        features = "src/test/features/WorkflowManagement.feature",
        // tags="@JiraScenarioKey1, @JiraScenarioKey2, @Payment",
         tags="@Payment",
        glue = {"com.project.stepdefs"})

public class TestRunner extends MyTestNGBaseClass {
    private TestNGCucumberRunner testNGCucumberRunner;

    //String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {

        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}
