/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DbConnect.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zhuyixian
 */
public class giftcardDAO {
    private Connection connection;
    Statement st = null;
    ResultSet rs = null;
    String sql = "";

    public giftcardDAO() {
            //connect to database and select the record
            connection = DatabaseConnection.getConnection();	
        }

    public void recordPurchse(String purchaseid, String senderName, String senderEmail, String receiverName, String receiverEmail, String strAmount) {
        String years = purchaseid.substring(0,4);
        String month = purchaseid.substring(4,6);
        String day = purchaseid.substring(6,8);
        Double amount = Double.parseDouble(strAmount);
        try {
        	st = connection.createStatement();
            sql = "INSERT INTO IS2730.GIFTCARD(PURCHASEID, SENDERNAME, SENDEREMAIL, AMOUNT, RECEIVERNAME, SENDTOEMAIL, YEARS, MONTH, DAY) VALUES " +
                "('"+ purchaseid+"', '"+senderName+"', '"+senderEmail+"',"+amount+",'"+receiverName+"','"+receiverEmail+"','"+years+"','"+month+"','"+day+"')";
            st.executeUpdate(sql);   
        }catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
