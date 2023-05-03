package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class _01_GetAllRowColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language");

        ResultSetMetaData rsmd = rs.getMetaData(); // kolon sayısı ,isimleri ,tipleri

        int columnCount = rsmd.getColumnCount();  // column sayılarını aldık index gibi o dan başlamaz 1 den başlar
        System.out.println("columnCount" + columnCount);

        for (int i = 1; i <= columnCount; i++) {
            System.out.print("column name : " + rsmd.getColumnName(i)); // HER COLUMNUN NAME İNİ  ALDIK
            System.out.println("\tcolumn tipi :" + rsmd.getColumnTypeName(i));  // TYPE NAME İ YAZDIRDIK - type tablodaki sıralamayı verir


        }
    }
        @Test
        public void test2() throws SQLException {

            // language tablosundaki tüm satırları ve tüm sutunları yazdırınız
            // aynı mysql sonuç  ekranında olduğu gibi YANYANA

            ResultSet rs = statement.executeQuery("select * from language"); // data + meta
            ResultSetMetaData rsmdt = rs.getMetaData();// data dışındaki bilgileri : kolon sayısı , ismi , tipleri


            for (int i = 1; i <=rsmdt.getColumnCount(); i++) { // bu kısım başlıkları
                System.out.print( rsmdt.getColumnName(i)+"\t");

            }
            System.out.println();
            while (rs.next())
            {
                for (int i = 1; i <= rsmdt.getColumnCount() ; i++) {
                    System.out.print(rs.getString(i)+"\t");

                }
                System.out.println();
            }

        }
        @Test
    public void test3() {
            // bir metoda sorguyu (select * from language )gönderiniz , metod size sorgunun datasını
            // bir arraylist olarak döndürsün

            String sql = "select * from city";  // burada city yerine ne yazarsak onun datalarına ulaşırız
            ArrayList<ArrayList<String>> donenSonuc = getListData(sql);
            System.out.println("dönen Sonuç " + donenSonuc);

        }
        public ArrayList<ArrayList<String>> getListData(String sql){
        ArrayList<ArrayList<String>> tablo =new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ArrayList<String> satir = new ArrayList<>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    satir.add(rs.getString(i));


                }
                tablo.add(satir);

            }


        }
        catch (Exception e) {
            System.out.println("e.getmessage:"+e.getMessage());
        }
        return tablo;


        }
    }


