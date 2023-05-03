package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import com.mongodb.DB;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _11_JDBCSteps {


    @Then("Send The query the database {string} and control match")
    public void sendTheQueryTheDataaseAndControlMatch(String sorgu) {

        // DB DEN GEREKLİ BİLGİLERİ ALALIM
        ArrayList<ArrayList < String >> dbList = DBUtility.getListData(sorgu);

        //UI dan gerekli bilgileri alalım
        DialogContent dc=new DialogContent();
        List<WebElement> UIList= dc.nameList;


        for (int i = 0; i < dbList.size(); i++) {
            System.out.print(dbList.get(i).get(1).trim());  // 0->1  1: ümraniye -- burası list olduğu için o dan başlıyor
            System.out.println("\t"+UIList.get(i).getText().trim());

//            Assert.assertEquals(
//                    dbList.get(i).get(1).trim(), // BURADA ARADIĞIMIZ DATA YI DOĞRULUYORUZ,DATA BASE DE HATALI İSE DEFECT REPORT OLUŞTURURUZ
//                    UIList.get(i).getText().trim());
//



        }

        // TODO: DB den Actor tablosunu okuyarak, bir excele yazdırınız.

//        1- Algoritma
//        2- Java
//        3- GitHub
//        3- Selenium Web Driver  (UI Testing)  kütüphane
//        4- TestNG               (UI Testing)  test Organizatörü-tool
//        5- Cucumber             (UI Testing)  test tool
//        6- ApachePOI
//        7- MySql Workbench (DB Manuel Testing) program
//        8- JDBC            (DB Automation Testing) kütüphane
//
//                -----
//                9- Postman     (API Manuel Testing) 3-4
//        10-RestAssured (API Automation Testing) 5-6
//
//        11-Jenkins Testleri ototmatik zamanlı çalış. (düzenlendi)
//

    }
}
