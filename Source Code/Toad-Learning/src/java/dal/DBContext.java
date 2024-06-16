package dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FPT University - PRJ30X
 */



public class DBContext {
    protected Connection connection;

    public DBContext() {
        // You can modify these variables to match your system configuration.
        String user = "sa";
        String pass = "123";
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=SWP391_1";

        try {
            // Load the SQL Server JDBC driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Establish the connection to the database.
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            // Log the exception.
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

