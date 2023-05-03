package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelUtility {


    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int colCnt) { // FONKSİYONU BURADA HAZIRLADIK
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();


        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);// FONKSİYON OLARAK HAZIRLADIK HER YERDEN KULLNAMAK İÇİN BU YÜZDEN TRY CATCH İÇİNE ALDIK
            Workbook workbook = WorkbookFactory.create(inputStream);  // FONKSİYONA GEREK OLMASAYDI METHOD SİGNATURE YAPABİLİRDİK
            sheet = workbook.getSheet(sheetName);

        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  // KAÇ SATIR VARSA HEPSİNİ VER    // ZOO.LENGHT
            ArrayList<String> satir = new ArrayList<>();  // BİR TANE ARRAYLİST HAZIRLADIK TABLO İÇİN O SATIRI DOLDURUP SONRA TABLOYA EKLİYORUZ
            for (int j = 0; j < colCnt; j++) {      //HER SATIRDAKİ İSTENEN KADAR AL
                satir.add(sheet.getRow(i).getCell(j).toString());  // BURADA TO STRİNG LE SIRALIYORUZ
            }

            tablo.add(satir); // TABLOYA EKLEDİK
        }

        return tablo; // VE DÖNDÜRDÜK
    }



    public static void writeExcel(String path, Scenario senaryo, String browserName) {
        //BURADA HER BİR SENARYONUN SONUCU EXCELE YAZILACAK

        File file=new File(path);

        // EĞER DOSYA YOKSA AŞAĞIDAKİ BÖLÜM ÇALIŞSIN
        if (!file.exists()){ // dosya yok ise
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("campusTest");

            Row yeniSatir = sheet.createRow(0);

            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue(senaryo.getName());

            yeniHucre = yeniSatir.createCell(1);
            yeniHucre.setCellValue(senaryo.getStatus().toString()); // fail veya pass

            yeniHucre = yeniSatir.createCell(2);
            yeniHucre.setCellValue(browserName);

            //file save
            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception e) {

            }
        }
        else{   // EĞER DOSYA VAR İSE

            Sheet sheet=null;
            Workbook workbook =null;
            FileInputStream inputStream=null;
            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheet("campusTest");
            }catch(Exception e){
            }

            Row yeniSatir = sheet.createRow( sheet.getPhysicalNumberOfRows() );  // EN ALT BOŞ SATIRI AÇ

            Cell yeniHucre = yeniSatir.createCell(0);
            yeniHucre.setCellValue(senaryo.getName());

            yeniHucre = yeniSatir.createCell(1);
            yeniHucre.setCellValue(senaryo.getStatus().toString());  // FAİL VEYA PASS

            yeniHucre = yeniSatir.createCell(2);
            yeniHucre.setCellValue(browserName);

            //file save
            try {
                inputStream.close(); // okuma modu kapatıldı
                FileOutputStream outputStream = new FileOutputStream(path); // yazma moduna geçildi
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception e) {

            }

        }


    }



}













