package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest", // hangilerinde smoke test etiketi varsa o featuraları çalıştırır
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"html:target/site/cucumber-pretty.html"} // PLUGİN NORMALDE YOK , JENKİNS TEN RAPOR ALMAK İÇİN EKLEDİK
)

public class _04_TestRunnerSmoke extends AbstractTestNGCucumberTests {
}
