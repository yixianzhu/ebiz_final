/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Bean.HistoryBean;
import DbConnect.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xun yang
 */
public class HistoryOrderDao {
    private Connection connection;

    public HistoryOrderDao() {
        connection = DatabaseConnection.getConnection();
    }
     public List<HistoryBean> getStaffPerformance(){
        List<HistoryBean> histories = new ArrayList<HistoryBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select staffid, sum(total) as s from orders group by staffid");
            while (rs.next()) {
                HistoryBean history = new HistoryBean();
                history.setStaffid(rs.getString("staffid"));
                history.setSale(rs.getDouble("s"));              
                histories.add(history);
            }
        } catch (SQLException e) {
        System.err.println("A SQLException was caught: " + e.getMessage());
        }

        return histories;
    }
     
      public List<HistoryBean> getBusinessAnalysis(){
        List<HistoryBean> histories = new ArrayList<HistoryBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select mealid, sum(quantity) as s from orderdetail group by mealid");
            while (rs.next()) {
                System.out.println("hi,yang");
                HistoryBean history = new HistoryBean();
                history.setMealid(rs.getString("mealid"));
             //   history.setMealname(rs.getString("name"));
                history.setQuantity(rs.getInt("s"));              
                histories.add(history);
            }
        } catch (SQLException e) {
        System.err.println("A SQLException was caught: " + e.getMessage());
        }

        return histories;
    }
}
