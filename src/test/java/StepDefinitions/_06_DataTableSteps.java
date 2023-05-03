package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

    public class _06_DataTableSteps {
    LeftNav ln=new LeftNav();
        DialogContent dc=new DialogContent();
        @And("Click on the element in LeftNav")
        public void clickOnTheElementInLeftNav(DataTable items) {  //DATATABLE PARAMETRELERİNİ YİNE LİSTE ATTIK VE FOREACH İLE ALDIK
            List<String> strButtons=items.asList(String.class);

            for (String strButton: strButtons) {
                WebElement element=ln.getWebElement(strButton); // webelemnti bul //BİZ STRİNG HALİNİ VERDİK VE WEBELEMENT HALİNİ ALDIK
                ln.clickFunction(element); // webelemente tıklat
            }
        }

        @And("Click on the element in Dialog")
        public void clickOnTheElementInDialog(DataTable dt) {
            List<String> strButtons=dt.asList(String.class);

            for (String strButton: strButtons) {
                WebElement element=dc.getWebElement(strButton); // webelemnti bul
                dc.clickFunction(element); // webelemente tıklat
            }
        }


        @And("User sending the keys in Dialog Content")
        public void userSendingTheKeysInDialogContent(DataTable dt) {
            List< List<String> > items= dt.asLists(String.class);  //  2 li data göndermede webelement ve value ları liste attık
                                                                   //1.hane webelement 2.si value
            for (int i = 0; i < items.size(); i++) {               //1.haneyi web elemente çevirdik ve yazı gönderdik,sendkeys yaptık
                WebElement element= dc.getWebElement(items.get(i).get(0)); // listin listi olduğu için bu şekilde for döngüsüyle kaç sıra olduğunun bir önemi olmaz
                dc.sendKeysFunction(element, items.get(i).get(1));
            }
        }
        @And("User delete item from Dialog Content")
        public void userDeleteItemFromDialogContent(DataTable dt) {
            List<String> strButtons=dt.asList(String.class);

            for (String strDeleteText : strButtons) {  // BURAYA GÖNDERDİĞİMİZ TEXTİ SİLDİĞİMİZ İÇİN WEB ELEMENTE ÇEVİRMEYE GEREK KALMADI
                dc.deleteItem(strDeleteText);         // FUNCTİON ,SENDKEYS YADA BUTTON OLSAYDI WEB ELEMENTE ÇEVİRMELİYDİK
            }
        }


    }













