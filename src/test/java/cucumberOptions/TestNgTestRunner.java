package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/features",
        glue = "stepDefinitions",
        tags = "@DashBoardRun",
        monochrome = true,
        plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenario.txt",
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",


        })
public class TestNgTestRunner extends AbstractTestNGCucumberTests {
//    //tags = "@ApplicationsRun"
//    @Override
//    @DataProvider(parallel = false)
//    public Object[][] scenarios() {
//        return super.scenarios();
//      "junit:target/cucumber-reports/cucumber.xml",
//              "usage:target/cucumber-reports/usage.json",
//              "testng:target/cucumber-reports/cucumber-testng.xml",
//              "tech.grasshopper.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//
}

