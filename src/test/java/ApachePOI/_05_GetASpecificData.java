package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.Scanner;

public class _05_GetASpecificData {

    public static void main(String[] args) {

        /**
         * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
         * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
         * yani metoda "Password" kelimesi gönderilecek, dönen değer Password un değeri olacak.
         * bulup ve sonucun döndürülmesi için metod kullanınız.
         * src/test/java/ApachePOI/resources/LoginData.xlsx
         */
               System.out.print("Aranacak kelimeyi giriniz=");
                Scanner oku = new Scanner(System.in);
                String arananKelime = oku.next();

                String donenSonuc = exceldenBul(arananKelime);
                System.out.println("donenSonuc = " + donenSonuc);
            }

            public static String exceldenBul(String aranan) {
                String donecek = "";
                //excelden okuma işlemleri
                String path = "src/test/java/ApachePOI/resource/LoginData.xlsx";

                Sheet sheet = null;
                try {
                    FileInputStream inputStream = new FileInputStream(path);
                    Workbook workbook = WorkbookFactory.create(inputStream);
                    sheet = workbook.getSheetAt(0);

                } catch (Exception e) {
                }

                for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

                    if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(aranan)) {  // 0. HÜCRE BENİM ARADIĞIM KELİMEYE EŞİT Mİ

                        for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) { // ONLARI DÖNECEK İSİMLİ YERE AT VE GÖNDER
                            donecek += sheet.getRow(i).getCell(j) + " ";
                        }
                    }
                }

                return donecek;
            }
        }


















