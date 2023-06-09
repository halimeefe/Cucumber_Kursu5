package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {


      String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

      FileInputStream inputStream=new FileInputStream(path);
      Workbook workbook= WorkbookFactory.create(inputStream);
      Sheet sheet=workbook.getSheetAt(0);


       // 1.YOL
      // calisma sayfasındaki fiziksel kullanılan toplam satır sayısını veriyor.
      int rowCount=sheet.getPhysicalNumberOfRows(); // zoo.length TOPLLAM KAÇ SATIR OLDUĞUNU VERİYOR BİZE

      for (int i = 0; i < rowCount; i++) {  // HER BİR SATIRDAKİ HÜCREYİ ALDIK

          Row row=sheet.getRow(i);
          int cellCount=row.getPhysicalNumberOfCells();// zoo[i].length  YANA DOĞRU KAÇ SATIR VARSA ONU VERİYOR

          for (int j = 0; j < cellCount; j++) {
              Cell cell=row.getCell(j);
              System.out.print(cell+"\t");
          }

          System.out.println();
      }

       // 2.YOL
        System.out.println("**********************");
        //2.Yol
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) { // zoo.length

            for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) { // zoo[i].length
                System.out.print(sheet.getRow(i).getCell(j)+"\t"); // zoo[i][j] , get(i).get(j)
            }

            System.out.println();
        }

    }
}
