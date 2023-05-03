package _JDBC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.*;

public class JDBCParent {

   public static Connection connection;
    public static Statement statement;


    @BeforeClass
    public void DBConnectionOpen()
    {

        String hostUrl = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

    try {
         connection = DriverManager.getConnection(hostUrl, username, password); //bağlantıyı click yaptık
        statement = connection.createStatement();// sorguları çalıştırmak için sorgu gönderme ortamı

    }catch(Exception e)
    {
        System.out.println(e.getMessage());
    }


    }

    @AfterClass
    public  void DBConnection(){
        try {
            connection.close();

        }catch (SQLException e){
            throw new RuntimeException(e);

        }


    }
}







