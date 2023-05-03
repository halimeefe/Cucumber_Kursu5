package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "SmokeTest",   // HANGİ SENARYOLARDA BU ETİKET VARSA ONLAR ÇALIŞTIRILACAK
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        plugin = {"html:target/site/cucumber-pretty.html"} // BASİT RAPOR,BASEC RAPOR ,BURAYI ÇALIŞTIRDIĞIMIZ ZAMAN SOLDA TARGETIN ALTINA SİTE GELİR
)                                                          // SİTENİN İÇİNDE CUCUMBER.PRETTY OLUŞUR

public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
