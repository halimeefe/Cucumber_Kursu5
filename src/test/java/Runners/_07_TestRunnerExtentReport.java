package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Smoke",   // HANGİ SENARYOLARDA BU ETİKET VARSA ONLAR ÇALIŞTIRILACAK SMOKE YADA REGRESSİON
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)

public class _07_TestRunnerExtentReport extends AbstractTestNGCucumberTests {
}
