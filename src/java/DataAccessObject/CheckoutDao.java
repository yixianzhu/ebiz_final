/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;
import Bean.CalebBean;
import Bean.MealBean;
import Servlet.WalkinLogin;
import DbConnect.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 *
 * @author xun yang
 */
public class CheckoutDao {
    private Connection connection;
   
    public CheckoutDao() {
        connection = DatabaseConnection.getConnection();
    }
    public CalebBean checkoutTable(String tableid, String employeeid) {
    
      CalebBean c=new CalebBean();
      try {
        String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String orderid = date+WalkinLogin.userid.substring(5);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select mealid, quantity, subtotal from confirmedcart where tableid='"+tableid+"'");
        double total=0;
            while (rs.next()) {
                total=total+rs.getDouble("subtotal");
                insertDetailOrder(orderid,rs.getString("mealid"),rs.getInt("quantity"));
            }
            double tip=total*0.1;
            double totalCharge=tip+total;
            c.setCost(totalCharge);
            insertorder(orderid, WalkinLogin.userid, total, tip, totalCharge,employeeid);
            deleteTable(tableid); 
        } catch (SQLException e) {
        System.err.println("A SQLException was caught: " + e.getMessage());
        }
      return c;
    }
     public void insertDetailOrder(String orderid, String mealid, int quantity) {
        try { 
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO IS2730.ORDERDETAIL (ORDERID, MEALID, QUANTITY) VALUES " +
                "('"+ orderid+"', '"+mealid+"',"+quantity+")");              
		} catch (SQLException e) {
		System.err.println("A SQLException was caught: " + e.getMessage());
		}
    }
     public void insertorder(String orderid, String strPhoneNumber, double totalCost, Double tips, Double charge, String employeeid) {
        try { 
            String years = orderid.substring(0,4);
            String month = orderid.substring(4,6);
            String date = orderid.substring(6,8);       
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO IS2730.ORDERS (ORDERID, PHONE, YEARS, MONTH, DATE, STAFFID, TIP, SUBTOTAL, TOTAL, WALKIN) VALUES " +
                "('"+ orderid+"', '"+strPhoneNumber+"', '"+years+"', '"+month+"', '"+date+"', '"+employeeid+"',"+tips+","+totalCost+","+charge+",'true')";
            statement.executeUpdate(sql);  
                
	    } catch (SQLException e) {
            System.err.println("A SQLException was caught: " + e.getMessage());
	    }
    }
      public void deleteTable(String tableid) {
        try { 
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from confirmedcart where tableid='"+tableid+"'");              
		} catch (SQLException e) {
		System.err.println("A SQLException was caught: " + e.getMessage());
		}
    }
}
