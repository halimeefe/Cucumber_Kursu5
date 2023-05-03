package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class _05_DataTableOrnekSteps {



    @When("Write username {string}")
        public void writeUsername(String userName) {
            System.out.println("userName = " + userName);
        }

        @And("Write username and Password {string} and {string}")
        public void writeUsernameAndPasswordAnd(String userName, String password) {
            System.out.println("userName and pass = " + userName+" "+password);
        }


        @And("Write username as DataTable")  // DATA TABLE DEKİ DEĞERLERİ TOPLUCA ALMAK İÇİN LİST KULLANIRIZ ÖNCE LİSTE DÖÜŞTÜRÜP SONRA FOREACH İLE ALIRIZ
        public void writeUsernameAsDataTable(DataTable elemanlar) {
            List<String> listElemanlar=elemanlar.asList(String.class);

            for(String u: listElemanlar)
                System.out.println("u = " + u);
        }

        @And("Write username and password as DataTable")
        public void writeUsernameAndPasswordAsDataTable(DataTable elemanlar) {
            List< List<String> > listElemanlar= elemanlar.asLists(String.class);  // İKİ SIRALI DATATABLE İÇİN LİSTİN LİSTİNİ ALIRIZ

            for (int i = 0; i < listElemanlar.size(); i++) {
                System.out.println("listElemanlar = " +
                        listElemanlar.get(i).get(0)+" "+ //username //0,SATIRIN 0,ELEMANI
                        listElemanlar.get(i).get(1) );   // password  // 0. SATIRIN 1.ELEMANI
                       //listElemanlar.get(i).get(2)  // 3 SIRALI OLSAYDI BU ŞEKİLDE DEVAM EDERDİ
            }

        }







}
