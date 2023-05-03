package _JDBC.Gun1;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Intro {

    // 1- bağlantı bilgilerini girdik ve bağlandık
//2- sorguların çalıştırılacağı ortamı açtık
//3- sorguyu 2 nolu ortam üzerinde çalıştırdık
//4- sonuçları gördük


    @Test
    public void test1() throws SQLException {


        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        Connection connection = DriverManager.getConnection(hostUrl,username,password); //bağlantıyı click yaptık

        Statement statement=connection.createStatement();// sorguları çalıştırmak için sorgu gönderme ortamı

        ResultSet rs= statement.executeQuery("select * from customer");// sorgu çalıştı , sonuçlar rs de

//        ilk satırımı istiyorsun , son satırı mı ,beşinci satırı mı
        rs.next(); // sıradaki datayı veriyor yani ilk sıra

      String firstname=  rs.getString("first_name");
        String lastname=rs.getString("last_name");
        System.out.println("1. satırın müşteri adı ve soyadı:"+ firstname+" "+lastname);
        rs.next(); // 2. satıra

        firstname=rs.getString("first_name");
        lastname=rs.getString("last_name");
        System.out.println("2.satırın müşteri adı ve soyadı :"+firstname+" "+lastname);

        connection.close();// hafızayı temizlemek için sonunda close yaparız






    }
}
