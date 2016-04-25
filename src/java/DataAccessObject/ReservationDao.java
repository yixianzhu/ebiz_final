/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Bean.CalebBean;
import DbConnect.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xun yang
 */
public class ReservationDao {
    private Connection connection;

    public ReservationDao() {
        connection = DatabaseConnection.getConnection();
    }
    public void addReservation(CalebBean user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into reservation(phone,firstname,lastname,email,time,guest,date) values (?, ?, ?, ? ,?,?,?)");
            preparedStatement.setString(1, user.getPhone());
            preparedStatement.setString(2, user.getFname());
            preparedStatement.setString(3, user.getLname());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getTime());
            preparedStatement.setString(6, user.getGuest());
            preparedStatement.setString(7, user.getDate());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
    public boolean notification(){
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from reservation");
            while (rs.next()) {
                return true;
            }
            }
        catch (SQLException e) {
        System.err.println("A SQLException was caught: " + e.getMessage());
        }
        return false;
    }
    
    public List<CalebBean> getAllReservation(){
        List<CalebBean> users = new ArrayList<CalebBean>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from reservation");
            while (rs.next()) {
                CalebBean user = new CalebBean();
                user.setFname(rs.getString("firstname"));
                user.setLname(rs.getString("lastname"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setDate(rs.getString("date"));
                user.setTime(rs.getString("time"));
                user.setGuest(rs.getString("guest"));                
                users.add(user);
            }
        } catch (SQLException e) {
        System.err.println("A SQLException was caught: " + e.getMessage());
        }

        return users;
    }
    
    public void deleteReservation(String phone){
         try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from reservation where phone=?");            
            preparedStatement.setString(1, phone);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           System.err.println("A SQLException was caught: " + e.getMessage());
        }
    }
}
