package ApachePOI;

/**
 * Kullanıcıdan istediği kolon sayısını aldıktan sonra
 * aşağıdaki excelin 2.Sheet inden istediği kadar kolon miktarını alarak
 * bir fonksyonda ArrayListe çevirerek mainden yazdırınız.
 * src/test/java/ApachePOI/resource/ApacheExcel2.xlsx
 */

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class _09_Tasks {
    public static void main(String[] args) {
        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx"; // DOSYA YOLUNU VERDİK
        String sheetName="testCitizen";


        System.out.print("İstediğiniz sütun sayısı=");
        Scanner oku=new Scanner(System.in);
        int columnCnt=oku.nextInt();

        ArrayList<ArrayList<String>> donenSonuc=getData(path,sheetName,columnCnt);  // String[][]  2 BOYUTLU ARRAYLİST APTIK
        System.out.println("donenSonuc = " + donenSonuc);
    }


    public static ArrayList< ArrayList<String> > getData(String path,String sheetName,int colCnt){ // FONKSİYONU BURADA HAZIRLADIK
        ArrayList< ArrayList<String> > tablo=new ArrayList<>();



        Sheet sheet =null;
        try {
            FileInputStream inputStream = new FileInputStream(path);// FONKSİYON OLARAK HAZIRLADIK HER YERDEN KULLNAMAK İÇİN BU YÜZDEN TRY CATCH İÇİNE ALDIK
            Workbook workbook = WorkbookFactory.create(inputStream);  // FONKSİYONA GEREK OLMASAYDI METHOD SİGNATURE YAPABİLİRDİK
            sheet = workbook.getSheet(sheetName);
        }
        catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  // KAÇ SATIR VARSA HEPSİNİ VER
            ArrayList<String> satir=new ArrayList<>();  // BİR TANE ARRAYLİST HAZIRLADIK TABLO İÇİN O SATIRI DOLDURUP SONRA TABLOYA EKLİYORUZ
            for (int j = 0; j < colCnt; j++) {      //HER SATIRDAKİ İSTENEN KADAR AL
                satir.add(sheet.getRow(i).getCell(j).toString());  // BURADA TO STRİNG LE SIRALIYORUZ
            }

            tablo.add(satir); // TABLOYA EKLEDİK
        }

        return tablo; // VE DÖNDÜRDÜK
    }

}

