package dto;

import java.sql.*;
import static dto.DBInfo.*;

public class DB_Connection {
    static Connection con = null;

    // Private constructor to prevent instantiation
    private DB_Connection() {
    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, password);
            System.out.println("Database connection established successfully!");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Please add the driver to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to establish database connection.");
            e.printStackTrace();
        }
    }

    // Returns the database connection
    public static Connection getCon() {
        return con;
    }

    // Close the connection (optional, depending on your usage)
    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
