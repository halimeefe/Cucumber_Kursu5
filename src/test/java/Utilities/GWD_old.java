package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GWD_old {

    private static WebDriver driver;  // DRİVERI BURDAN ÇAĞIRIYORUZ,TANIMLADIK //  STEPSLER DEN ÇAĞIRIRKEN DRİVER DEĞİL GET DRİVER GÖZÜKSÜN KARIŞIKLIK OLMASIN DİYE PRİVATE YAPTIK

        public static WebDriver getDriver() { // DERİVERI BAŞLATMA METHODU

            Locale.setDefault(new Locale("EN")); // TÜRKÇE BİLGİSAYARLAR İÇİN DRİVERIMIZI İNGİLİZCE AYARLARI YAPTIK
            System.setProperty("user.language", "EN");// ÇÜNKÜ EXTEND REPORT TA TÜRKÇE BİLGİ ÇALIŞMIYOR

            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.SEVERE);
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

            if (driver == null) { //EĞER DRİVER NULL SE ÇALIŞAN BİR DRİVER YOKSA ANLAMINDA YOKSA TEKRAR DRİVER OLUŞTUR VARSA AYNI DRİVERDAN DEVAM ET DEMEK
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");   // BURADA İNİTİALİZE  YAPTIK
                driver = new ChromeDriver(options);
            }
            return driver;   // DİĞER CLASLARDAN EXTEND YAPMADIĞIMIZ İÇİN  RETURN YAPTIK
        }
        public static void quitDriver(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (driver != null) {  // DOLU İSE BOŞ DEĞİLSE HALA ÇALIŞAN BİR DRİVERIM VARSA
                //  driver.quit(); //KAPAT VE
                driver=null; // DRİVERI 0 A EŞİTLE, NULL OLSUN
            }
        }
    }

















