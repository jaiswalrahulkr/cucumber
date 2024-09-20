package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Date;


@CucumberOptions(
        features = "src/test/java/features",             // Path to feature files
        glue = {"stepdefinition"}, // Package with step definitions
        dryRun = true,                                       // Check if all steps have definitions
        plugin = {
                "pretty",                                         // For readable console output
                "html:target/cucumber-reports.html",              // HTML report output
                "json:target/cucumber.json",                      // JSON report output
                "junit:target/cucumber.xml"                       // JUnit XML report output
        },
        monochrome = true,                                    // Cleaner console output
        tags = "@textBox"
        // Running scenarios based on tags
)
public class regressionRunner extends AbstractTestNGCucumberTests {

    private static TestNGCucumberRunner testRunner;
    static String timeStamp;

    @BeforeSuite
    public void setUp() {
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        testRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterSuite
    public void tearDown() {

        testRunner.finish();

    }
}
