package WateringSystem;

import java.sql.*;

public class DataHandle {

    static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost/wateringsystem";

    static String USER = "root"; //replace this with your registration number
    static String PASS = "";
    static Connection conn = null;

    public DataHandle() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        if(conn == null)
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("connected");
    }

    public void updateOnlineData(String username, String temp,String moisture,String raining) {

        try {

            String sql = "UPDATE onlinedata SET temperature=?,moisture=?,raining=? where username=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,temp);
            stmt.setString(2, moisture);
            stmt.setString(3,raining);
            stmt.setString(4,username);
            stmt.executeUpdate();
            System.out.println("updated");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

    public void insertOnlineData(String username, String temp,String moisture,String raining) {

        try {
            String sql = "INSERT into onlinedata (username,temperature,moisture,raining) values (?,?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,temp);
            stmt.setString(3, moisture);
            stmt.setString(4,raining);
            stmt.executeUpdate();
            System.out.println("inserted");
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

    public boolean checkUser(String username) {

        try {
            String sql = "SELECT username FROM onlinedata WHERE username=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            ResultSet rs = stmt.executeQuery();

            if(rs.next())
                return true;
            else
                return false;
        }
        catch(Exception ex) {
            return false;
        }
    }

}
