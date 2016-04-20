/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.CartItemBean;
import DbConnect.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zhuyixian
 */
public class togoDAO {
    private Connection connection;
    Statement st = null;
    ResultSet rs = null;
    String sql = "";

    public togoDAO() {
            //connect to database and select the record
            connection = DatabaseConnection.getConnection();	
        }
    
    public void insertmeal(String orderid, CartItemBean cartItem) {
        try { 
            st = connection.createStatement();
            sql = "INSERT INTO IS2730.ORDERDETAIL (ORDERID, MEALID, QUANTITY) VALUES " +
                "('"+ orderid+"', '"+cartItem.getItemNo()+"',"+cartItem.getQuantity()+")";
                st.executeUpdate(sql);                  
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    void insertorder(String orderid, String strPhoneNumber, double totalCost, Double tips, Double charge) {
        try { 
            String years = orderid.substring(0,4);
            String month = orderid.substring(4,6);
            String date = orderid.substring(6,8);
           
            st = connection.createStatement();
            sql = "INSERT INTO IS2730.ORDERS (ORDERID, PHONE, YEARS, MONTH, DATE, STAFFID, TIP, SUBTOTAL, TOTAL, WALKIN) VALUES " +
                "('"+ orderid+"', '"+strPhoneNumber+"', '"+years+"', '"+month+"', '"+date+"', 'togo',"+tips+","+totalCost+","+charge+",'false')";
            st.executeUpdate(sql);  
                
	    } catch (SQLException e) {
            e.printStackTrace();
	    }
    }

    public void tellmanager(String orderid, String strPhoneNumber, String customername, String orderedmeals) {
        try { 
            String ordertime = orderid.substring(0,8);  
           
            st = connection.createStatement();
            sql = "INSERT INTO IS2730.TOGOTEMP (ORDERID, CNAME, PHONE, ORDERTIME, ORDEREDM, COOKED, COLLECTED) VALUES " +
                "('"+ orderid+"', '"+customername+"', '"+strPhoneNumber+"', '"+ordertime+"', '"+orderedmeals+"','false','false')";
            st.executeUpdate(sql);  
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
