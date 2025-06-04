package HotelManagement;

import java.sql.*;

public class DBConnection {

    Connection conn=null;
    Statement st;

    public DBConnection(){

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn= DriverManager.getConnection("jdbc:oracle:thin:@//Aditya/xe","hotelmanagement","hotelmanagement");
            System.out.println("db connected");
            st= conn.createStatement();

        }catch (ClassNotFoundException e) {
            System.out.println("Exception in DBConnection: "+e.getMessage());
        }catch(SQLException ex) {
            System.out.println("Exception in DBConnection: " + ex.getMessage());
        }

    }

}
