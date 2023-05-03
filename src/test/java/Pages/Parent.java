package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {


    // PARENT CLASS TA BİZİM HER  RUN YAPTIĞIMIZDA ÇALIŞMASI GEREKEN FONKSİYONLAR YER ALIR


    WebDriverWait wait=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));

    public  void sendKeysFunction(WebElement element, String yazi)
    {
        waitUntilVisible(element); // GÖZÜKENE KADAR BEKLE
        scrollToElement(element);  // SCROLL YAP
        element.clear();          //TEMİZLE
        element.sendKeys(yazi);    // YAZIYI GÖNDER
    }
    public void clickFunction(WebElement element){
        waitUntilClickable(element);
        scrollToElement(element);
      //  element.click();
        JavascriptExecutor js=(JavascriptExecutor)GWD.getDriver();
        js.executeScript("arguments[0].click();",element);


    }

    public void verifyContainsTextFunction(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()), "NO Such Text");
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform(); // SİTEDE AÇIK KALAN KUTUCUKLARI KAPATMAK İÇİN FONKSİYON ,AÇIK DİYALOG KUTUSUNU KAPATIR
        // açık dialog kutusu varsa kapansın                          // BÖYLECE ALTTA KALAN SAVE YADA SEARCH GİBİ BUTONLARA TIKLAYABİLİR
    }


    public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);  //DEFAULT TRUE ,ELEMENTİ SAYFANIN ÜSTÜNDE ARAR
    }

    public void waitUntilVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }  //WAİTLERİ FONKSİYON HALİNE GETİRDİK

    public void waitUntilClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }//WAİT UNTİL CLİKABLE FONKSİYON HALİNE GELDİ


//     public void selectElementFromDropdown(WebElement dropdown,String element){ //
//         Select slc=new Select(dropdown); // buraya mesela ülkeler yazılcak
//         slc.selectByIndex(2); // fransa yazıcaz örneğin
     }



















