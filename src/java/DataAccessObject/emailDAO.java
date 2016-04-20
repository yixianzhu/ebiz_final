/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import DbConnect.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zhuyixian
 */
public class emailDAO {
    private Connection connection;
    Statement st = null;
    ResultSet rs = null;
    String sql = "";

    public emailDAO() {
            //connect to database and select the record
            connection = DatabaseConnection.getConnection();	
        }
    
    public void togoEmail(String strEmail, String customername) {
        int count;
        try { 
            st = connection.createStatement();
            sql = "SELECT COUNT(*) AS ROWCOUNT FROM IS2730.EMAILLIST WHERE EMAIL='"+strEmail+"'";            
            rs = st.executeQuery(sql);

            rs.next();
            count = rs.getInt("ROWCOUNT");
            rs.close();

            if(count == 0){
				sql = "INSERT INTO IS2730.EMAILLIST (EMAIL, CNAME) VALUES " +
		            "('"+ strEmail+"', '"+customername+"')";
		        st.executeUpdate(sql);                  
			}  
    	}catch (SQLException e) {
			e.printStackTrace();
	}
    }
}
