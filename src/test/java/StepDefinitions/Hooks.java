package StepDefinitions;

import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @After  // HER SENARYODAN SONRA ÇALIŞACAK BÖLÜM
    public void after(Scenario senaryo) { // SENARYO HATALI AYNİ FAİL İSE PARANTEZİN İÇİNE TANIMLARIZ VE İF KOŞULU İLE EKRAN GÖRÜNTÜSÜ İSTEYEBİLİRİZ
        System.out.println("Senaryo bitti");

        ExcelUtility.writeExcel("src/test/java/ApachePOI/resource/ScenarioStatus.xlsx", // BURAYA LOCAL DATE EKLEYEREK HER GÜNÜ AYRI ALABİLİRİZ
                senaryo, GWD.threadBrowserGet());


        //EXTEND REPORTTA ÇALIŞAN KISMI KAPATTIK EXCEL RAPORUNU ALMAK İÇİN
        if (senaryo.isFailed()) {
//            TakesScreenshot ts = (TakesScreenshot) GWD.getDriver();
//            final byte[] hafizadakiHali = ts.getScreenshotAs(OutputType.BYTES);
//            senaryo.attach(hafizadakiHali, "image/png", "screenshot name");
        }

       // GWD.quitDriver();

    }
}






