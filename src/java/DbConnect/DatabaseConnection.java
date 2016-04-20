/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnect;

/**
 *
 * @author xun yang
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try
            {Class.forName("org.apache.derby.jdbc.ClientDriver");
            String connectionURL = "jdbc:derby://localhost:1527/is2730";
            connection = DriverManager.getConnection(connectionURL, "is2730", "is2730");
            } catch (ClassNotFoundException e) {
               System.err.println("A ClassNotFound Exception was caught: " + e.getMessage());
            } catch (SQLException e) {
               System.err.println("A SQLException was caught: " + e.getMessage());
            }
            return connection;
        }

    }  
}
