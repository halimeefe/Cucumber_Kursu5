package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature"}, // buraya feature files ın path i verilecek.
        glue = {"StepDefinitions"}   // Step definitions ın klasörü yazılıyor.
)
public class _01_TestRunner extends AbstractTestNGCucumberTests { // ABSTARCT CLASS POM XML DE EKLEDİĞİMİZ CUCUMBER-TESTNG DEN ALDIĞIMIZ YANİ EXTENDE EETİĞİMİZ BİR CLASS
}                                                                 // BÖYLECE ÇALIŞMA ÖZELLİĞİ KAZANDI
                                                                 //DAHA SONRA EN BAŞINA CUCUMBEROPTİONS ANATOİTATİON EKLEDİK
                                                                 //PARANTAZİN  İÇİNE ÇALIŞTIRILCAK FEATURLAR VE GLUE 'YADA STEPLERİMİZİ YAZARIZ
                                                                //LOGİN CLASÖRÜNE SAĞ TUŞ COPYPATH YAPTIK VE CONTENT ROOT TIKLAYIP FEATURA YAPIŞTIRDIK
                                                                //HANGİ CLASÖR ÇALIŞCAKSA ONUN PATHİNİ VERİRİZ