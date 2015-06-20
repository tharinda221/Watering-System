package login;


import java.sql.*;
import java.util.*;


public class ConnectionManager {

    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/wateringsystem";

    static String USER = "root";
    static String PASS = "";
    static Connection conn = null;

    public static Connection getConnection()
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            try
            {
                if(conn == null)
                    conn = DriverManager.getConnection(DB_URL,USER,PASS);
                System.out.println("connected");

                // assuming your SQL Server's	username is "username"
                // and password is "password"

            }

            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }

        return conn;
    }

}
