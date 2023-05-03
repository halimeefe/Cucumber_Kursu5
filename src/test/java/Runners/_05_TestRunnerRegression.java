package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@Regression and @SmokeTest",    // ARAYA OR YAZARSAK REGRESSİON YADA SMOKE TESTİ ÇALIŞTIR
                                               //ARALARINA AND KOYARSAK İKİ ETİKETLİ OLAN SENARYOLARI ÇALIŞTIRIR
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitios"}
)
public class _05_TestRunnerRegression extends AbstractTestNGCucumberTests {

}
